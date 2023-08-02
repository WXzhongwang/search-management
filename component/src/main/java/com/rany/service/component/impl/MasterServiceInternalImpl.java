package com.rany.service.component.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.rany.service.common.constants.Constants;
import com.rany.service.common.enums.EnvEnum;
import com.rany.service.common.exception.ErrorCodeEnum;
import com.rany.service.common.exception.SearchManagementException;
import com.rany.service.common.toolkit.DateUtility;
import com.rany.service.component.IMetaStorage;
import com.rany.service.component.MetaStoreEnum;
import com.rany.service.component.config.MetaStoreConfig;
import com.rany.service.component.es.AdvancedEsClient;
import com.rany.service.component.meta.ClusterMeta;
import com.rany.service.component.meta.ProjectMeta;
import com.rany.service.component.meta.dto.*;
import com.rany.service.component.metric.*;
import com.rany.service.component.store.MySQLStore;
import com.rany.service.component.utils.JSONUtility;
import com.rany.service.component.utils.MetaUtility;
import com.rany.service.platform.DataTypeUtils;
import com.rany.service.platform.meta.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 内部实际实现
 *
 * @author zhongshengwang
 */
public class MasterServiceInternalImpl {

    private static final Logger logger = LoggerFactory.getLogger(MasterServiceInternalImpl.class);
    private static final Logger backgroundLogger = LoggerFactory.getLogger("background");
    /**
     * 环境
     */
    private final String profile;
    /**
     * 元数据存储类型
     */
    private final MetaStoreEnum metaType;

    /**
     * 运行状态
     */
    private volatile RUNNING_STATUS status;

    /**
     * 元数据存储接口
     */
    private final IMetaStorage metaStore;
    /**
     * 后台任务是否运行
     */
    private volatile boolean backgroundRunning;
    /**
     * 后台任务运行线程池
     */
    private final ScheduledExecutorService backgroundTaskExecutor;
    /**
     * 接口锁
     */
    private final Object adminLockObject;

    /**
     * 读写锁
     */
    private final ReentrantReadWriteLock lock;
    private final Map<String, AdvancedEsClient> esClientMap = new ConcurrentHashMap<>();
    private final Map<String, ClusterMetaData> clusterMetaMap = new ConcurrentHashMap<>();
    private final Map<String, ProjectMetaData> projectMetaMap = new ConcurrentHashMap<>();
    private ScheduledFuture<?> healthCheckFuture;
    private ScheduledFuture<?> autoIndexRollingFuture;
    private ScheduledFuture<?> metricRefresherFuture;
    private ScheduledFuture<?> syncMetaFuture;

    public MasterServiceInternalImpl(String profile, MetaStoreConfig metaStoreConfig) {
        logger.info("Begin to call MasterServiceInternalImpl::start().");
        lock = new ReentrantReadWriteLock();
        adminLockObject = new Object();
        this.profile = profile;
        this.metaType = metaStoreConfig.getMetaStoreType();
        logger.info("Current meta store type: {}.", this.metaType.name());
        this.metaStore = metaStoreConfig.getMetaStorage();
        backgroundTaskExecutor = Executors.newScheduledThreadPool(2);
        backgroundRunning = false;
    }

    public boolean start() {
        // 建表
        this.setupTables();
        // 加载元数据
        this.loadMeta();
        // 预加载connections
        this.prepareConnections();
        // 加载动态数据(集群，索引相关数据)
        this.warmingUp();
        this.warmingUpIndexSchema();
        // 预统计
        this.calculate();
        // 启动后台线程
        this.startBackgroundExecutors();

        // Service is running under readonly mode on pre environment.
        if (profile.equalsIgnoreCase(EnvEnum.UAT.name())) {
            status = RUNNING_STATUS.READONLY;
        } else {
            status = RUNNING_STATUS.NORMAL;
        }
        return true;
    }

    public void stop() {
        status = RUNNING_STATUS.STOPPING;
        this.stopBackgroundExecutors();
    }

    /**
     * 建表
     */
    public void setupTables() {
        if (metaStore instanceof MySQLStore) {
            ((MySQLStore) metaStore).setupTables();
        }
    }

    /**
     * 装载元数据
     */
    public void loadMeta() {
        logger.info("MasterServiceInternalImpl start to load all meta from persistent storage.");
        // 加载meta元数据
        List<ClusterMetaData> clusterMetaData = metaStore.loadAllMeta();
        for (ClusterMetaData clusterMeta : clusterMetaData) {
            clusterMetaMap.put(clusterMeta.clusterName, clusterMeta);
            for (ProjectMetaData projectMeta : clusterMeta.projectMetaMap.values()) {
                projectMetaMap.put(projectMeta.projectName, projectMeta);
            }
        }
        logger.info("There are {} clusters and {} projects managed.", clusterMetaData.size(), projectMetaMap.size());
        logger.info("MasterServiceInternalImpl finish to load all meta from persistent storage.");
    }

    /**
     * 预加载链接
     */
    public void prepareConnections() {
        for (Map.Entry<String, ClusterMetaData> cluster : clusterMetaMap.entrySet()) {
            ClusterMetaData meta = cluster.getValue();
            AdvancedEsClient esClient = new AdvancedEsClient(meta.clusterInternalAddress);
            esClientMap.put(meta.clusterName, esClient);
        }
    }

    /**
     * 预热集群，索引的数据
     */
    public void warmingUp() {
        logger.info("MasterServiceInternalImpl start to load all dynamic info meta from es.");
        for (ClusterMetaData cluster : clusterMetaMap.values()) {
            if (cluster.clusterStatus == ClusterStatus.IN_SERVICE) {
                try {
                    ClusterMetaData tmpClusterMeta = esClientMap.get(cluster.clusterName).getClusterMeta();
                    cluster.nodeMetaList = tmpClusterMeta.nodeMetaList;
                    cluster.esVersion = tmpClusterMeta.esVersion;
                    cluster.clusterHealth = tmpClusterMeta.clusterHealth;
                } catch (Exception e) {
                    logger.error("Fail to call acquire cluster info", e);
                }
            }

            for (ProjectMetaData projectMeta : cluster.projectMetaMap.values()) {
                // 索引组
                for (IndexTemplateMetaData IndexTemplateMeta : projectMeta.indexTemplateMetaData.values()) {
                    // 索引
                    for (IndexMetaData indexMeta : IndexTemplateMeta.indexMetas.values()) {
                        try {
                            IndexMetaData tmpIndexMeta = esClientMap.get(cluster.clusterName).acquireIndexInfo(indexMeta.fullName);
                            indexMeta.totalData = tmpIndexMeta.totalData;
                            indexMeta.docs = tmpIndexMeta.docs;
                            indexMeta.health = tmpIndexMeta.health;
                            indexMeta.primaryShards = tmpIndexMeta.primaryShards;
                            indexMeta.replicaShards = tmpIndexMeta.replicaShards;
                        } catch (Exception e) {
                            logger.error("Fails to call acquire index info .", e);
                        }
                    }
                }
            }
        }
        logger.info("MasterServiceInternalImpl finish to load all dynamic info meta from es.");
    }


