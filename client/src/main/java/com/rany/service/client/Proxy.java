package com.rany.service.client;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.protobuf.StringValue;
import com.rany.service.client.rpc.request.*;
import com.rany.service.common.constants.Constants;
import com.rany.service.common.exception.CommonReturnCode;
import com.rany.service.common.exception.ErrorCodeEnum;
import com.rany.service.common.exception.SearchClientException;
import com.rany.service.common.exception.SearchManagementException;
import com.rany.service.common.toolkit.DateUtility;
import com.rany.service.platform.DataTypeUtils;
import com.rany.service.platform.admin.AdminServiceGrpc;
import com.rany.service.platform.admin.PingReply;
import com.rany.service.platform.admin.PingRequest;
import com.rany.service.platform.meta.*;
import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 服务代理
 *
 * @author zhongshengwang
 * @description 服务代理
 * @date 2022/3/26 11:18 下午
 * @email 18668485565@163.com
 */

public class Proxy implements Bootstrap {

    private static final Logger logger = LoggerFactory.getLogger(Proxy.class);
    /**
     * 可通过服务名通信
     */
    private final String serviceName;
    /**
     * 主节点IP地址列表
     */
    private Set<String> masterIpAddress;
    private Integer port;
    private final long timeout;

    /**
     * 标识代理类的启停状态
     */
    private volatile boolean startUp = false;
    private volatile ManagedChannel channel;
    private volatile int connectedMasterIndex;

    /**
     * 心跳线程
     */
    private HeartBeatThread heartBeatThread;


    /**
     * grpc Meta 服务调用凭证（存根）
     */
    private MetaServiceGrpc.MetaServiceBlockingStub metaStub;
    /**
     * grpc Admin 服务调用凭证（存根）
     */
    private AdminServiceGrpc.AdminServiceBlockingStub adminServiceStub;

    public Proxy(String serviceName, long timeout) {
        this.serviceName = serviceName;
        this.timeout = timeout;
    }

    public Proxy(String masterIpAddress, int port, long timeout) {
        this.serviceName = null;
        this.masterIpAddress = Sets.newHashSet(masterIpAddress);
        this.port = port;
        this.timeout = timeout;
    }

    public Proxy(Set<String> masterIpAddress, Integer port, long timeout) {
        this.serviceName = null;
        this.masterIpAddress = masterIpAddress;
        this.port = port;
        this.timeout = timeout;
    }

    @Override
    public boolean start() {
        if (StringUtils.isNotEmpty(serviceName)) {
            channel = InProcessChannelBuilder.forName(serviceName).directExecutor().usePlaintext().build();
        } else if (CollectionUtils.isNotEmpty(masterIpAddress)) {
            String masterHost = masterIpAddress.stream().findFirst().get();
            this.connectedMasterIndex = 0;
            this.channel = NettyChannelBuilder.forAddress(masterHost, port).negotiationType(NegotiationType.PLAINTEXT).build();
            // 启动心跳线程
            heartBeatThread = new HeartBeatThread();
            heartBeatThread.start();
        } else {
            throw new SearchClientException(ErrorCodeEnum.NO_MASTER_IP_EXCEPTION);
        }
        // 启动backend heartbeat thread
        return true;
    }

    @Override
    public boolean shutdown() {
        if (masterIpAddress != null) {
            this.startUp = true;
            try {
                heartBeatThread.join();
            } catch (InterruptedException ignore) {
            }
        }
        if (channel != null) {
            try {
                channel.shutdown().awaitTermination(30, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new SearchClientException(
                        ErrorCodeEnum.CLIENT_SHUTDOWN_EXCEPTION.getCode(),
                        String.format(ErrorCodeEnum.CLIENT_SHUTDOWN_EXCEPTION.getMessage(), e.getMessage()));
            }
        }
        return true;
    }

    /**
     * 心跳线程
     */
    private class HeartBeatThread extends Thread {
        @Override
        public void run() {
            boolean connected = true;
            int heartbeat = 0;
            List<Boolean> masterFlag = new ArrayList<>();
            for (int i = 0; i < masterIpAddress.size(); ++i) {
                masterFlag.add(true);
            }
            List<String> masters = Lists.newArrayList(masterIpAddress);
            while (!startUp) {
                if (connected) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ignore) {
                    }

                    if (ping(channel)) {
                        heartbeat = 0;
                        continue;
                    } else {
                        heartbeat++;
                    }
                    if (heartbeat == 5) {
                        // lost connection
                        connected = false;
                        masterFlag.set(connectedMasterIndex, false);
                        logger.error("current master host {} is disconnected,try to connect a new master."
                                , masters.get(connectedMasterIndex));
                        heartbeat = 0;
                    }
                } else {
                    boolean found = false;
                    for (int i = 0; i < masterFlag.size(); ++i) {
                        if (Boolean.TRUE.equals(masterFlag.get(i))) {
                            ManagedChannel tmpChannel = NettyChannelBuilder.forAddress(masters.get(i), port)
                                    .negotiationType(NegotiationType.PLAINTEXT).build();
                            if (ping(tmpChannel)) {
                                connectedMasterIndex = i;
                                channel = tmpChannel;
                                found = true;
                                connected = true;
                                break;
                            } else {
                                masterFlag.set(i, false);
                            }
                        }
                    }
                    if (found) {
                        logger.info("succeed to connect master {}.", masters.get(connectedMasterIndex));
                    } else {
                        logger.error("all master candidates are offline, try to connect them again 30 seconds later.");
                        for (int i = 0; i < masterIpAddress.size(); ++i) {
                            masterFlag.set(i, true);
                        }
                        try {
                            Thread.sleep(30000);
                        } catch (InterruptedException ignore) {
                        }
                    }
                }
            }
        }

