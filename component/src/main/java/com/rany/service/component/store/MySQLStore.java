package com.rany.service.component.store;

import com.rany.service.common.constants.Constants;
import com.rany.service.common.constants.TableColumnNameConstant;
import com.rany.service.common.exception.ErrorCodeEnum;
import com.rany.service.common.exception.SearchManagementException;
import com.rany.service.component.IMetaStorage;
import com.rany.service.component.meta.dto.ClusterMetaData;
import com.rany.service.component.meta.dto.IndexMetaData;
import com.rany.service.component.meta.dto.IndexTemplateMetaData;
import com.rany.service.component.meta.dto.ProjectMetaData;
import com.rany.service.platform.DataTypeUtils;
import com.rany.service.platform.meta.AutoIndexRollingPolicy;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.util.StringUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 * MySQLStore
 *
 * @author zhongshengwang
 * @description MySQLStore mysql
 * @date 2022/4/2 11:39 下午
 * @email 18668485565@163.com
 */

public class MySQLStore implements IMetaStorage {

    private final JdbcTemplate jdbcTemplate;
    private final String clusterMetaTableName;
    private final String projectMetaTableName;
    private final String indexMetaTableName;
    private final String indexTemplateTableName;

    public MySQLStore(JdbcTemplate jdbcTemplate, String metaStoreEnv) {
        this.jdbcTemplate = jdbcTemplate;
        clusterMetaTableName = metaStoreEnv + Constants.Table.CLUSTER_TABLE_NAME_SUFFIX;
        projectMetaTableName = metaStoreEnv + Constants.Table.PROJECT_TABLE_NAME_SUFFIX;
        indexTemplateTableName = metaStoreEnv + Constants.Table.INDEX_TEMPLATE_TABLE_NAME_SUFFIX;
        indexMetaTableName = metaStoreEnv + Constants.Table.INDEX_TABLE_NAME_SUFFIX;
    }

    @Override
    public String getMetaStoreAddress() {
        return Objects.requireNonNull(jdbcTemplate.getDataSource()).toString();
    }

    @Override
    public void checkHealth() {
        String command = String.format("select * from %s", clusterMetaTableName);
        try {
            jdbcTemplate.execute(command);
        } catch (DataAccessException e) {
            throw new SearchManagementException(ErrorCodeEnum.MYSQL_INTERNAL_ERROR.getCode(), e.getMessage());
        }
    }