    /**
     * 预热索引schema
     */
    public void warmingUpIndexSchema() {
        logger.info("MasterServiceInternalImpl start to load all index schema meta from es.");
        for (ClusterMetaData clusterMeta : clusterMetaMap.values()) {
            // 项目
            for (ProjectMetaData projectMeta : clusterMeta.projectMetaMap.values()) {
                // 模板
                for (IndexTemplateMetaData indexTemplateMetaData : projectMeta.indexTemplateMetaData.values()) {
                    // 索引
                    for (IndexMetaData indexMeta : indexTemplateMetaData.indexMetas.values()) {
                        try {
                            IndexMetaData tmpIndexMeta = esClientMap.get(clusterMeta.clusterName).acquireIndexSchema(indexMeta.fullName);
                            for (String alias : tmpIndexMeta.aliases) {
                                String aliasName = DataTypeUtils.getAliasName(alias);
                                String fullAliasName = DataTypeUtils.combineFullAliasName(projectMeta.projectName, indexTemplateMetaData.templateName, aliasName);
                                // If the original alias name is equal to correct full alias name, add this alias;
                                if (fullAliasName.equalsIgnoreCase(alias)) {
                                    indexMeta.aliases.add(aliasName);
                                }
                            }
                            indexMeta.setting = tmpIndexMeta.setting;
                            indexMeta.mapping = tmpIndexMeta.mapping;
                        } catch (Exception e) {
                            logger.error("Fail to call acquire index schema.", e);
                        }
                    }
                }
            }
        }
        logger.info("MasterServiceInternalImpl finish to load all index schema meta from es.");
    }


    public void calculate() {
        logger.info("MasterServiceInternalImpl start to calculate system metric.");
        List<ClusterMetaData> values = Lists.newArrayList(clusterMetaMap.values());
        SystemMetricCounter metricCounter = MetricUtils.calculateSystemMetric(values);
        logger.info("There are {} clusters, {} projects, {} template, {} index, {} docs and {} data.",
                metricCounter.totalCluster,
                metricCounter.totalProject,
                metricCounter.totalTemplate,
                metricCounter.totalIndex,
                metricCounter.totalDocs,
                metricCounter.totalDataSize);
        logger.info("MasterServiceInternalImpl finish to calculate system metric.");
    }

    /**
     * 启动后台线程
     */
    private void startBackgroundExecutors() {
        HealthChecker healthCheckExecutorTask = new HealthChecker();
        healthCheckFuture = backgroundTaskExecutor.scheduleAtFixedRate(healthCheckExecutorTask, 0, 120, TimeUnit.SECONDS);

        IndexMetricRefresher metricRefresher = new IndexMetricRefresher();
        metricRefresherFuture = backgroundTaskExecutor.scheduleAtFixedRate(metricRefresher, 0, 30, TimeUnit.SECONDS);

        SyncMetaWorker syncMetaWorker = new SyncMetaWorker();
        syncMetaFuture = backgroundTaskExecutor.scheduleAtFixedRate(syncMetaWorker, 0, 3600, TimeUnit.SECONDS);

        AutoIndexRollingWorker autoIndexRollingWorker = new AutoIndexRollingWorker();
        autoIndexRollingFuture = backgroundTaskExecutor.scheduleAtFixedRate(autoIndexRollingWorker, 0, 10, TimeUnit.SECONDS);
        backgroundRunning = true;
    }

    /**
     * 停止后端线程
     */
    private void stopBackgroundExecutors() {
        healthCheckFuture.cancel(false);
        metricRefresherFuture.cancel(false);
        syncMetaFuture.cancel(false);
        autoIndexRollingFuture.cancel(false);
        backgroundRunning = false;
    }


    /**
     * Enumeration type for status of this server.
     */
    enum RUNNING_STATUS {
        NOT_READY,
        NORMAL,
        READONLY,
        SUSPEND,
        STOPPING
    }


    /**
     * 检查健康状况
     */
    class HealthChecker implements Runnable {

        @Override
        public void run() {
            backgroundLogger.info("Begin to execute health check.");
            HashMap<String, AdvancedEsClient> tmpClusterConnectionMap = new HashMap<>();
            long endHoldReadLock = 0, startHoldReadLock = 0;
            ReentrantReadWriteLock.ReadLock readLock = MasterServiceInternalImpl.this.lock.readLock();
            startHoldReadLock = System.nanoTime();
            readLock.lock();

            for (ClusterMetaData clusterMeta : clusterMetaMap.values()) {
                if (clusterMeta.clusterStatus != ClusterStatus.IN_SERVICE) {
                    continue;
                }
                AdvancedEsClient esClient = new AdvancedEsClient(clusterMeta.clusterInternalAddress);
                tmpClusterConnectionMap.put(clusterMeta.clusterName, esClient);
            }
            readLock.unlock();
            endHoldReadLock = System.nanoTime();

            long startCheckMetaStore = 0, endCheckMetaStore = 0;
            startCheckMetaStore = System.nanoTime();
            try {
                metaStore.checkHealth();
            } catch (Exception e) {
                backgroundLogger.error("MetaStore health check failed, address:{}.", metaStore.
                        getMetaStoreAddress(), e);
            }
            endCheckMetaStore = System.nanoTime();

            long startCheckEsConnection = 0, endCheckEsConnection = 0;
            startCheckEsConnection = System.nanoTime();
            for (String clusterName : tmpClusterConnectionMap.keySet()) {
                AdvancedEsClient client = tmpClusterConnectionMap.get(clusterName);
                try {
                    client.checkHealth();
                } catch (Exception e) {
                    backgroundLogger.error("ES connection health check failed, address:{}.", clusterName, e);
                }
            }
            endCheckEsConnection = System.nanoTime();
            tmpClusterConnectionMap = null;

            backgroundLogger.info("Time cost of health check: holdReadLock:{} ms, checkMetaStore:{} ms, checkESConnection:{} ms.",
                    (endHoldReadLock - startHoldReadLock) / 1000000,
                    (endCheckMetaStore - startCheckMetaStore) / 1000000,
                    (endCheckEsConnection - startCheckEsConnection) / 1000000);
            backgroundLogger.info("Finish to execute health check.");
        }
    }