        private boolean ping(ManagedChannel channel) {
            boolean result = true;
            try {
                AdminServiceGrpc.AdminServiceBlockingStub adminServiceStub =
                        AdminServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
                PingRequest request = PingRequest.newBuilder().setPing(Constants.PING).build();
                PingReply reply = adminServiceStub.ping(request);
                String pong = reply.getPong();
                if (!pong.equalsIgnoreCase(Constants.PONG)) {
                    throw new SearchClientException(ErrorCodeEnum.NO_HEARTBEAT_EXCEPTION);
                }
            } catch (Exception e) {
                // 丢失心跳
                result = false;
            }
            return result;
        }
    }

    public void createCluster(ClusterCreateRequest clusterCreateRequest) {
        ClusterType clusterType = DataTypeUtils.convertClusterType(clusterCreateRequest.getType());
        ClusterStatus clusterStatus = DataTypeUtils.convertClusterStatus(clusterCreateRequest.getStatus());
        CreateClusterRequest request = CreateClusterRequest.newBuilder()
                .setName(clusterCreateRequest.getName())
                .setEndpoint(clusterCreateRequest.getAddress())
                .setInternalEndpoint(clusterCreateRequest.getInternalAddress())
                .setCluster(clusterType)
                .setDescription(clusterCreateRequest.getDesc())
                .setStatus(clusterStatus)
                .build();
        CreateClusterReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.createCluster(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to call create cluster with message: " + e.getMessage());
        }
    }

    public ClusterInfo getCluster(ClusterGetRequest clusterGetRequest) {
        GetClusterInfoRequest request = GetClusterInfoRequest.newBuilder()
                .setName(clusterGetRequest.getName())
                .build();
        GetClusterInfoReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.getClusterInfo(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to call getCluster with message: " + e.getMessage());
        }
        return reply.getCluster();
    }

    public void updateCluster(ClusterUpdateRequest clusterUpdateRequest) {
        UpdateClusterInfoRequest request = UpdateClusterInfoRequest.newBuilder()
                .setName(clusterUpdateRequest.getName())
                .setStatus(DateUtility.stringToClusterStatus(clusterUpdateRequest.getStatus()))
                .setDescription(clusterUpdateRequest.getDesc())
                .setInternalEndpoint(clusterUpdateRequest.getInternalAddress())
                .build();
        UpdateClusterInfoReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.updateCluster(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to update cluster with message: " + e.getMessage());
        }
    }

    public void deleteCluster(ClusterDeleteRequest clusterDeleteRequest) {
        DeleteClusterRequest request = DeleteClusterRequest.newBuilder()
                .setName(clusterDeleteRequest.getName())
                .build();
        DeleteClusterReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.deleteCluster(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to delete cluster with message: " + e.getMessage());
        }
    }

    public List<String> listCluster(ClusterListRequest clusterListRequest) {
        ListClusterRequest request = ListClusterRequest.newBuilder()
                .build();
        ListClusterReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.listCluster(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to list clusters with message: " + e.getMessage());
        }
        return reply.getClustersList();
    }

    public List<ClusterInfo> listClusterDetails(ClusterListRequest clusterListRequest) {
        ListClusterDetailsRequest request = ListClusterDetailsRequest.newBuilder()
                .build();
        ListClusterDetailsReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.listClusterDetails(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to list clusters details with message: " + e.getMessage());
        }
        return reply.getClustersList();
    }

    public void createProject(ProjectCreateRequest projectCreateRequest) {
        CreateProjectRequest request = CreateProjectRequest.newBuilder()
                .setName(projectCreateRequest.getName())
                .setDescription(projectCreateRequest.getDesc())
                .setCluster(projectCreateRequest.getCluster())
                .build();
        CreateProjectReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.createProject(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to create project with message: " + e.getMessage());
        }
    }

    public ProjectInfo getProject(ProjectGetRequest projectGetRequest) {
        GetProjectRequest request = GetProjectRequest.newBuilder()
                .setName(projectGetRequest.getName())
                .build();
        GetProjectReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.getProject(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to get project with message: " + e.getMessage());
        }
        return reply.getProject();
    }

    public void updateProject(ProjectUpdateRequest projectUpdateRequest) {
        UpdateProjectRequest request = UpdateProjectRequest.newBuilder()
                .setName(projectUpdateRequest.getName())
                .setDescription(projectUpdateRequest.getDesc())
                .build();
        UpdateProjectReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.updateProject(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to update project with message: " + e.getMessage());
        }
    }

    public void deleteProject(ProjectDeleteRequest projectDeleteRequest) {
        DeleteProjectRequest request = DeleteProjectRequest.newBuilder()
                .setName(projectDeleteRequest.getName())
                .build();
        DeleteProjectReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.deleteProject(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to delete project with message: " + e.getMessage());
        }
    }

    public List<String> listProject(ProjectListRequest projectListRequest) {
        ListProjectRequest request = ListProjectRequest.newBuilder()
                .setCluster(projectListRequest.getCluster())
                .build();
        ListProjectReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.listProject(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to list project with message: " + e.getMessage());
        }
        return reply.getProjectsList();
    }

    public List<ProjectInfo> listProjectDetails(ProjectListRequest projectListRequest) {
        ListProjectDetailsRequest request = ListProjectDetailsRequest.newBuilder()
                .setCluster(projectListRequest.getCluster())
                .build();
        ListProjectDetailsReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.listProjectDetails(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to list project details with message: " + e.getMessage());
        }
        return reply.getProjectsList();
    }

    public void createIndexTemplate(IndexTemplateCreateRequest indexTemplateCreateRequest) {
        AutoIndexRollingPolicy autoIndexRollingPolicy = DateUtility.stringToAutoIndexRollingPolicy(indexTemplateCreateRequest.getAutoIndexRollingPolicy());
        CreateIndexTemplateRequest request = CreateIndexTemplateRequest.newBuilder()
                .setName(indexTemplateCreateRequest.getName())
                .setProject(indexTemplateCreateRequest.getProjectName())
                .addAllAliases(indexTemplateCreateRequest.getAliases())
                .setMapping(indexTemplateCreateRequest.getMapping())
                .setSetting(indexTemplateCreateRequest.getSetting())
                .setAutoIndexNamePrefix(indexTemplateCreateRequest.getAutoIndexNamePrefix())
                .setAutoIndexRollingPolicy(autoIndexRollingPolicy)
                .setAutoIndexRollingWindow(indexTemplateCreateRequest.getAutoIndexRollingWindow())
                .build();
        CreateIndexTemplateReply reply = null;
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.createIndexTemplate(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to create index template with message: " + e.getMessage());
        }
    }

    public void updateIndexTemplate(IndexTemplateUpdateRequest request)  {
        UpdateIndexTemplateRequest.Builder builder = UpdateIndexTemplateRequest.newBuilder();
        builder.setName(request.getName()).setProject(request.getProjectName());

        if (request.getMapping() != null) {
            builder.setMapping(StringValue.newBuilder().setValue(request.getMapping() ).build());
        }
        if (request.getSetting()  != null) {
            builder.setSetting(StringValue.newBuilder().setValue(request.getSetting() ).build());
        }
        if (request.getAutoIndexRollingPolicy() != null) {
            AutoIndexRollingPolicy autoIndexRollingPolicy = DateUtility.stringToAutoIndexRollingPolicy(request.getAutoIndexRollingPolicy());
            builder.setUpdatePolicy(true);
            builder.setAutoIndexRollingPolicy(autoIndexRollingPolicy);
        } else {
            builder.setUpdatePolicy(false);
        }
        if (request.getAutoIndexRollingWindow() != null) {
            builder.setUpdateWindow(true);
            builder.setAutoIndexRollingWindow(request.getAutoIndexRollingWindow());
        } else {
            builder.setUpdateWindow(false);
        }
        if (request.getAliases() != null && !request.getAliases().isEmpty()) {
            builder.setUpdateAlias(true);
            builder.addAllAliases(request.getAliases() );
        } else {
            builder.setUpdateAlias(false);
        }
        UpdateIndexTemplateRequest updateIndexTemplateRequest = builder.build();
        UpdateIndexTemplateReply reply = null;

        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.updateIndexTemplate(updateIndexTemplateRequest);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to update index template with message: " + e.getMessage());
        }
    }

    public void deleteIndexTemplate(IndexTemplateDeleteRequest request)  {
        DeleteIndexTemplateRequest.Builder builder = DeleteIndexTemplateRequest.newBuilder();
        builder.setName(request.getName()).setProject(request.getProjectName());
        DeleteIndexTemplateRequest deleteIndexTemplateRequest = builder.build();
        DeleteIndexTemplateReply reply = null;

        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.deleteIndexTemplate(deleteIndexTemplateRequest);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to delete index template with message: " + e.getMessage());
        }
    }

    public List<String> listIndexTemplate(IndexTemplateListRequest listRequest)  {
        ListIndexTemplateRequest request = ListIndexTemplateRequest.newBuilder()
                .setProject(listRequest.getProjectName())
                .build();
        ListIndexTemplateReply reply = null;

        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.listIndexTemplate(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to list index template with message: " + e.getMessage());
        }
        return reply.getTemplatesList();
    }

    public List<IndexTemplateInfo> listIndexTemplateDetails(IndexTemplateListRequest listRequest)  {
        ListIndexTemplateDetailsRequest request = ListIndexTemplateDetailsRequest.newBuilder()
                .setProject(listRequest.getProjectName())
                .build();
        ListIndexTemplateDetailsReply reply = null;

        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.listIndexTemplateDetails(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to list index template details with message: " + e.getMessage());
        }
        return reply.getTemplatesList();
    }

    public void createIndex(IndexCreateRequest indexCreateRequest)  {
        AutoIndexRollingPolicy autoIndexRollingPolicy = DateUtility.stringToAutoIndexRollingPolicy(indexCreateRequest.getAutoIndexRollingPolicy());
        CreateIndexRequest request = CreateIndexRequest.newBuilder()
                .setProject(indexCreateRequest.getProject())
                .setIndexTemplate(indexCreateRequest.getTemplate())
                .setName(indexCreateRequest.getName())
                .addAllAliases(indexCreateRequest.getAliases())
                .setRollingPolicy(autoIndexRollingPolicy)
                .build();
        CreateIndexReply reply = null;

        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.createIndex(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to create index with message: " + e.getMessage());
        }
    }

    public IndexInfo getIndex(IndexGetRequest indexGetRequest)  {
        GetIndexRequest.Builder builder = GetIndexRequest.newBuilder();
        builder.setProject(indexGetRequest.getProject());
        builder.setName(indexGetRequest.getName());
        builder.setIndexTemplate(indexGetRequest.getTemplate());
        GetIndexReply reply = null;
        GetIndexRequest request = builder.build();
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.getIndex(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to get index with message: " + e.getMessage());
        }
        return reply.getIndex();
    }

    public void deleteIndex(IndexDeleteRequest deleteIndexRequest)  {
        DeleteIndexRequest request = DeleteIndexRequest.newBuilder()
                .setProject(deleteIndexRequest.getProject())
                .setIndexTemplate(deleteIndexRequest.getTemplate())
                .setIndexName(deleteIndexRequest.getName())
                .build();
        DeleteIndexReply reply = null;

        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.deleteIndex(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to delete index with message: " + e.getMessage());
        }
    }

    public void updateIndex(IndexUpdateRequest indexUpdateRequest)  {
        AutoIndexRollingPolicy autoIndexRollingPolicy = DateUtility.stringToAutoIndexRollingPolicy(indexUpdateRequest.getAutoIndexRollingPolicy());
        UpdateIndexRequest.Builder builder = UpdateIndexRequest.newBuilder();
        builder.setProject(indexUpdateRequest.getProject())
                .setIndexTemplate(indexUpdateRequest.getTemplate())
                .setIndexName(indexUpdateRequest.getName())
                .build();
        UpdateIndexReply reply = null;

        if (indexUpdateRequest.getMapping() != null) {
            builder.setMapping(StringValue.newBuilder().setValue(indexUpdateRequest.getMapping() ).build());
        }
        if (indexUpdateRequest.getSetting()  != null) {
            builder.setSetting(StringValue.newBuilder().setValue(indexUpdateRequest.getSetting() ).build());
        }
        UpdateIndexRequest request = builder.build();
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.updateIndex(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to update index with message: " + e.getMessage());
        }
    }

    public List<String> listIndex(IndexListRequest indexListRequest)  {
        ListIndexRequest.Builder builder = ListIndexRequest.newBuilder();
        builder.setProject(indexListRequest.getProject())
                .setIndexTemplate(indexListRequest.getTemplate())
                .setCluster(indexListRequest.getCluster())
                .build();
        ListIndexReply reply = null;
        ListIndexRequest request = builder.build();
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.listIndex(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to update index with message: " + e.getMessage());
        }
        return reply.getIndicesList();
    }

    public List<IndexInfo> listIndexDetails(IndexListDetailsRequest indexListRequest)  {
        ListIndexDetailsRequest.Builder builder = ListIndexDetailsRequest.newBuilder();
        builder.setProject(indexListRequest.getProject())
                .setIndexTemplate(indexListRequest.getTemplate())
                .setCluster(indexListRequest.getCluster())
                .build();
        ListIndexDetailsReply reply = null;
        ListIndexDetailsRequest request = builder.build();
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.listIndexDetails(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to update index with message: " + e.getMessage());
        }
        return reply.getIndicesList();
    }
    
    public List<IndexNameEntry> listIndexName(IndexListNameRequest listIndexNameRequest)  {
        ListIndexNameRequest.Builder builder = ListIndexNameRequest.newBuilder();
        builder.setCluster(listIndexNameRequest.getCluster());
        ListIndexNameReply reply = null;
        ListIndexNameRequest request = builder.build();
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.listIndexName(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to list index names with message: " + e.getMessage());
        }
        return reply.getIndexNamesList();
    }

    public List<IndexNameEntry> listIndexAlias(IndexListAliasRequest listIndexAliasRequest)  {
        ListIndexAliasNameRequest.Builder builder = ListIndexAliasNameRequest.newBuilder();
        builder.setCluster(listIndexAliasRequest.getCluster());
        ListIndexAliasNameReply reply = null;
        ListIndexAliasNameRequest request = builder.build();
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.listIndexAliasName(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to list index alias list with message: " + e.getMessage());
        }
        return reply.getIndexAliasNamesList();
    }

    public void attachIndex(IndexAttachRequest attachIndexRequest)  {
        AttachIndexRequest.Builder builder = AttachIndexRequest.newBuilder();
        builder.setProject(attachIndexRequest.getProject());
        builder.setName(attachIndexRequest.getName());
        builder.setIndexTemplate(attachIndexRequest.getTemplate());
        AttachIndexReply reply = null;
        AttachIndexRequest request = builder.build();
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.attachIndex(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to attach index with message: " + e.getMessage());
        }
    }

    public void detachIndex(IndexDetachRequest detachRequest)  {
        DetachIndexRequest.Builder builder = DetachIndexRequest.newBuilder();
        builder.setProject(detachRequest.getProject());
        builder.setName(detachRequest.getName());
        builder.setIndexTemplate(detachRequest.getTemplate());
        DetachIndexReply reply = null;
        DetachIndexRequest request = builder.build();
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.detachIndex(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to detach index with message: " + e.getMessage());
        }
    }


    public void refreshIndex(IndexRefreshRequest refreshRequest)  {
        RefreshIndexRequest.Builder builder = RefreshIndexRequest.newBuilder();
        builder.setProject(refreshRequest.getProject());
        builder.setName(refreshRequest.getName());
        builder.setIndexTemplate(refreshRequest.getTemplate());
        RefreshIndexReply reply = null;
        RefreshIndexRequest request = builder.build();
        try {
            metaStub = MetaServiceGrpc.newBlockingStub(channel).withDeadlineAfter(timeout, TimeUnit.MILLISECONDS);
            reply = metaStub.refreshIndex(request);
            if (reply.getCode() != CommonReturnCode.SUCCEED.getCode()) {
                throw new SearchManagementException(reply.getCode(), reply.getMessage());
            }
        } catch (Exception e) {
            throw new SearchManagementException(ErrorCodeEnum.UNKNOWN.getCode(),
                    "Fail to refresh index with message: " + e.getMessage());
        }
    }
}