    @Override
    public void setupTables() {
        {
            // cluster table
            try {
                String command = String.format(
                        "CREATE TABLE IF NOT EXISTS %s ( \n" +
                                "%s VARCHAR(256) PRIMARY KEY NOT NULL, \n" +
                                "%s VARCHAR(64) NOT NULL, \n" +
                                "%s VARCHAR(64) NOT NULL, \n" +
                                "%s VARCHAR(1024), \n" +
                                "%s VARCHAR(1024) NOT NULL, \n" +
                                "%s VARCHAR(1024) NOT NULL, \n" +
                                "%s DATETIME NOT NULL, \n" +
                                "%s DATETIME NOT NULL \n" +
                                ")",
                        clusterMetaTableName,
                        TableColumnNameConstant.Cluster.CLUSTER_META_TABLE_PK_NAME,
                        TableColumnNameConstant.Cluster.COLUMN_CLUSTER_STATUS,
                        TableColumnNameConstant.Cluster.COLUMN_CLUSTER_TYPE,
                        TableColumnNameConstant.Cluster.COLUMN_DESCRIPTION,
                        TableColumnNameConstant.Cluster.COLUMN_INTERNAL_ENDPOINT,
                        TableColumnNameConstant.Cluster.COLUMN_SERVICE_ENDPOINT,
                        TableColumnNameConstant.Cluster.COLUMN_CREATE_TIME,
                        TableColumnNameConstant.Cluster.COLUMN_LAST_UPDATE_TIME);
                jdbcTemplate.execute(command);
            } catch (Exception e) {
                System.out.println(String.format("Fail to create meta tables with message: %s.", e.getMessage()));
            }
        }
        {
            // project
            try {
                String command = String.format(
                        "CREATE TABLE IF NOT EXISTS %s ( \n" +
                                "%s VARCHAR(256) PRIMARY KEY NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(1024), \n" +
                                "%s DATETIME NOT NULL, \n" +
                                "%s DATETIME NOT NULL \n" +
                                ")",
                        projectMetaTableName,
                        TableColumnNameConstant.Project.PROJECT_META_TABLE_PK_NAME,
                        TableColumnNameConstant.Project.PROJECT_META_TABLE_CLUSTER_NAME,
                        TableColumnNameConstant.Project.COLUMN_DESCRIPTION,
                        TableColumnNameConstant.Project.COLUMN_CREATE_TIME,
                        TableColumnNameConstant.Project.COLUMN_LAST_UPDATE_TIME);
                jdbcTemplate.execute(command);
            } catch (Exception e) {
                System.out.println(String.format("Fail to create meta tables with message: %s.", e.getMessage()));
            }
        }
        {
            // index template
            try {
                String command = String.format(
                        "CREATE TABLE IF NOT EXISTS %s ( \n" +
                                "%s VARCHAR(256) PRIMARY KEY NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(64) NOT NULL, \n" +
                                "%s INT NOT NULL, \n" +
                                "%s TEXT(65536), \n" +
                                "%s TEXT(65536), \n" +
                                "%s DATETIME NOT NULL, \n" +
                                "%s DATETIME NOT NULL \n" +
                                ")",
                        indexTemplateTableName,
                        TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PK_NAME,
                        TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PROJECT_NAME,
                        TableColumnNameConstant.IndexTemplate.COLUMN_ALIAS,
                        TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_NAME_PREFIX,
                        TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_POLICY,
                        TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_WINDOW,
                        TableColumnNameConstant.IndexTemplate.COLUMN_MAPPINGS,
                        TableColumnNameConstant.IndexTemplate.COLUMN_SETTINGS,
                        TableColumnNameConstant.IndexTemplate.COLUMN_CREATE_TIME,
                        TableColumnNameConstant.IndexTemplate.COLUMN_LAST_UPDATE_TIME);
                jdbcTemplate.execute(command);
            } catch (Exception e) {
                System.out.println(String.format("Fail to create meta tables with message: %s.", e.getMessage()));
            }
        }

        {
            // index
            try {
                String command = String.format(
                        "CREATE TABLE IF NOT EXISTS %s ( \n" +
                                "%s VARCHAR(256) PRIMARY KEY NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s BOOLEAN NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s DATETIME NOT NULL, \n" +
                                "%s DATETIME NOT NULL \n" +
                                ")",
                        indexMetaTableName,
                        TableColumnNameConstant.Index.INDEX_META_TABLE_PK_NAME,
                        TableColumnNameConstant.Index.INDEX_META_TABLE_NAME,
                        TableColumnNameConstant.Index.INDEX_META_TABLE_PROJECT_NAME,
                        TableColumnNameConstant.Index.INDEX_META_TABLE_TEMPLATE_NAME,
                        TableColumnNameConstant.Index.COLUMN_INDEX_LEGACY_FLAG,
                        TableColumnNameConstant.Index.COLUMN_INDEX_TAGS,
                        TableColumnNameConstant.Index.COLUMN_CREATE_TIME,
                        TableColumnNameConstant.Index.COLUMN_LAST_UPDATE_TIME);
                jdbcTemplate.execute(command);
            } catch (Exception e) {
                System.out.println(String.format("Fail to create meta tables with message: %s.", e.getMessage()));
            }
        }
    }

    @Override
    public List<ClusterMetaData> loadAllMeta() {
        List<ClusterMetaData> clusterMetas = loadClusterMetas();
        // 集群
        for (ClusterMetaData clusterMeta : clusterMetas) {
            List<ProjectMetaData> projectMetaList = loadProjectMeta(clusterMeta.clusterName);
            // 项目
            for (ProjectMetaData projectMetaData : projectMetaList) {
                List<IndexTemplateMetaData> indexTemplateMetas = loadIndexTemplateMeta(projectMetaData.projectName);
                // 模板
                for (IndexTemplateMetaData templateMeta : indexTemplateMetas) {
                    List<IndexMetaData> indexMetaList = loadIndexMeta(projectMetaData.projectName, templateMeta.templateName);
                    for (IndexMetaData indexMeta : indexMetaList) {
                        templateMeta.indexMetas.put(indexMeta.name, indexMeta);
                    }
                    projectMetaData.indexTemplateMetaData.put(templateMeta.templateName, templateMeta);
                }
                clusterMeta.projectMetaMap.put(projectMetaData.projectName, projectMetaData);
            }
        }
        return clusterMetas;
    }