    /**
     * 自动索引
     */
    class AutoIndexRollingWorker implements Runnable {

        @Override
        public void run() {
            backgroundLogger.info("Begin to execute auto index rolling.");
            long endHoldWriteLock = 0, startHoldWriteLock = 0;
            ReentrantReadWriteLock.WriteLock writeLock = MasterServiceInternalImpl.this.lock.writeLock();
            startHoldWriteLock = System.nanoTime();
            writeLock.lock();

            boolean needCreate = false, needDelete = false;
            for (ProjectMetaData projectMeta : projectMetaMap.values()) {
                for (IndexTemplateMetaData templateMetaData : projectMeta.indexTemplateMetaData.values()) {
                    if (templateMetaData.autoIndexRollingPolicy != AutoIndexRollingPolicy.NONE) {
                        needCreate = createRollingIndex(projectMeta, templateMetaData, esClientMap.get(projectMeta.clusterName));
                        if (needCreate || needCreate) {
                            break;
                        }
                    }
                }
                if (needCreate || needCreate) {
                    break;
                }
            }
            writeLock.unlock();
            endHoldWriteLock = System.nanoTime();
            backgroundLogger.info("Time breakdown of AutoIndexRollingExecutor:run(): holdWriteLock:{} ms.", (endHoldWriteLock - startHoldWriteLock) / 1000000);
            backgroundLogger.info("Finish to execute auto index rolling.");
        }
    }


    private boolean createRollingIndex(ProjectMetaData projectMeta, IndexTemplateMetaData template, AdvancedEsClient esClient) {
        boolean result = false;
        LocalDate today = LocalDateTime.now().toLocalDate();
        String newIndexName = null;
        boolean useNamePrefix;
        if (template.autoIndexNamePrefix.equalsIgnoreCase("")) {
            useNamePrefix = false;
        } else {
            useNamePrefix = true;
        }
        for (int i = 0; i < template.autoIndexRollingWindow + 1; ++i) {
            switch (template.autoIndexRollingPolicy) {
                case DAY:
                    if (useNamePrefix) {
                        newIndexName = String.format("%s-%s", template.autoIndexNamePrefix, DateUtility.getIndexDayName(today, 1 - i));
                    } else {
                        newIndexName = String.format("%s", DateUtility.getIndexDayName(today, 1 - i));
                    }
                    break;
                case MONTH:
                    if (useNamePrefix) {
                        newIndexName = String.format("%s-%s", template.autoIndexNamePrefix, DateUtility.getIndexMonthName(today, 1 - i));
                    } else {
                        newIndexName = String.format("%s", DateUtility.getIndexMonthName(today, 1 - i));
                    }
                    break;
                case QUARTER:
                    if (useNamePrefix) {
                        newIndexName = String.format("%s-%s", template.autoIndexNamePrefix, DateUtility.getIndexQuarterName(today, 1 - i));
                    } else {
                        newIndexName = String.format("%s", DateUtility.getIndexQuarterName(today, 1 - i));
                    }
                    break;
                case HALF_YEAR:
                    if (useNamePrefix) {
                        newIndexName = String.format("%s-%s", template.autoIndexNamePrefix, DateUtility.getIndexHalfYear(today, 1 - i));
                    } else {
                        newIndexName = String.format("%s", DateUtility.getIndexHalfYear(today, 1 - i));
                    }
                    break;
                case YEAR:
                    if (useNamePrefix) {
                        newIndexName = String.format("%s-%s", template.autoIndexNamePrefix, DateUtility.getIndexYearName(today, 1 - i));
                    } else {
                        newIndexName = String.format("%s", DateUtility.getIndexYearName(today, 1 - i));
                    }
                    break;
                default:
                    break;
            }
            if (!template.indexMetas.containsKey(newIndexName)) {
                try {
                    createAutoIndex(projectMeta, template, esClient, newIndexName);
                    result = true;
                } catch (Exception e) {
                }
            }
        }
        return result;
    }


    private void createAutoIndex(ProjectMetaData projectMeta, IndexTemplateMetaData templateMeta, AdvancedEsClient esClient, String indexName) {
        IndexMetaData indexMeta = new IndexMetaData();
        indexMeta.name = indexName;
        indexMeta.legacy = false;
        indexMeta.fullName = DataTypeUtils.combineFullIndexName(projectMeta.projectName, templateMeta.templateName, indexMeta.name);
        indexMeta.templateName = templateMeta.templateName;
        indexMeta.projectName = projectMeta.projectName;
        String mappings = templateMeta.mappings;
        String settings = templateMeta.settings;
        List<String> aliases = templateMeta.aliasList;
        List<String> fullIndexAliases = new ArrayList<>();
        for (String alias : templateMeta.aliasList) {
            String aliasName = DataTypeUtils.combineFullIndexName(projectMeta.projectName, templateMeta.templateName, alias);
            fullIndexAliases.add(aliasName);
        }
        try {
            esClient.createIndex(indexMeta.fullName, fullIndexAliases, mappings, settings);
        } catch (SearchManagementException e) {
            logger.error("Exception in AutoIndexRollingExecutor::createAutoIndex() when creating ES index.", e);
            throw e;
        }

        logger.info("Index [project={}][template={}][name={}][fullName={}] has been automatically created on ElasticSearch cluster.",
                projectMeta.projectName, templateMeta.templateName, indexMeta.name, indexMeta.fullName);

        indexMeta.aliases = aliases;
        indexMeta.mapping = mappings;
        indexMeta.setting = settings;
        indexMeta.tags = "";
        indexMeta.docs = 0;
        indexMeta.totalData = 0;
        indexMeta.gmtCreate = new Timestamp(LocalDateTime.now().getNano());
        indexMeta.gmtModified = new Timestamp(LocalDateTime.now().getNano());
        indexMeta.health = Constants.UNKNOWN;

        metaStore.insertIndex(indexMeta);
        templateMeta.indexMetas.put(indexMeta.name, indexMeta);
    }

