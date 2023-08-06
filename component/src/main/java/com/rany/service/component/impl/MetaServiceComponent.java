package com.rany.service.component.impl;

import com.rany.service.common.exception.CommonReturnCode;
import com.rany.service.common.exception.ErrorCodeEnum;
import com.rany.service.common.exception.SearchManagementException;
import com.rany.service.component.meta.ClusterMeta;
import com.rany.service.component.meta.ProjectMeta;
import com.rany.service.component.meta.dto.IndexTemplateMetaData;
import com.rany.service.component.meta.dto.ProjectMetaData;
import com.rany.service.platform.meta.*;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author zhongshengwang
 */
public class MetaServiceComponent extends MetaServiceGrpc.MetaServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(MetaServiceComponent.class);

    private final MasterServiceInternalImpl internal;

    public MetaServiceComponent(MasterServiceInternalImpl internal) {
        this.internal = internal;
    }

    @Override
    public void createCluster(CreateClusterRequest request, StreamObserver<CreateClusterReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(), String.format("Service is in [%s] status.", status));
        }

        // create cluster
        ClusterMeta clusterMeta = new ClusterMeta();
        internal.createCluster(clusterMeta);
        CreateClusterReply reply = CreateClusterReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getClusterInfo(GetClusterInfoRequest request, StreamObserver<GetClusterInfoReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(), String.format("Service is in [%s] status.", status));
        }
        ClusterInfo cluster = internal.getCluster(request.getName());
        GetClusterInfoReply reply = GetClusterInfoReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .setCluster(cluster)
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void updateCluster(UpdateClusterInfoRequest request, StreamObserver<UpdateClusterInfoReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(), String.format("Service is in [%s] status.", status));
        }
        // update cluster
        ClusterMeta clusterMeta = new ClusterMeta();
        internal.updateCluster(clusterMeta);

        UpdateClusterInfoReply reply = UpdateClusterInfoReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteCluster(DeleteClusterRequest request, StreamObserver<DeleteClusterReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(), String.format("Service is in [%s] status.", status));
        }
        internal.deleteCluster(request.getName());
        DeleteClusterReply reply = DeleteClusterReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void listCluster(ListClusterRequest request, StreamObserver<ListClusterReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.READONLY && status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }
        ListClusterReply.Builder builder = ListClusterReply.newBuilder();
        List<ClusterInfo> clusters = internal.getClusters();
        if (clusters != null && !clusters.isEmpty()) {
            for (int i = 0; i < clusters.size(); ++i) {
                builder.addClusters(clusters.get(i).getName());
            }
        }
        ListClusterReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void listClusterDetails(ListClusterDetailsRequest request, StreamObserver<ListClusterDetailsReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.READONLY && status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }
        ListClusterDetailsReply.Builder builder = ListClusterDetailsReply.newBuilder();
        List<ClusterInfo> clusters = internal.getClusters();
        if (clusters != null && !clusters.isEmpty()) {
            for (int i = 0; i < clusters.size(); ++i) {
                builder.addClusters(clusters.get(i));
            }
        }
        ListClusterDetailsReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void createProject(CreateProjectRequest request, StreamObserver<CreateProjectReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }
        ProjectMeta projectMeta = new ProjectMeta();
        projectMeta.projectName = request.getName();
        projectMeta.projectDesc = request.getDescription();
        projectMeta.clusterName = request.getCluster();
        projectMeta.projectSetting = request.getProjectSetting();

        // set properties
        internal.insertProject(projectMeta);

        CreateProjectReply reply = CreateProjectReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void updateProject(UpdateProjectRequest request, StreamObserver<UpdateProjectReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        ProjectMetaData projectMeta = new ProjectMetaData();
        projectMeta.projectName = request.getName();
        projectMeta.projectDesc = request.getDescription();
        projectMeta.projectSetting = request.getProjectSetting();
        // set properties
        internal.updateProject(projectMeta);

        UpdateProjectReply reply = UpdateProjectReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getProject(GetProjectRequest request, StreamObserver<GetProjectReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }


        // set properties
        ProjectInfo project = internal.getProject(request.getName());

        GetProjectReply reply = GetProjectReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .setProject(project)
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteProject(DeleteProjectRequest request, StreamObserver<DeleteProjectReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }


        // set properties
        internal.deleteProject(request.getName());

        DeleteProjectReply reply = DeleteProjectReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void listProject(ListProjectRequest request, StreamObserver<ListProjectReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        ListProjectReply.Builder builder = ListProjectReply.newBuilder();

        // set properties
        List<ProjectInfo> projects = internal.listProjects(request.getCluster());
        if (projects != null && !projects.isEmpty()) {
            for (int i = 0; i < projects.size(); ++i) {
                builder.addProjects(projects.get(i).getName());
            }
        }
        ListProjectReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void listProjectDetails(ListProjectDetailsRequest request, StreamObserver<ListProjectDetailsReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }
        ListProjectDetailsReply.Builder builder = ListProjectDetailsReply.newBuilder();
        List<ProjectInfo> projects = internal.listProjects(request.getCluster());
        if (projects != null) {
            builder.addAllProjects(projects);
        }
        ListProjectDetailsReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void createIndexTemplate(CreateIndexTemplateRequest request, StreamObserver<CreateIndexTemplateReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        IndexTemplateMetaData indexTemplateMetaData = new IndexTemplateMetaData();
        indexTemplateMetaData.templateName = request.getName();
        indexTemplateMetaData.projectName = request.getProject();
        indexTemplateMetaData.mappings = request.getMapping();
        indexTemplateMetaData.settings = request.getSetting();
        indexTemplateMetaData.aliasList = request.getAliasesList();
        indexTemplateMetaData.autoIndexNamePrefix = request.getAutoIndexNamePrefix();
        indexTemplateMetaData.autoIndexRollingWindow = request.getAutoIndexRollingWindow();
        indexTemplateMetaData.autoIndexRollingPolicy = request.getAutoIndexRollingPolicy();

        internal.insertIndexTemplate(indexTemplateMetaData);
        CreateIndexTemplateReply reply = CreateIndexTemplateReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void updateIndexTemplate(UpdateIndexTemplateRequest request, StreamObserver<UpdateIndexTemplateReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        IndexTemplateMetaData indexTemplateMetaData = new IndexTemplateMetaData();
        indexTemplateMetaData.templateName = request.getName();
        indexTemplateMetaData.mappings = request.hasMapping() ? request.getMapping().getValue() : null;
        indexTemplateMetaData.settings = request.hasSetting() ? request.getSetting().getValue() : null;
        indexTemplateMetaData.aliasList = request.getAliasesList();
        indexTemplateMetaData.autoIndexRollingWindow = request.getAutoIndexRollingWindow();
        indexTemplateMetaData.autoIndexRollingPolicy = request.getAutoIndexRollingPolicy();

        internal.updateIndexTemplate(indexTemplateMetaData);
        UpdateIndexTemplateReply reply = UpdateIndexTemplateReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteIndexTemplate(DeleteIndexTemplateRequest request, StreamObserver<DeleteIndexTemplateReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        internal.deleteIndexTemplate(request.getProject(), request.getName());
        DeleteIndexTemplateReply reply = DeleteIndexTemplateReply.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void listIndexTemplate(ListIndexTemplateRequest request, StreamObserver<ListIndexTemplateReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }
        ListIndexTemplateReply.Builder builder = ListIndexTemplateReply.newBuilder();
        List<IndexTemplateInfo> indexTemplates = internal.getIndexTemplates(request.getProject());
        if (indexTemplates != null) {
            for (int i = 0; i < indexTemplates.size(); ++i) {
                builder.addTemplates(indexTemplates.get(i).getName());
            }
        }
        ListIndexTemplateReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void listIndexTemplateDetails(ListIndexTemplateDetailsRequest request, StreamObserver<ListIndexTemplateDetailsReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }
        ListIndexTemplateDetailsReply.Builder builder = ListIndexTemplateDetailsReply.newBuilder();
        List<IndexTemplateInfo> indexTemplates = internal.getIndexTemplates(request.getProject());
        if (indexTemplates != null) {
            for (int i = 0; i < indexTemplates.size(); ++i) {
                builder.addTemplates(indexTemplates.get(i));
            }
        }
        ListIndexTemplateDetailsReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void createIndex(CreateIndexRequest request, StreamObserver<CreateIndexReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        IndexInfo.Builder infoBuilder = IndexInfo.newBuilder();
        infoBuilder.setName(request.getName())
                .setTemplate(request.getIndexTemplate())
                .setProjectName(request.getProject())
                .addAllAliases(request.getAliasesList());
        if (request.hasMapping()) {
            infoBuilder.setMapping(request.getMapping().getValue());
        }
        if (request.hasSetting()) {
            infoBuilder.setSetting(request.getSetting().getValue());
        }
        IndexInfo info = infoBuilder.build();

        internal.createIndex(info, request.hasMapping(), request.hasSetting());
        CreateIndexReply.Builder builder = CreateIndexReply.newBuilder();
        CreateIndexReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getIndex(GetIndexRequest request, StreamObserver<GetIndexReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        GetIndexReply.Builder builder = GetIndexReply.newBuilder();
        internal.getIndex(request.getProject(), request.getIndexTemplate(), request.getName());

        GetIndexReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteIndex(DeleteIndexRequest request, StreamObserver<DeleteIndexReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }
        internal.deleteIndex(request.getProject(), request.getIndexTemplate(), request.getIndexName());
        DeleteIndexReply.Builder builder = DeleteIndexReply.newBuilder();
        DeleteIndexReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void updateIndex(UpdateIndexRequest request, StreamObserver<UpdateIndexReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }
        IndexInfo.Builder infoBuilder = IndexInfo.newBuilder();
        infoBuilder.setName(request.getIndexName())
                .setTemplate(request.getIndexTemplate())
                .setProjectName(request.getProject())
                .build();
        if (request.hasMapping()) {
            infoBuilder.setMapping(request.getMapping().getValue());
        }
        if (request.hasSetting()) {
            infoBuilder.setSetting(request.getSetting().getValue());
        }
        IndexInfo info = infoBuilder.build();

        internal.updateIndex(info);
        UpdateIndexReply.Builder builder = UpdateIndexReply.newBuilder();
        UpdateIndexReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void listIndex(ListIndexRequest request, StreamObserver<ListIndexReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        ListIndexReply.Builder builder = ListIndexReply.newBuilder();
        List<IndexInfo> indices = internal.getIndices(request.getProject(), request.getIndexTemplate());
        if (indices != null) {
            for (int i = 0; i < indices.size(); ++i) {
                builder.addIndices(indices.get(i).getName());
            }
        }

        ListIndexReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void listIndexDetails(ListIndexDetailsRequest request, StreamObserver<ListIndexDetailsReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        ListIndexDetailsReply.Builder builder = ListIndexDetailsReply.newBuilder();
        List<IndexInfo> indices = internal.getIndices(request.getProject(), request.getIndexTemplate());
        if (indices != null) {
            for (int i = 0; i < indices.size(); ++i) {
                builder.addIndices(indices.get(i));
            }
        }

        ListIndexDetailsReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void listIndexName(ListIndexNameRequest request, StreamObserver<ListIndexNameReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        ListIndexNameReply.Builder builder = ListIndexNameReply.newBuilder();
        List<IndexNameEntry> indices = internal.getIndexNameList(request.getCluster());
        if (indices != null) {
            for (int i = 0; i < indices.size(); ++i) {
                builder.addIndexNames(indices.get(i));
            }
        }

        ListIndexNameReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void listIndexAliasName(ListIndexAliasNameRequest request, StreamObserver<ListIndexAliasNameReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }

        ListIndexAliasNameReply.Builder builder = ListIndexAliasNameReply.newBuilder();
        List<IndexNameEntry> indices = internal.getIndexAliasNameList(request.getCluster());
        if (indices != null) {
            for (int i = 0; i < indices.size(); ++i) {
                builder.addIndexAliasNames(indices.get(i));
            }
        }

        ListIndexAliasNameReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void attachIndex(AttachIndexRequest request, StreamObserver<AttachIndexReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }


        internal.attachIndex(request.getName(), request.getProject(), request.getIndexTemplate());
        AttachIndexReply.Builder builder = AttachIndexReply.newBuilder();
        AttachIndexReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void detachIndex(DetachIndexRequest request, StreamObserver<DetachIndexReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }


        internal.detachIndex(request.getName(), request.getProject(), request.getIndexTemplate());
        DetachIndexReply.Builder builder = DetachIndexReply.newBuilder();
        DetachIndexReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


    @Override
    public void refreshIndex(RefreshIndexRequest request, StreamObserver<RefreshIndexReply> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        if (status != MasterServiceInternalImpl.RUNNING_STATUS.NORMAL) {
            logger.warn("service is in {} status.", status);
            throw new SearchManagementException(ErrorCodeEnum.PROTECTED_STATUS.getCode(),
                    String.format("Service is in [%s] status.", status));
        }


        internal.refreshIndex(request.getName(), request.getProject(), request.getIndexTemplate());
        RefreshIndexReply.Builder builder = RefreshIndexReply.newBuilder();
        RefreshIndexReply reply = builder
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}