    @Override
    public void insertIndex(IndexMetaData indexMetaData) {
        String command = String.format(
                "insert into %s (%s, %s, %s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?, ?, ?)",
                indexMetaTableName,
                TableColumnNameConstant.Index.INDEX_META_TABLE_PK_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_PROJECT_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_TEMPLATE_NAME,
                TableColumnNameConstant.Index.COLUMN_INDEX_LEGACY_FLAG,
                TableColumnNameConstant.Index.COLUMN_INDEX_TAGS,
                TableColumnNameConstant.Index.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Index.COLUMN_LAST_UPDATE_TIME);

        try {
            jdbcTemplate.update(
                    command,
                    indexMetaData.fullName,
                    indexMetaData.name,
                    indexMetaData.projectName,
                    indexMetaData.templateName,
                    indexMetaData.legacy,
                    StringUtils.isEmpty(indexMetaData.tags) ? "" : indexMetaData.tags,
                    indexMetaData.gmtCreate,
                    indexMetaData.gmtModified);
        } catch (Exception exception) {
            System.out.println(exception.getStackTrace());
        }
    }

    @Override
    public void insertCluster(ClusterMetaData clusterMetaData) {
        String command = String.format(
                "insert into %s (%s, %s, %s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?, ?, ?)",
                clusterMetaTableName,
                TableColumnNameConstant.Cluster.CLUSTER_META_TABLE_PK_NAME,
                TableColumnNameConstant.Cluster.COLUMN_CLUSTER_STATUS,
                TableColumnNameConstant.Cluster.COLUMN_CLUSTER_TYPE,
                TableColumnNameConstant.Cluster.COLUMN_DESCRIPTION,
                TableColumnNameConstant.Cluster.COLUMN_INTERNAL_ENDPOINT,
                TableColumnNameConstant.Cluster.COLUMN_SERVICE_ENDPOINT,
                TableColumnNameConstant.Cluster.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Cluster.COLUMN_LAST_UPDATE_TIME
        );
        jdbcTemplate.update(
                command,
                clusterMetaData.clusterName,
                clusterMetaData.clusterStatus,
                clusterMetaData.clusterType,
                clusterMetaData.clusterDesc,
                clusterMetaData.clusterInternalAddress,
                clusterMetaData.clusterAddress,
                clusterMetaData.gmtCreate,
                clusterMetaData.gmtModified);
    }