    /**
     * 索引指标刷新
     */
    class IndexMetricRefresher implements Runnable {

        @Override
        public void run() {
            backgroundLogger.info("Begin to execute IndexMetricRefresher.");
            HashMap<String, AdvancedEsClient> tmpClusterConnectionMap = new HashMap<>();
            HashMap<String, ClusterMetaData> tmpClusterMetaMap = new HashMap<>();
            HashMap<String, List<IndexMetaData>> tmpClusterIndexMetaListMap = new HashMap<>();

            // 读锁耗时
            long startHoldReadLock = 0, endHoldReadLock = 0;
            ReentrantReadWriteLock.ReadLock readLock = MasterServiceInternalImpl.this.lock.readLock();
            startHoldReadLock = System.nanoTime();
            readLock.lock();
            for (ClusterMetaData clusterMeta : clusterMetaMap.values()) {
                if (clusterMeta.clusterStatus != ClusterStatus.IN_SERVICE) {
                    continue;
                }
                tmpClusterConnectionMap.put(clusterMeta.clusterName, esClientMap.get(clusterMeta.clusterName));
            }
            readLock.unlock();
            endHoldReadLock = System.nanoTime();

            // 获取数据耗时
            long startGetData = 0, endGetData = 0;
            startGetData = System.nanoTime();
            for (String clusterName : tmpClusterConnectionMap.keySet()) {
                AdvancedEsClient client = tmpClusterConnectionMap.get(clusterName);

                ClusterMetaData newClusterMeta = client.getClusterMeta();
                tmpClusterMetaMap.put(clusterName, newClusterMeta);

                List<IndexMetaData> metaList = client.acquireIndexInfo();
                tmpClusterIndexMetaListMap.put(clusterName, metaList);
            }
            endGetData = System.nanoTime();

            // 写锁耗时
            long startHoldWriteLock = 0, endHoldWriteLock = 0;
            ReentrantReadWriteLock.WriteLock writeLock = MasterServiceInternalImpl.this.lock.writeLock();
            startHoldWriteLock = System.nanoTime();
            writeLock.lock();
            for (ClusterMetaData clusterMeta : clusterMetaMap.values()) {
                ClusterMetaData newClusterMeta = tmpClusterMetaMap.get(clusterMeta.clusterName);
                if (newClusterMeta == null) {
                    continue;
                }
                clusterMeta.nodeMetaList = newClusterMeta.nodeMetaList;
                clusterMeta.esVersion = newClusterMeta.esVersion;
                clusterMeta.clusterHealth = newClusterMeta.clusterHealth;
                List<IndexMetaData> metaList = tmpClusterIndexMetaListMap.get(clusterMeta.clusterName);
                if (metaList == null) {
                    continue;
                }
                for (IndexMetaData tmpIndexMeta : metaList) {
                    if (DataTypeUtils.isInternalIndex(tmpIndexMeta.fullName)) {
                        continue;
                    }
                    if (DataTypeUtils.isLegacy(tmpIndexMeta.fullName)) {
                        continue;
                    }
                    String projectName = null, indexTemplateName = null, indexName = null;
                    String[] parts = tmpIndexMeta.fullName.split("\\.");
                    projectName = parts[0];
                    indexTemplateName = parts[1];
                    indexName = parts[2];

                    if (projectName == null || indexTemplateName == null) {
                        continue;
                    }
                    ProjectMetaData projectMeta = projectMetaMap.get(projectName);
                    if (projectMeta == null) {
                        continue;
                    }
                    IndexTemplateMetaData templateMeta = projectMeta.indexTemplateMetaData.get(indexTemplateName);
                    if (templateMeta == null) {
                        continue;
                    }
                    IndexMetaData indexMeta = templateMeta.indexMetas.get(indexName);
                    if (indexMeta == null) {
                        continue;
                    }
                    indexMeta.totalData = tmpIndexMeta.totalData;
                    indexMeta.docs = tmpIndexMeta.docs;
                    indexMeta.health = tmpIndexMeta.health;
                    indexMeta.primaryShards = tmpIndexMeta.primaryShards;
                    indexMeta.replicaShards = tmpIndexMeta.replicaShards;
                }
            }
            writeLock.unlock();
            endHoldWriteLock = System.nanoTime();
            tmpClusterConnectionMap.clear();
            tmpClusterIndexMetaListMap.clear();
            tmpClusterMetaMap.clear();
            backgroundLogger.info("Time breakdown of MasterServiceInternalImpl::IndexMetricRefresher: holdReadLock:{} ms, holdWriteLock:{} ms, getData:{} ms.",
                    (endHoldReadLock - startHoldReadLock) / 1000000,
                    (endHoldWriteLock - startHoldWriteLock) / 1000000,
                    (endGetData - startGetData) / 1000000);
            backgroundLogger.info("Finish to execute IndexMetricRefresher.");
        }
    }


    /**
     * 同步元数据
     */
    class SyncMetaWorker implements Runnable {

        @Override
        public void run() {
            backgroundLogger.info("Begin to execute SyncMetaWorker.");
            long endHoldWriteLock = 0, startHoldWriteLock = 0;
            startHoldWriteLock = System.nanoTime();
            ReentrantReadWriteLock.WriteLock writeLock = MasterServiceInternalImpl.this.lock.writeLock();
            writeLock.lock();

            clusterMetaMap.clear();
            for (AdvancedEsClient client : esClientMap.values()) {
                client.close();
            }
            esClientMap.clear();
            loadMeta();
            prepareConnections();
            warmingUp();
            warmingUpIndexSchema();

            writeLock.unlock();
            endHoldWriteLock = System.nanoTime();
            backgroundLogger.info("Time breakdown of MasterServiceInternalImpl::SyncAllMetaExecutor: holdWriteLock:{} ms.",
                    (endHoldWriteLock - startHoldWriteLock) / 1000000);
            backgroundLogger.info("Finish to execute SyncMetaWorker.");
        }
    }


    /**
     * 内部方案
     */

    public void setReadonly() {
        setServiceMode(RUNNING_STATUS.READONLY);
    }

    public void setNormal() {
        setServiceMode(RUNNING_STATUS.NORMAL);
    }

    public void setSuspend() {
        setServiceMode(RUNNING_STATUS.SUSPEND);
    }

    private void setServiceMode(RUNNING_STATUS status) {
        if (status == RUNNING_STATUS.NOT_READY || status == RUNNING_STATUS.STOPPING) {
            throw new SearchManagementException(ErrorCodeEnum.INTERNAL_ERROR.getCode(), "service status can't be changed when starting or stopping.");
        }
        this.status = status;
    }

    public RUNNING_STATUS getStatus() {
        return status;
    }

    public void suspendBackgroundExecutors() {
        synchronized (adminLockObject) {
            stopBackgroundExecutors();
        }
    }

    public void resumeBackgroundExecutors() {
        synchronized (adminLockObject) {
            startBackgroundExecutors();
        }
    }

    public boolean getBackgroundExecutorsStatus() {
        return backgroundRunning;
    }


    /**
     * 集群相关操作
     * 创建集群
     */
    public void createCluster(ClusterMeta cluster) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        try {
            long startGetLock = System.nanoTime();
            writeLock.lock();
            long endGetLock = System.nanoTime();

            if (clusterMetaMap.containsKey(cluster.clusterName)) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_ALREADY_EXIST.getCode(), String.format("Cluster [%s] already exists.", cluster.clusterName));
            }
            ClusterMetaData meta = new ClusterMetaData();
            BeanUtils.copyProperties(cluster, meta);

            meta.clusterHealth = Constants.UNKNOWN;
            meta.esVersion = "{}";
            meta.nodeMetaList = new ArrayList<NodeMeta>();
            meta.projectMetaMap = new HashMap<String, ProjectMetaData>();

            // Write meta into persistent storage;
            long startInsertMeta = System.nanoTime();
            metaStore.insertCluster(meta);
            long endInsertMeta = System.nanoTime();
            logger.info("ClusterMeta of cluster [name={}] has been written into persistent storage with the following content: \n" +
                            "serviceEndpoint={}\n" + "" +
                            "internalEndpoint={}\n" +
                            "type={}\n" +
                            "status={}\n" +
                            "description={}\n" +
                            "createTime={}",
                    meta.clusterName,
                    meta.clusterAddress,
                    meta.clusterInternalAddress,
                    meta.clusterType,
                    meta.clusterStatus,
                    meta.clusterDesc,
                    meta.gmtCreate);

            // Init a client to connect to ElasticSearch cluster;
            clusterMetaMap.put(meta.clusterName, meta);
            logger.info("ClusterMeta of cluster [name={}] has been written into memory.", meta.clusterName);

            long startConnectEs = System.nanoTime();
            esClientMap.put(meta.clusterName, new AdvancedEsClient(meta.clusterInternalAddress));
            logger.info("Connection to cluster [name={}][address={}] has been established.", meta.clusterName, meta.clusterInternalAddress);
            long endConnectEs = System.nanoTime();

            logger.info("Time breakdown of MasterServiceInternalImpl::insertCluster: getLock:{} ms, insertMeta:{} ms, connectES:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endInsertMeta - startInsertMeta) / 1000000,
                    (endConnectEs - startConnectEs) / 1000000);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 更新集群信息
     *
     * @param cluster
     */
    public void updateCluster(ClusterMeta cluster) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        ClusterMetaData metaData;
        try {
            long startGetLock = System.nanoTime();
            writeLock.lock();
            long endGetLock = System.nanoTime();

            metaData = clusterMetaMap.get(cluster.clusterName);
            if (metaData == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(),
                        String.format("Cluster [%s] does not exist.", cluster.clusterName));
            }
            long lastUpdateTime = System.currentTimeMillis();
            long startUpdateMeta = System.nanoTime();

            ClusterMetaData meta = new ClusterMetaData();
            BeanUtils.copyProperties(cluster, meta);
            metaStore.updateCluster(meta);

            long endUpdateMeta = System.nanoTime();
            logger.info("ClusterMeta of cluster [name={}] has been updated in persistent storage with the following content: \n" +
                            "status={}\n" +
                            "description={}",
                    meta.clusterName, meta.clusterStatus, meta.clusterDesc);

            if (cluster.clusterStatus != null) {
                metaData.clusterStatus = meta.clusterStatus;
            }
            if (cluster.clusterDesc != null) {
                metaData.clusterDesc = meta.clusterDesc;
            }
            if (cluster.clusterInternalAddress != null) {
                // Update internal endpoint of ElasticSearch cluster;
                metaData.clusterInternalAddress = meta.clusterInternalAddress;
                AdvancedEsClient client = esClientMap.remove(meta.clusterName);
                client.close();
                esClientMap.put(meta.clusterName, new AdvancedEsClient(cluster.clusterInternalAddress));
            }
            metaData.gmtModified = cluster.gmtModified;
            logger.info("ClusterMeta of cluster [name={}] has been updated in memory.", meta.clusterName);
            logger.info("Time breakdown of MasterServiceInternalImpl::updateCluster: getLock:{} ms, updateMeta:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endUpdateMeta - startUpdateMeta) / 1000000);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 删除集群
     */
    public void deleteCluster(String clusterName) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        try {
            long startGetLock = System.nanoTime();
            writeLock.lock();
            long endGetLock = System.nanoTime();

            if (!clusterMetaMap.containsKey(clusterName)) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(), String.format("Cluster [%s] does not exist.", clusterName));
            }
            ClusterMetaData clusterMeta = clusterMetaMap.get(clusterName);
            if (clusterMeta.projectMetaMap.size() != 0) {
                throw new SearchManagementException(ErrorCodeEnum.CLUSTER_NOT_EMPTY.getCode(), String.format("Cluster [%s] is not empty and can't be deleted."));
            }
            long startDeleteMeta = System.nanoTime();
            metaStore.deleteCluster(clusterName);
            long endDeleteMeta = System.nanoTime();
            logger.info("ClusterMeta of cluster [name={}] has been deleted from persistent storage.", clusterName);

            clusterMetaMap.remove(clusterName);
            logger.info("ClusterMeta of cluster [name={}] has been deleted from memory.", clusterName);

            AdvancedEsClient client = esClientMap.remove(clusterName);
            client.close();
            logger.info("Connection to cluster [name={}] has been closed and destroyed.", clusterName);
            logger.info("Time breakdown of MasterServiceInternalImpl::deleteCluster: getLock:{} ms, deleteMeta:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endDeleteMeta - startDeleteMeta) / 1000000);
        } finally {
            writeLock.unlock();
        }
    }

    public ClusterInfo getCluster(String clusterName) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

        ClusterInfo result = null;
        try {
            long startGetLock = System.nanoTime();
            readLock.lock();
            long endGetLock = System.nanoTime();

            ClusterMetaData meta = clusterMetaMap.get(clusterName);
            if (meta == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(),
                        String.format("Cluster [%s] does not exist.", clusterName));
            }

            long startGetData = System.nanoTime();
            ClusterMetricCounter counter = MetricUtils.calculateClusterMetric(meta);
            result = MetaUtility.build(meta, counter);
            long endGetData = System.nanoTime();

            logger.info("ClusterMeta of cluster [name={}] has been queried.", clusterName);
            logger.info("Time breakdown of MasterServiceInternalImpl::getCluster: getLock:{} ms, getData:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endGetData - startGetData) / 1000000);
        } finally {
            readLock.unlock();
        }
        return result;
    }

    public List<ClusterInfo> getClusters() {
        long startGetLock = 0, endGetLock = 0, startGetData = 0, endGetData = 0;
        ArrayList<ClusterInfo> result = new ArrayList<ClusterInfo>();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        try {
            startGetLock = System.nanoTime();
            readLock.lock();
            endGetLock = System.nanoTime();

            startGetData = System.nanoTime();
            for (Map.Entry<String, ClusterMetaData> entry : clusterMetaMap.entrySet()) {
                ClusterMetaData clusterMeta = entry.getValue();
                ClusterMetricCounter counter = MetricUtils.calculateClusterMetric(clusterMeta);
                ClusterInfo cluster = MetaUtility.build(clusterMeta, counter);
                result.add(cluster);
            }
            endGetData = System.nanoTime();
            logger.info("getClusters is called.");
            logger.info("Time breakdown of MasterServiceInternalImpl::getClusters: getLock:{} ms, getData:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endGetData - startGetData) / 1000000);
        } finally {
            readLock.unlock();
        }
        return result;
    }

    public void insertProject(ProjectMeta info) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        try {
            long startGetLock = System.nanoTime();
            writeLock.lock();
            long endGetLock = System.nanoTime();

            ClusterMetaData clusterMeta = clusterMetaMap.get(info.clusterName);
            if (clusterMeta == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(), String.format("Cluster [%s] does not exist.",
                        info.clusterName));
            }
            if (clusterMeta.clusterStatus != ClusterStatus.IN_SERVICE) {
                throw new SearchManagementException(ErrorCodeEnum.PARAM_CHECK_ERROR.getCode(),
                        String.format("Cluster [%s] is not in service.", info.clusterName));
            }
            if (projectMetaMap.containsKey(info.projectName)) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_ALREADY_EXIST.getCode(),
                        String.format("Project [%s] already exists.", info.projectName));
            }

            // put a new project meta into the root project meta map;
            ProjectMetaData meta = new ProjectMetaData();
            meta.projectName = info.projectName;
            meta.projectDesc = info.projectDesc;
            meta.clusterName = info.clusterName;
            meta.indexTemplateMetaData = new HashMap<String, IndexTemplateMetaData>();
            meta.gmtCreate = new Timestamp(LocalDateTime.now().getNano());
            meta.gmtModified = meta.gmtCreate;
            meta.projectSetting = info.projectSetting;

            // Write project meta into persistent storage;
            long startInsertMeta = System.nanoTime();
            metaStore.insertProject(meta);
            long endInsertMeta = System.nanoTime();
            logger.info("ProjectMeta of project [name={}] has been written into persistent storage with the following content: \n" +
                            "description={}\n" +
                            "createTime={}",
                    meta.projectName, meta.projectDesc, meta.gmtCreate);

            // Update the memory data-structure;
            projectMetaMap.put(info.projectName, meta);
            // put the new project meta to its containing cluster meta;
            clusterMeta.projectMetaMap.put(info.projectName, meta);
            logger.info("ProjectMeta of project [name={}] has been written into memory.", meta.projectName);
            logger.info("Time breakdown of MasterServiceInternalImpl::insertProject: getLock:{} ms, insertMeta:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endInsertMeta - startInsertMeta) / 1000000);
        } finally {
            writeLock.unlock();
        }
    }


    public void updateProject(ProjectMetaData project) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        ProjectMetaData meta;
        try {
            long startGetLock = System.nanoTime();
            writeLock.lock();
            long endGetLock = System.nanoTime();
            String projectName = project.projectName;
            String projectDesc = project.projectDesc;
            meta = projectMetaMap.get(project.projectName);
            if (meta == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(),
                        String.format("Project [%s] does not exist.", projectName));
            }
            long startUpdateMeta = System.nanoTime();
            meta.gmtModified = new Timestamp(LocalDateTime.now().getNano());
            if (projectDesc != null) {
                meta.projectDesc = projectDesc;
            }
            metaStore.updateProject(meta);
            long endUpdateMeta = System.nanoTime();
            logger.info("ProjectMeta of project [name={}] has been updated in persistent storage with the following content: \n" +
                    "description={}" +
                    meta.projectName, meta.projectDesc);
            logger.info("ProjectMeta of project [name={}] has been updated in memory.", meta.projectName);
            logger.info("Time breakdown of MasterServiceInternalImpl::updateProject: getLock:{} ms, updateMeta:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endUpdateMeta - startUpdateMeta) / 1000000);
        } finally {
            writeLock.unlock();
        }
    }


    public ProjectInfo getProject(String projectName) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ProjectInfo result = null;
        try {
            long startGetLock = System.nanoTime();
            readLock.lock();
            long endGetLock = System.nanoTime();

            ProjectMetaData meta = projectMetaMap.get(projectName);
            if (meta == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(),
                        String.format("Project [%s] does not exist.", projectName));
            }
            long startGetData = System.nanoTime();
            ProjectMetricCounter counter = MetricUtils.calculateProjectMetric(meta);
            result = MetaUtility.build(meta, counter);
            long endGetData = System.nanoTime();

            logger.info("getProject is called with projectName={}.", projectName);
            logger.info("Time breakdown of MasterServiceInternalImpl::getProject: getLock:{} ms, getData:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endGetData - startGetData) / 1000000);
        } finally {
            readLock.unlock();
        }
        return result;
    }

    public void deleteProject(String projectName) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        try {
            long startGetLock = System.nanoTime();
            writeLock.lock();
            long endGetLock = System.nanoTime();
            if (!projectMetaMap.containsKey(projectName)) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(),
                        String.format("Project [%s] does not exist.", projectName));
            }
            ProjectMetaData projectMeta = projectMetaMap.get(projectName);
            if (projectMeta.indexTemplateMetaData.size() != 0) {
                throw new SearchManagementException(ErrorCodeEnum.PROJECT_NOT_EMPTY.getCode(), String.format("Project [%s] is not empty and can't be deleted.", projectName));
            }
            long startDeleteMeta = System.nanoTime();
            metaStore.deleteProject(projectMeta.clusterName, projectName);
            long endDeleteMeta = System.nanoTime();
            logger.info("ProjectMeta of project [name={}] has been deleted from persistent storage.", projectName);

            // Update memory data structure;
            projectMetaMap.remove(projectName);
            ClusterMetaData clusterMeta = clusterMetaMap.get(projectMeta.clusterName);
            clusterMeta.projectMetaMap.remove(projectName);
            logger.info("ProjectMeta of project [name={}] has been deleted from memory.", projectName);
            logger.info("Time breakdown of MasterServiceInternalImpl::deleteProject: getLock:{} ms, deleteMeta:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endDeleteMeta - startDeleteMeta) / 1000000);
        } finally {
            writeLock.unlock();
        }
    }


    public List<ProjectInfo> listProjects(String clusterName) {
        List<ProjectInfo> result = new ArrayList<>();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        try {
            long startGetLock = System.nanoTime();
            readLock.lock();
            long endGetLock = System.nanoTime();

            ClusterMetaData clusterMeta = clusterMetaMap.get(clusterName);
            if (clusterMeta == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(),
                        String.format("Cluster [%s] does not exist.", clusterName));
            }
            long startGetData = System.nanoTime();
            for (Map.Entry<String, ProjectMetaData> entry : clusterMeta.projectMetaMap.entrySet()) {
                ProjectMetaData projectMeta = entry.getValue();
                ProjectMetricCounter counter = MetricUtils.calculateProjectMetric(projectMeta);
                ProjectInfo project = MetaUtility.build(projectMeta, counter);
                result.add(project);
            }
            long endGetData = System.nanoTime();
            logger.info("getProjects is called with clusterName={}.", clusterName);
            logger.info("Time breakdown of MasterServiceInternalImpl::getProjects: getLock:{} ms, getData:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endGetData - startGetData) / 1000000);
        } finally {
            readLock.unlock();
        }
        return result;
    }


    public void insertIndexTemplate(IndexTemplateMetaData info) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        try {
            long startGetLock = System.nanoTime();
            writeLock.lock();
            long endGetLock = System.nanoTime();

            ProjectMetaData projectMeta = projectMetaMap.get(info.projectName);
            if (projectMeta == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(),
                        String.format("Project [%s] does not exist.", info.projectName));
            }
            if (projectMeta.indexTemplateMetaData.containsKey(info.templateName)) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_ALREADY_EXIST.getCode(),
                        String.format("IndexTemplate [%s] already exists in project [%s].", info.templateName, info.projectName));
            }

            // Put a new index template meta into the root project meta map;
            IndexTemplateMetaData templateMetaData = new IndexTemplateMetaData();
            templateMetaData.templateName = info.templateName;
            templateMetaData.mappings = info.mappings;
            templateMetaData.settings = info.settings;
            templateMetaData.aliasList = new ArrayList<>();
            if (info.aliasList.size() > 0) {
                templateMetaData.aliasList.addAll(info.aliasList);
            }
            templateMetaData.autoIndexRollingPolicy = info.autoIndexRollingPolicy;
            templateMetaData.autoIndexRollingWindow = info.autoIndexRollingWindow;
            templateMetaData.autoIndexNamePrefix = info.autoIndexNamePrefix;
            templateMetaData.indexMetas = new HashMap<>();
            templateMetaData.gmtCreate = new Timestamp(LocalDateTime.now().getNano());
            templateMetaData.gmtModified = new Timestamp(LocalDateTime.now().getNano());

            // 将项目的setting属性继承到索引组
            // 如果项目存在setting,将集群的继承下去
            if (!StringUtils.isEmpty(projectMeta.projectSetting)) {
                String setting = templateMetaData.settings;
                JSONObject jsonSetting = JSONObject.parseObject(setting);
                JSONObject groupSetting = JSONObject.parseObject(projectMeta.projectSetting);
                JSONUtility.merge(jsonSetting, groupSetting);
                templateMetaData.settings = JSONObject.toJSONString(jsonSetting);
            }

            long startInsertMeta = System.nanoTime();
            metaStore.insertIndexTemplate(templateMetaData);
            long endInsertMeta = System.nanoTime();
            logger.info("IndexTemplateMeta of Index template [project={}][name={}] has been written into persistent storage with the following content: \n" +
                            "mapping={}\n" +
                            "setting={}\n" +
                            "policy={}\n" +
                            "timeToLive={}",
                    info.projectName, templateMetaData.templateName, templateMetaData.mappings, templateMetaData.settings, templateMetaData.autoIndexRollingPolicy, templateMetaData.autoIndexRollingWindow);

            // Update the meta of containing project and cluster object;
            projectMeta.indexTemplateMetaData.put(info.templateName, templateMetaData);
            logger.info("IndexTemplateMeta of Index template [project={}][name={}] has been written into memory.", info.projectName,
                    templateMetaData.templateName);
            logger.info("Time breakdown of MasterServiceInternalImpl::insertIndexTemplate: getLock:{} ms, insertMeta:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endInsertMeta - startInsertMeta) / 1000000);
        } finally {
            writeLock.unlock();
        }
    }


    public void updateIndexTemplate(IndexTemplateMetaData templateMetaData)  {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        try {
            long startGetLock = System.nanoTime();
            writeLock.lock();
            long endGetLock = System.nanoTime();

            ProjectMetaData projectMeta = projectMetaMap.get(templateMetaData.projectName);
            if (projectMeta == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(),
                        String.format("Project [%s] does not exist.", templateMetaData.projectName));
            }
            IndexTemplateMetaData template = projectMeta.indexTemplateMetaData.get(templateMetaData.templateName);
            if (template == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(),
                        String.format("IndexTemplate [%s] does not exist in project [%s].", templateMetaData.templateName, templateMetaData.projectName));
            }
            if ((templateMetaData.autoIndexRollingPolicy != null) &&
                    (template.autoIndexRollingPolicy != templateMetaData.autoIndexRollingPolicy) &&
                    (template.autoIndexRollingPolicy != AutoIndexRollingPolicy.NONE) &&
                    (templateMetaData.autoIndexRollingPolicy != AutoIndexRollingPolicy.NONE)) {
                throw new SearchManagementException(ErrorCodeEnum.INVALID_INPUT_PARAMETER.getCode(),
                        String.format("Auto index rolling policy can't be updated from [%s] to [%s].",
                                template.autoIndexRollingPolicy, templateMetaData.autoIndexRollingPolicy));
            }

            long lastUpdateTime = System.currentTimeMillis();
            long startUpdateMeta = System.nanoTime();
            metaStore.updateIndexTemplate(templateMetaData);
            long endUpdateMeta = System.nanoTime();
            logger.info("IndexTemplateMeta of index template [project={}][name={}] has been updated in persistent storage with the following content: \n" +
                            "mapping={}\n" +
                            "setting={}\n" +
                            "autoIndexRollingPolicy={}\n" +
                            "autoIndexRollingWindow={}",
                    templateMetaData.projectName, templateMetaData.templateName, templateMetaData.mappings, templateMetaData.settings, templateMetaData.autoIndexRollingPolicy, templateMetaData.autoIndexRollingWindow);

            if (templateMetaData.mappings != null) {
                template.mappings = templateMetaData.mappings;
            }
            if (templateMetaData.settings != null) {
                template.settings =  templateMetaData.settings;
            }
            if (templateMetaData.aliasList != null) {
                template.aliasList = templateMetaData.aliasList;
            }
            if (templateMetaData.autoIndexRollingPolicy != null) {
                template.autoIndexRollingPolicy = templateMetaData.autoIndexRollingPolicy;
            }
            if (templateMetaData.autoIndexRollingWindow != null) {
                template.autoIndexRollingWindow = templateMetaData.autoIndexRollingWindow;
            }
            template.gmtModified = new Timestamp(LocalDateTime.now().getNano());
            logger.info("IndexTemplateMeta of index template [project={}][name={}] has been updated in memory.", template.projectName, template.templateName);
            logger.info("Time breakdown of MasterServiceInternalImpl::updateIndexTemplate: getLock:{} ms, updateMeta:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endUpdateMeta - startUpdateMeta) / 1000000);
        } finally {
            writeLock.unlock();
        }
    }


    public void deleteIndexTemplate(String projectName, String templateName)  {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        try {
            long startGetLock = System.nanoTime();
            writeLock.lock();
            long endGetLock = System.nanoTime();

            ProjectMetaData projectMeta = projectMetaMap.get(projectName);
            if (projectMeta == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(), String.format("Project [%s] does not exist.", projectName));
            }
            IndexTemplateMetaData indexTemplateMetaData = projectMeta.indexTemplateMetaData.get(templateName);
            if (indexTemplateMetaData == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(), String.format("IndexTemplate [%s] does not exist in project [%s].", templateName, projectName));
            }
            if (indexTemplateMetaData.indexMetas.size() != 0) {
                throw new SearchManagementException(ErrorCodeEnum.TEMPLATE_NOT_EMPTY.getCode(), String.format("IndexTemplate [%s] is not empty and can't be deleted.", templateName));
            }

            long startDeleteMeta = System.nanoTime();
            metaStore.deleteIndexTemplate(projectName, templateName);
            long endDeleteMeta = System.nanoTime();
            logger.info("IndexTemplateMeta of index template [project={}][name={}] has been deleted from persistent storage.", projectName, templateName);

            // Update the meta of containing project and cluster object;
            projectMeta.indexTemplateMetaData.remove(templateName);
            logger.info("IndexTemplateMeta of index template [project={}][name={}] has been deleted from memory.", projectName, templateName);
            logger.info("Time breakdown of MasterServiceInternalImpl::deleteIndexTemplate: getLock:{} ms, deleteMeta:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endDeleteMeta - startDeleteMeta) / 1000000);
        } finally {
            writeLock.unlock();
        }
    }


    public List<IndexTemplateInfo> getIndexTemplates(String projectName) {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        List<IndexTemplateInfo> result = new ArrayList<IndexTemplateInfo>();
        try {
            long startGetLock = System.nanoTime();
            readLock.lock();
            long endGetLock = System.nanoTime();

            ProjectMetaData projectMeta = projectMetaMap.get(projectName);
            if (projectMeta == null) {
                throw new SearchManagementException(ErrorCodeEnum.OBJECT_NOT_EXIST.getCode(), String.format("Project [%s] does not exist.", projectName));
            }
            long startGetData = System.nanoTime();
            for (Map.Entry<String, IndexTemplateMetaData> entry : projectMeta.indexTemplateMetaData.entrySet()) {
                IndexTemplateMetaData indexGroupMeta = entry.getValue();
                TemplateMetricCounter counter = MetricUtils.calculateTemplateMetric(indexGroupMeta);
                IndexTemplateInfo info = MetaUtility.build(projectMeta.clusterName, projectName, indexGroupMeta, counter);
                result.add(info);
            }
            long endGetData = System.nanoTime();
            logger.info("getIndexTemplates is called with projectName={}.", projectName);
            logger.info("Time breakdown of MasterServiceInternalImpl::getIndexTemplates: getLock:{} ms, getData:{} ms.",
                    (endGetLock - startGetLock) / 1000000,
                    (endGetData - startGetData) / 1000000);
        } finally {
            readLock.unlock();
        }
        return result;
    }
}