    @Override
    public void updateCluster(ClusterMetaData clusterMetaData) {
        String command = String.format("update %s set ", clusterMetaTableName);
        command += String.format(" %s=%s ", TableColumnNameConstant.Cluster.COLUMN_LAST_UPDATE_TIME, clusterMetaData.gmtModified);
        if (clusterMetaData.clusterStatus != null) {
            command += String.format(" ,%s=? ", TableColumnNameConstant.Cluster.COLUMN_CLUSTER_STATUS);
        }
        if (clusterMetaData.clusterDesc != null) {
            command += String.format(" ,%s=? ", TableColumnNameConstant.Cluster.COLUMN_DESCRIPTION);
        }
        if (clusterMetaData.clusterInternalAddress != null) {
            command += String.format(" ,%s=? ", TableColumnNameConstant.Cluster.COLUMN_INTERNAL_ENDPOINT);
        }
        command += String.format(" where %s=\"%s\"", TableColumnNameConstant.Cluster.CLUSTER_META_TABLE_PK_NAME, clusterMetaData.clusterName);
        jdbcTemplate.update(
                command,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        int parameterIndex = 1;
                        if (clusterMetaData.clusterStatus != null) {
                            preparedStatement.setString(parameterIndex++, String.valueOf(clusterMetaData.clusterStatus.getNumber()));
                        }
                        if (clusterMetaData.clusterDesc != null) {
                            preparedStatement.setString(parameterIndex++, clusterMetaData.clusterDesc);
                        }
                        if (clusterMetaData.clusterInternalAddress != null) {
                            preparedStatement.setString(parameterIndex++, clusterMetaData.clusterInternalAddress);
                        }
                    }
                }
        );
    }

    @Override
    public void deleteCluster(String clusterName) {
        String command = String.format("delete from %s where %s=\"%s\"",
                clusterMetaTableName,
                TableColumnNameConstant.Cluster.CLUSTER_META_TABLE_PK_NAME,
                clusterName);
        jdbcTemplate.execute(command);
    }

    @Override
    public void insertProject(ProjectMetaData projectMetaData) {
        String command = String.format(
                "insert into %s (%s, %s, %s, %s, %s) values (?, ?, ?, ?, ?)",
                projectMetaTableName,
                TableColumnNameConstant.Project.PROJECT_META_TABLE_PK_NAME,
                TableColumnNameConstant.Project.PROJECT_META_TABLE_CLUSTER_NAME,
                TableColumnNameConstant.Project.COLUMN_DESCRIPTION,
                TableColumnNameConstant.Project.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Project.COLUMN_LAST_UPDATE_TIME);
        jdbcTemplate.update(
                command,
                projectMetaData.clusterName + "." + projectMetaData.projectName,
                projectMetaData.projectDesc,
                projectMetaData.gmtCreate,
                projectMetaData.gmtModified);
    }

    @Override
    public void updateProject(ProjectMetaData projectMetaData) {
        String command = String.format("update %s set ", projectMetaTableName);
        command += String.format(" %s=%d ", TableColumnNameConstant.Project.COLUMN_LAST_UPDATE_TIME, projectMetaData.gmtModified);
        if (projectMetaData.projectDesc != null) {
            command += String.format(" ,%s=? ", TableColumnNameConstant.Project.COLUMN_DESCRIPTION, projectMetaData.projectDesc);
        }
        command += String.format(" where %s=\"%s\"", TableColumnNameConstant.Project.PROJECT_META_TABLE_PK_NAME,
                projectMetaData.clusterName + "." + projectMetaData.projectName);
        jdbcTemplate.update(
                command,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        int parameterIndex = 1;
                        if (projectMetaData.projectDesc != null) {
                            preparedStatement.setString(parameterIndex++, projectMetaData.projectDesc);
                        }
                    }
                }
        );
    }


    @Override
    public void deleteProject(String clusterName, String projectName) {
        String command = String.format("delete from %s where %s=\"%s\"",
                projectMetaTableName,
                TableColumnNameConstant.Project.PROJECT_META_TABLE_PK_NAME,
                clusterName + "." + projectName);
        jdbcTemplate.update(command);
    }

    private List<ClusterMetaData> loadClusterMetas() {
        List<ClusterMetaData> result = new ArrayList<>();
        String command = String.format("select %s,%s,%s,%s,%s,%s,%s,%s from %s",
                TableColumnNameConstant.Cluster.CLUSTER_META_TABLE_PK_NAME,
                TableColumnNameConstant.Cluster.COLUMN_DESCRIPTION,
                TableColumnNameConstant.Cluster.COLUMN_CLUSTER_TYPE,
                TableColumnNameConstant.Cluster.COLUMN_CLUSTER_STATUS,
                TableColumnNameConstant.Cluster.COLUMN_INTERNAL_ENDPOINT,
                TableColumnNameConstant.Cluster.COLUMN_SERVICE_ENDPOINT,
                TableColumnNameConstant.Cluster.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Cluster.COLUMN_LAST_UPDATE_TIME,
                clusterMetaTableName);
        jdbcTemplate.query(command, resultSet -> {
            ClusterMetaData clusterMeta = new ClusterMetaData();
            clusterMeta.clusterName = resultSet.getString(1);
            clusterMeta.clusterDesc = resultSet.getString(2);
            clusterMeta.clusterType = DataTypeUtils.convertClusterType(resultSet.getString(3));
            clusterMeta.clusterStatus = DataTypeUtils.convertClusterStatus(resultSet.getString(4));
            clusterMeta.clusterInternalAddress = resultSet.getString(5);
            clusterMeta.clusterAddress = resultSet.getString(6);
            clusterMeta.gmtCreate = resultSet.getTimestamp(7);
            clusterMeta.gmtModified = resultSet.getTimestamp(8);


            clusterMeta.projectMetaMap = new HashMap<>();
            clusterMeta.esVersion = Constants.UNKNOWN;
            clusterMeta.clusterHealth = Constants.UNKNOWN;
            clusterMeta.nodeMetaList = new ArrayList<>();
            result.add(clusterMeta);
        });
        return result;
    }

    private List<ProjectMetaData> loadProjectMeta(String clusterName) {
        List<ProjectMetaData> result = new ArrayList<>();
        String command = String.format("select %s,%s,%s,%s,%s from %s where %s = '%s'",
                TableColumnNameConstant.Project.PROJECT_META_TABLE_PK_NAME,
                TableColumnNameConstant.Project.PROJECT_META_TABLE_CLUSTER_NAME,
                TableColumnNameConstant.Project.COLUMN_DESCRIPTION,
                TableColumnNameConstant.Project.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Project.COLUMN_LAST_UPDATE_TIME,
                projectMetaTableName,
                TableColumnNameConstant.Project.PROJECT_META_TABLE_CLUSTER_NAME,
                clusterName
        );
        jdbcTemplate.query(command, resultSet -> {
            ProjectMetaData projectMeta = new ProjectMetaData();
            projectMeta.projectName = resultSet.getString(1);
            projectMeta.clusterName = clusterName;
            projectMeta.projectDesc = resultSet.getString(3);
            projectMeta.gmtCreate = resultSet.getTimestamp(4);
            projectMeta.gmtModified = resultSet.getTimestamp(5);
            projectMeta.indexTemplateMetaData = new HashMap<>(6);
            result.add(projectMeta);
        });
        return result;
    }

    private List<IndexTemplateMetaData> loadIndexTemplateMeta(String projectName) {
        List<IndexTemplateMetaData> result = new ArrayList<>();
        String command = String.format("select %s,%s,%s,%s,%s,%s,%s,%s,%s,%s from %s where %s = '%s'",
                TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PK_NAME,
                TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PROJECT_NAME,
                TableColumnNameConstant.IndexTemplate.COLUMN_ALIAS,
                TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_NAME_PREFIX,
                TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_POLICY,
                TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_WINDOW,
                TableColumnNameConstant.IndexTemplate.COLUMN_MAPPINGS,
                TableColumnNameConstant.IndexTemplate.COLUMN_SETTINGS,
                TableColumnNameConstant.IndexTemplate.COLUMN_CREATE_TIME,
                TableColumnNameConstant.IndexTemplate.COLUMN_LAST_UPDATE_TIME,
                indexTemplateTableName,
                TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PROJECT_NAME,
                projectName
        );
        jdbcTemplate.query(command, resultSet -> {
            IndexTemplateMetaData indexTemplateMetaData = new IndexTemplateMetaData();
            indexTemplateMetaData.templateName = resultSet.getString(1);
            indexTemplateMetaData.projectName = resultSet.getString(2);
            indexTemplateMetaData.aliasList = new ArrayList<>();
            String aliasListString = resultSet.getString(3);
            if (!aliasListString.isEmpty()) {
                String[] aliases = aliasListString.split("@");
                indexTemplateMetaData.aliasList.addAll(Arrays.asList(aliases));
            }
            indexTemplateMetaData.autoIndexNamePrefix = resultSet.getString(4);
            indexTemplateMetaData.autoIndexRollingPolicy = EnumUtils.getEnum(AutoIndexRollingPolicy.class, resultSet.getString(5));
            indexTemplateMetaData.autoIndexRollingWindow = resultSet.getInt(6);

            indexTemplateMetaData.mappings = resultSet.getString(7);
            indexTemplateMetaData.settings = resultSet.getString(8);

            indexTemplateMetaData.gmtCreate = resultSet.getTimestamp(9);
            indexTemplateMetaData.gmtModified = resultSet.getTimestamp(10);
            indexTemplateMetaData.indexMetas = new HashMap<>(8);
            result.add(indexTemplateMetaData);
        });
        return result;
    }

    private List<IndexMetaData> loadIndexMeta(String projectName, String templateName) {
        List<IndexMetaData> result = new ArrayList<>();
        String command = String.format("select %s,%s,%s,%s,%s,%s,%s,%s from %s where %s = '%s' and %s = '%s'",
                TableColumnNameConstant.Index.INDEX_META_TABLE_PK_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_PROJECT_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_TEMPLATE_NAME,
                TableColumnNameConstant.Index.COLUMN_INDEX_LEGACY_FLAG,
                TableColumnNameConstant.Index.COLUMN_INDEX_TAGS,
                TableColumnNameConstant.Index.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Index.COLUMN_LAST_UPDATE_TIME,
                indexMetaTableName,
                TableColumnNameConstant.Index.INDEX_META_TABLE_PROJECT_NAME,
                projectName,
                TableColumnNameConstant.Index.INDEX_META_TABLE_TEMPLATE_NAME,
                templateName
        );
        jdbcTemplate.query(command, resultSet -> {
            IndexMetaData indexMeta = new IndexMetaData();
            indexMeta.fullName = resultSet.getString(1);
            indexMeta.name = resultSet.getString(2);
            indexMeta.projectName = resultSet.getString(3);
            indexMeta.templateName = resultSet.getString(4);
            indexMeta.legacy = resultSet.getBoolean(5);
            indexMeta.tags = resultSet.getString(6);
            indexMeta.gmtCreate = resultSet.getTimestamp(7);
            indexMeta.gmtModified = resultSet.getTimestamp(8);
            indexMeta.setting = "{}";   // give default values;
            indexMeta.mapping = "{}";   // give default values;
            if (indexMeta.legacy) {
                indexMeta.name = indexMeta.fullName;
            }
            indexMeta.aliases = new ArrayList<>();
            indexMeta.health = "";
            result.add(indexMeta);
        });
        return result;
    }
}
