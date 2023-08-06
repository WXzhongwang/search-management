package com.rany.service.platform.meta;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 */
@javax.annotation.Generated(
        value = "by gRPC proto compiler (version 1.7.0)",
        comments = "Source: admin/meta.proto")
public final class MetaServiceGrpc {

    public static final String SERVICE_NAME = "MetaService";
    // Static method descriptors that strictly reflect the proto.
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateClusterRequest,
            com.rany.service.platform.meta.CreateClusterReply> METHOD_CREATE_CLUSTER =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.CreateClusterRequest, com.rany.service.platform.meta.CreateClusterReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "CreateCluster"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.CreateClusterRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.CreateClusterReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("CreateCluster"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteClusterRequest,
            com.rany.service.platform.meta.DeleteClusterReply> METHOD_DELETE_CLUSTER =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.DeleteClusterRequest, com.rany.service.platform.meta.DeleteClusterReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "DeleteCluster"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.DeleteClusterRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.DeleteClusterReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("DeleteCluster"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateClusterInfoRequest,
            com.rany.service.platform.meta.UpdateClusterInfoReply> METHOD_UPDATE_CLUSTER =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.UpdateClusterInfoRequest, com.rany.service.platform.meta.UpdateClusterInfoReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "UpdateCluster"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.UpdateClusterInfoRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.UpdateClusterInfoReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("UpdateCluster"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetClusterInfoRequest,
            com.rany.service.platform.meta.GetClusterInfoReply> METHOD_GET_CLUSTER_INFO =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.GetClusterInfoRequest, com.rany.service.platform.meta.GetClusterInfoReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "GetClusterInfo"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.GetClusterInfoRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.GetClusterInfoReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("GetClusterInfo"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterRequest,
            com.rany.service.platform.meta.ListClusterReply> METHOD_LIST_CLUSTER =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListClusterRequest, com.rany.service.platform.meta.ListClusterReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "ListCluster"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListClusterRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListClusterReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListCluster"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterDetailsRequest,
            com.rany.service.platform.meta.ListClusterDetailsReply> METHOD_LIST_CLUSTER_DETAILS =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListClusterDetailsRequest, com.rany.service.platform.meta.ListClusterDetailsReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "ListClusterDetails"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListClusterDetailsRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListClusterDetailsReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListClusterDetails"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateProjectRequest,
            com.rany.service.platform.meta.CreateProjectReply> METHOD_CREATE_PROJECT =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.CreateProjectRequest, com.rany.service.platform.meta.CreateProjectReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "CreateProject"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.CreateProjectRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.CreateProjectReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("CreateProject"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteProjectRequest,
            com.rany.service.platform.meta.DeleteProjectReply> METHOD_DELETE_PROJECT =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.DeleteProjectRequest, com.rany.service.platform.meta.DeleteProjectReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "DeleteProject"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.DeleteProjectRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.DeleteProjectReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("DeleteProject"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateProjectRequest,
            com.rany.service.platform.meta.UpdateProjectReply> METHOD_UPDATE_PROJECT =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.UpdateProjectRequest, com.rany.service.platform.meta.UpdateProjectReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "UpdateProject"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.UpdateProjectRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.UpdateProjectReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("UpdateProject"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetProjectRequest,
            com.rany.service.platform.meta.GetProjectReply> METHOD_GET_PROJECT =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.GetProjectRequest, com.rany.service.platform.meta.GetProjectReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "GetProject"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.GetProjectRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.GetProjectReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("GetProject"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectRequest,
            com.rany.service.platform.meta.ListProjectReply> METHOD_LIST_PROJECT =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListProjectRequest, com.rany.service.platform.meta.ListProjectReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "ListProject"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListProjectRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListProjectReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListProject"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectDetailsRequest,
            com.rany.service.platform.meta.ListProjectDetailsReply> METHOD_LIST_PROJECT_DETAILS =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListProjectDetailsRequest, com.rany.service.platform.meta.ListProjectDetailsReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "ListProjectDetails"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListProjectDetailsRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListProjectDetailsReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListProjectDetails"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexTemplateRequest,
            com.rany.service.platform.meta.CreateIndexTemplateReply> METHOD_CREATE_INDEX_TEMPLATE =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.CreateIndexTemplateRequest, com.rany.service.platform.meta.CreateIndexTemplateReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "CreateIndexTemplate"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.CreateIndexTemplateRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.CreateIndexTemplateReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("CreateIndexTemplate"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexTemplateRequest,
            com.rany.service.platform.meta.GetIndexTemplateReply> METHOD_GET_INDEX_TEMPLATE =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.GetIndexTemplateRequest, com.rany.service.platform.meta.GetIndexTemplateReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "GetIndexTemplate"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.GetIndexTemplateRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.GetIndexTemplateReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("GetIndexTemplate"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexTemplateRequest,
            com.rany.service.platform.meta.UpdateIndexTemplateReply> METHOD_UPDATE_INDEX_TEMPLATE =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.UpdateIndexTemplateRequest, com.rany.service.platform.meta.UpdateIndexTemplateReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "UpdateIndexTemplate"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.UpdateIndexTemplateRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.UpdateIndexTemplateReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("UpdateIndexTemplate"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexTemplateRequest,
            com.rany.service.platform.meta.DeleteIndexTemplateReply> METHOD_DELETE_INDEX_TEMPLATE =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.DeleteIndexTemplateRequest, com.rany.service.platform.meta.DeleteIndexTemplateReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "DeleteIndexTemplate"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.DeleteIndexTemplateRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.DeleteIndexTemplateReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("DeleteIndexTemplate"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateRequest,
            com.rany.service.platform.meta.ListIndexTemplateReply> METHOD_LIST_INDEX_TEMPLATE =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexTemplateRequest, com.rany.service.platform.meta.ListIndexTemplateReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "ListIndexTemplate"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexTemplateRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexTemplateReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndexTemplate"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateDetailsRequest,
            com.rany.service.platform.meta.ListIndexTemplateDetailsReply> METHOD_LIST_INDEX_TEMPLATE_DETAILS =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexTemplateDetailsRequest, com.rany.service.platform.meta.ListIndexTemplateDetailsReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "ListIndexTemplateDetails"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexTemplateDetailsRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexTemplateDetailsReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndexTemplateDetails"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexRequest,
            com.rany.service.platform.meta.CreateIndexReply> METHOD_CREATE_INDEX =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.CreateIndexRequest, com.rany.service.platform.meta.CreateIndexReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "CreateIndex"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.CreateIndexRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.CreateIndexReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("CreateIndex"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexRequest,
            com.rany.service.platform.meta.GetIndexReply> METHOD_GET_INDEX =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.GetIndexRequest, com.rany.service.platform.meta.GetIndexReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "GetIndex"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.GetIndexRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.GetIndexReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("GetIndex"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexRequest,
            com.rany.service.platform.meta.UpdateIndexReply> METHOD_UPDATE_INDEX =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.UpdateIndexRequest, com.rany.service.platform.meta.UpdateIndexReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "UpdateIndex"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.UpdateIndexRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.UpdateIndexReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("UpdateIndex"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexRequest,
            com.rany.service.platform.meta.DeleteIndexReply> METHOD_DELETE_INDEX =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.DeleteIndexRequest, com.rany.service.platform.meta.DeleteIndexReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "DeleteIndex"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.DeleteIndexRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.DeleteIndexReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("DeleteIndex"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexRequest,
            com.rany.service.platform.meta.ListIndexReply> METHOD_LIST_INDEX =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexRequest, com.rany.service.platform.meta.ListIndexReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "ListIndex"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndex"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexDetailsRequest,
            com.rany.service.platform.meta.ListIndexDetailsReply> METHOD_LIST_INDEX_DETAILS =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexDetailsRequest, com.rany.service.platform.meta.ListIndexDetailsReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "ListIndexDetails"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexDetailsRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexDetailsReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndexDetails"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexNameRequest,
            com.rany.service.platform.meta.ListIndexNameReply> METHOD_LIST_INDEX_NAME =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexNameRequest, com.rany.service.platform.meta.ListIndexNameReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "ListIndexName"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexNameRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexNameReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndexName"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexAliasNameRequest,
            com.rany.service.platform.meta.ListIndexAliasNameReply> METHOD_LIST_INDEX_ALIAS_NAME =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexAliasNameRequest, com.rany.service.platform.meta.ListIndexAliasNameReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "ListIndexAliasName"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexAliasNameRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.ListIndexAliasNameReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndexAliasName"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.AttachIndexRequest,
            com.rany.service.platform.meta.AttachIndexReply> METHOD_ATTACH_INDEX =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.AttachIndexRequest, com.rany.service.platform.meta.AttachIndexReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "AttachIndex"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.AttachIndexRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.AttachIndexReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("AttachIndex"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.DetachIndexRequest,
            com.rany.service.platform.meta.DetachIndexReply> METHOD_DETACH_INDEX =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.DetachIndexRequest, com.rany.service.platform.meta.DetachIndexReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "DetachIndex"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.DetachIndexRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.DetachIndexReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("DetachIndex"))
                    .build();
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.RefreshIndexRequest,
            com.rany.service.platform.meta.RefreshIndexReply> METHOD_REFRESH_INDEX =
            io.grpc.MethodDescriptor.<com.rany.service.platform.meta.RefreshIndexRequest, com.rany.service.platform.meta.RefreshIndexReply>newBuilder()
                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                    .setFullMethodName(generateFullMethodName(
                            "MetaService", "RefreshIndex"))
                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.RefreshIndexRequest.getDefaultInstance()))
                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                            com.rany.service.platform.meta.RefreshIndexReply.getDefaultInstance()))
                    .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("RefreshIndex"))
                    .build();
    private static final int METHODID_CREATE_CLUSTER = 0;
    private static final int METHODID_DELETE_CLUSTER = 1;
    private static final int METHODID_UPDATE_CLUSTER = 2;
    private static final int METHODID_GET_CLUSTER_INFO = 3;
    private static final int METHODID_LIST_CLUSTER = 4;
    private static final int METHODID_LIST_CLUSTER_DETAILS = 5;
    private static final int METHODID_CREATE_PROJECT = 6;
    private static final int METHODID_DELETE_PROJECT = 7;
    private static final int METHODID_UPDATE_PROJECT = 8;
    private static final int METHODID_GET_PROJECT = 9;
    private static final int METHODID_LIST_PROJECT = 10;
    private static final int METHODID_LIST_PROJECT_DETAILS = 11;
    private static final int METHODID_CREATE_INDEX_TEMPLATE = 12;
    private static final int METHODID_GET_INDEX_TEMPLATE = 13;
    private static final int METHODID_UPDATE_INDEX_TEMPLATE = 14;
    private static final int METHODID_DELETE_INDEX_TEMPLATE = 15;
    private static final int METHODID_LIST_INDEX_TEMPLATE = 16;
    private static final int METHODID_LIST_INDEX_TEMPLATE_DETAILS = 17;
    private static final int METHODID_CREATE_INDEX = 18;
    private static final int METHODID_GET_INDEX = 19;
    private static final int METHODID_UPDATE_INDEX = 20;
    private static final int METHODID_DELETE_INDEX = 21;
    private static final int METHODID_LIST_INDEX = 22;
    private static final int METHODID_LIST_INDEX_DETAILS = 23;
    private static final int METHODID_LIST_INDEX_NAME = 24;
    private static final int METHODID_LIST_INDEX_ALIAS_NAME = 25;
    private static final int METHODID_ATTACH_INDEX = 26;
    private static final int METHODID_DETACH_INDEX = 27;
    private static final int METHODID_REFRESH_INDEX = 28;
    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;
    private MetaServiceGrpc() {
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static MetaServiceStub newStub(io.grpc.Channel channel) {
        return new MetaServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static MetaServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel) {
        return new MetaServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static MetaServiceFutureStub newFutureStub(
            io.grpc.Channel channel) {
        return new MetaServiceFutureStub(channel);
    }

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (MetaServiceGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new MetaServiceFileDescriptorSupplier())
                            .addMethod(METHOD_CREATE_CLUSTER)
                            .addMethod(METHOD_DELETE_CLUSTER)
                            .addMethod(METHOD_UPDATE_CLUSTER)
                            .addMethod(METHOD_GET_CLUSTER_INFO)
                            .addMethod(METHOD_LIST_CLUSTER)
                            .addMethod(METHOD_LIST_CLUSTER_DETAILS)
                            .addMethod(METHOD_CREATE_PROJECT)
                            .addMethod(METHOD_DELETE_PROJECT)
                            .addMethod(METHOD_UPDATE_PROJECT)
                            .addMethod(METHOD_GET_PROJECT)
                            .addMethod(METHOD_LIST_PROJECT)
                            .addMethod(METHOD_LIST_PROJECT_DETAILS)
                            .addMethod(METHOD_CREATE_INDEX_TEMPLATE)
                            .addMethod(METHOD_GET_INDEX_TEMPLATE)
                            .addMethod(METHOD_UPDATE_INDEX_TEMPLATE)
                            .addMethod(METHOD_DELETE_INDEX_TEMPLATE)
                            .addMethod(METHOD_LIST_INDEX_TEMPLATE)
                            .addMethod(METHOD_LIST_INDEX_TEMPLATE_DETAILS)
                            .addMethod(METHOD_CREATE_INDEX)
                            .addMethod(METHOD_GET_INDEX)
                            .addMethod(METHOD_UPDATE_INDEX)
                            .addMethod(METHOD_DELETE_INDEX)
                            .addMethod(METHOD_LIST_INDEX)
                            .addMethod(METHOD_LIST_INDEX_DETAILS)
                            .addMethod(METHOD_LIST_INDEX_NAME)
                            .addMethod(METHOD_LIST_INDEX_ALIAS_NAME)
                            .addMethod(METHOD_ATTACH_INDEX)
                            .addMethod(METHOD_DETACH_INDEX)
                            .addMethod(METHOD_REFRESH_INDEX)
                            .build();
                }
            }
        }
        return result;
    }

    /**
     *
     */
    public static abstract class MetaServiceImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         * 集群相关
         * </pre>
         */
        public void createCluster(com.rany.service.platform.meta.CreateClusterRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateClusterReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_CREATE_CLUSTER, responseObserver);
        }

        /**
         *
         */
        public void deleteCluster(com.rany.service.platform.meta.DeleteClusterRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteClusterReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_DELETE_CLUSTER, responseObserver);
        }

        /**
         *
         */
        public void updateCluster(com.rany.service.platform.meta.UpdateClusterInfoRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateClusterInfoReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_UPDATE_CLUSTER, responseObserver);
        }

        /**
         *
         */
        public void getClusterInfo(com.rany.service.platform.meta.GetClusterInfoRequest request,
                                   io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetClusterInfoReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_GET_CLUSTER_INFO, responseObserver);
        }

        /**
         *
         */
        public void listCluster(com.rany.service.platform.meta.ListClusterRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListClusterReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_LIST_CLUSTER, responseObserver);
        }

        /**
         *
         */
        public void listClusterDetails(com.rany.service.platform.meta.ListClusterDetailsRequest request,
                                       io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListClusterDetailsReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_LIST_CLUSTER_DETAILS, responseObserver);
        }

        /**
         * <pre>
         * 项目相关
         * </pre>
         */
        public void createProject(com.rany.service.platform.meta.CreateProjectRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateProjectReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_CREATE_PROJECT, responseObserver);
        }

        /**
         *
         */
        public void deleteProject(com.rany.service.platform.meta.DeleteProjectRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteProjectReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_DELETE_PROJECT, responseObserver);
        }

        /**
         *
         */
        public void updateProject(com.rany.service.platform.meta.UpdateProjectRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateProjectReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_UPDATE_PROJECT, responseObserver);
        }

        /**
         *
         */
        public void getProject(com.rany.service.platform.meta.GetProjectRequest request,
                               io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetProjectReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_GET_PROJECT, responseObserver);
        }

        /**
         *
         */
        public void listProject(com.rany.service.platform.meta.ListProjectRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListProjectReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_LIST_PROJECT, responseObserver);
        }

        /**
         *
         */
        public void listProjectDetails(com.rany.service.platform.meta.ListProjectDetailsRequest request,
                                       io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListProjectDetailsReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_LIST_PROJECT_DETAILS, responseObserver);
        }

        /**
         * <pre>
         * 模版
         * </pre>
         */
        public void createIndexTemplate(com.rany.service.platform.meta.CreateIndexTemplateRequest request,
                                        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateIndexTemplateReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_CREATE_INDEX_TEMPLATE, responseObserver);
        }

        /**
         *
         */
        public void getIndexTemplate(com.rany.service.platform.meta.GetIndexTemplateRequest request,
                                     io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetIndexTemplateReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_GET_INDEX_TEMPLATE, responseObserver);
        }

        /**
         *
         */
        public void updateIndexTemplate(com.rany.service.platform.meta.UpdateIndexTemplateRequest request,
                                        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateIndexTemplateReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_UPDATE_INDEX_TEMPLATE, responseObserver);
        }

        /**
         *
         */
        public void deleteIndexTemplate(com.rany.service.platform.meta.DeleteIndexTemplateRequest request,
                                        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteIndexTemplateReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_DELETE_INDEX_TEMPLATE, responseObserver);
        }

        /**
         *
         */
        public void listIndexTemplate(com.rany.service.platform.meta.ListIndexTemplateRequest request,
                                      io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexTemplateReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_LIST_INDEX_TEMPLATE, responseObserver);
        }

        /**
         *
         */
        public void listIndexTemplateDetails(com.rany.service.platform.meta.ListIndexTemplateDetailsRequest request,
                                             io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexTemplateDetailsReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_LIST_INDEX_TEMPLATE_DETAILS, responseObserver);
        }

        /**
         * <pre>
         * 索引相关
         * </pre>
         */
        public void createIndex(com.rany.service.platform.meta.CreateIndexRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateIndexReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_CREATE_INDEX, responseObserver);
        }

        /**
         *
         */
        public void getIndex(com.rany.service.platform.meta.GetIndexRequest request,
                             io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetIndexReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_GET_INDEX, responseObserver);
        }

        /**
         *
         */
        public void updateIndex(com.rany.service.platform.meta.UpdateIndexRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateIndexReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_UPDATE_INDEX, responseObserver);
        }

        /**
         *
         */
        public void deleteIndex(com.rany.service.platform.meta.DeleteIndexRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteIndexReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_DELETE_INDEX, responseObserver);
        }

        /**
         *
         */
        public void listIndex(com.rany.service.platform.meta.ListIndexRequest request,
                              io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_LIST_INDEX, responseObserver);
        }

        /**
         *
         */
        public void listIndexDetails(com.rany.service.platform.meta.ListIndexDetailsRequest request,
                                     io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexDetailsReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_LIST_INDEX_DETAILS, responseObserver);
        }

        /**
         *
         */
        public void listIndexName(com.rany.service.platform.meta.ListIndexNameRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexNameReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_LIST_INDEX_NAME, responseObserver);
        }

        /**
         *
         */
        public void listIndexAliasName(com.rany.service.platform.meta.ListIndexAliasNameRequest request,
                                       io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexAliasNameReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_LIST_INDEX_ALIAS_NAME, responseObserver);
        }

        /**
         *
         */
        public void attachIndex(com.rany.service.platform.meta.AttachIndexRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.AttachIndexReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_ATTACH_INDEX, responseObserver);
        }

        /**
         *
         */
        public void detachIndex(com.rany.service.platform.meta.DetachIndexRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DetachIndexReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_DETACH_INDEX, responseObserver);
        }

        /**
         *
         */
        public void refreshIndex(com.rany.service.platform.meta.RefreshIndexRequest request,
                                 io.grpc.stub.StreamObserver<com.rany.service.platform.meta.RefreshIndexReply> responseObserver) {
            asyncUnimplementedUnaryCall(METHOD_REFRESH_INDEX, responseObserver);
        }

        @java.lang.Override
        public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            METHOD_CREATE_CLUSTER,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.CreateClusterRequest,
                                            com.rany.service.platform.meta.CreateClusterReply>(
                                            this, METHODID_CREATE_CLUSTER)))
                    .addMethod(
                            METHOD_DELETE_CLUSTER,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.DeleteClusterRequest,
                                            com.rany.service.platform.meta.DeleteClusterReply>(
                                            this, METHODID_DELETE_CLUSTER)))
                    .addMethod(
                            METHOD_UPDATE_CLUSTER,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.UpdateClusterInfoRequest,
                                            com.rany.service.platform.meta.UpdateClusterInfoReply>(
                                            this, METHODID_UPDATE_CLUSTER)))
                    .addMethod(
                            METHOD_GET_CLUSTER_INFO,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.GetClusterInfoRequest,
                                            com.rany.service.platform.meta.GetClusterInfoReply>(
                                            this, METHODID_GET_CLUSTER_INFO)))
                    .addMethod(
                            METHOD_LIST_CLUSTER,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.ListClusterRequest,
                                            com.rany.service.platform.meta.ListClusterReply>(
                                            this, METHODID_LIST_CLUSTER)))
                    .addMethod(
                            METHOD_LIST_CLUSTER_DETAILS,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.ListClusterDetailsRequest,
                                            com.rany.service.platform.meta.ListClusterDetailsReply>(
                                            this, METHODID_LIST_CLUSTER_DETAILS)))
                    .addMethod(
                            METHOD_CREATE_PROJECT,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.CreateProjectRequest,
                                            com.rany.service.platform.meta.CreateProjectReply>(
                                            this, METHODID_CREATE_PROJECT)))
                    .addMethod(
                            METHOD_DELETE_PROJECT,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.DeleteProjectRequest,
                                            com.rany.service.platform.meta.DeleteProjectReply>(
                                            this, METHODID_DELETE_PROJECT)))
                    .addMethod(
                            METHOD_UPDATE_PROJECT,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.UpdateProjectRequest,
                                            com.rany.service.platform.meta.UpdateProjectReply>(
                                            this, METHODID_UPDATE_PROJECT)))
                    .addMethod(
                            METHOD_GET_PROJECT,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.GetProjectRequest,
                                            com.rany.service.platform.meta.GetProjectReply>(
                                            this, METHODID_GET_PROJECT)))
                    .addMethod(
                            METHOD_LIST_PROJECT,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.ListProjectRequest,
                                            com.rany.service.platform.meta.ListProjectReply>(
                                            this, METHODID_LIST_PROJECT)))
                    .addMethod(
                            METHOD_LIST_PROJECT_DETAILS,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.ListProjectDetailsRequest,
                                            com.rany.service.platform.meta.ListProjectDetailsReply>(
                                            this, METHODID_LIST_PROJECT_DETAILS)))
                    .addMethod(
                            METHOD_CREATE_INDEX_TEMPLATE,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.CreateIndexTemplateRequest,
                                            com.rany.service.platform.meta.CreateIndexTemplateReply>(
                                            this, METHODID_CREATE_INDEX_TEMPLATE)))
                    .addMethod(
                            METHOD_GET_INDEX_TEMPLATE,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.GetIndexTemplateRequest,
                                            com.rany.service.platform.meta.GetIndexTemplateReply>(
                                            this, METHODID_GET_INDEX_TEMPLATE)))
                    .addMethod(
                            METHOD_UPDATE_INDEX_TEMPLATE,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.UpdateIndexTemplateRequest,
                                            com.rany.service.platform.meta.UpdateIndexTemplateReply>(
                                            this, METHODID_UPDATE_INDEX_TEMPLATE)))
                    .addMethod(
                            METHOD_DELETE_INDEX_TEMPLATE,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.DeleteIndexTemplateRequest,
                                            com.rany.service.platform.meta.DeleteIndexTemplateReply>(
                                            this, METHODID_DELETE_INDEX_TEMPLATE)))
                    .addMethod(
                            METHOD_LIST_INDEX_TEMPLATE,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.ListIndexTemplateRequest,
                                            com.rany.service.platform.meta.ListIndexTemplateReply>(
                                            this, METHODID_LIST_INDEX_TEMPLATE)))
                    .addMethod(
                            METHOD_LIST_INDEX_TEMPLATE_DETAILS,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.ListIndexTemplateDetailsRequest,
                                            com.rany.service.platform.meta.ListIndexTemplateDetailsReply>(
                                            this, METHODID_LIST_INDEX_TEMPLATE_DETAILS)))
                    .addMethod(
                            METHOD_CREATE_INDEX,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.CreateIndexRequest,
                                            com.rany.service.platform.meta.CreateIndexReply>(
                                            this, METHODID_CREATE_INDEX)))
                    .addMethod(
                            METHOD_GET_INDEX,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.GetIndexRequest,
                                            com.rany.service.platform.meta.GetIndexReply>(
                                            this, METHODID_GET_INDEX)))
                    .addMethod(
                            METHOD_UPDATE_INDEX,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.UpdateIndexRequest,
                                            com.rany.service.platform.meta.UpdateIndexReply>(
                                            this, METHODID_UPDATE_INDEX)))
                    .addMethod(
                            METHOD_DELETE_INDEX,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.DeleteIndexRequest,
                                            com.rany.service.platform.meta.DeleteIndexReply>(
                                            this, METHODID_DELETE_INDEX)))
                    .addMethod(
                            METHOD_LIST_INDEX,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.ListIndexRequest,
                                            com.rany.service.platform.meta.ListIndexReply>(
                                            this, METHODID_LIST_INDEX)))
                    .addMethod(
                            METHOD_LIST_INDEX_DETAILS,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.ListIndexDetailsRequest,
                                            com.rany.service.platform.meta.ListIndexDetailsReply>(
                                            this, METHODID_LIST_INDEX_DETAILS)))
                    .addMethod(
                            METHOD_LIST_INDEX_NAME,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.ListIndexNameRequest,
                                            com.rany.service.platform.meta.ListIndexNameReply>(
                                            this, METHODID_LIST_INDEX_NAME)))
                    .addMethod(
                            METHOD_LIST_INDEX_ALIAS_NAME,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.ListIndexAliasNameRequest,
                                            com.rany.service.platform.meta.ListIndexAliasNameReply>(
                                            this, METHODID_LIST_INDEX_ALIAS_NAME)))
                    .addMethod(
                            METHOD_ATTACH_INDEX,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.AttachIndexRequest,
                                            com.rany.service.platform.meta.AttachIndexReply>(
                                            this, METHODID_ATTACH_INDEX)))
                    .addMethod(
                            METHOD_DETACH_INDEX,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.DetachIndexRequest,
                                            com.rany.service.platform.meta.DetachIndexReply>(
                                            this, METHODID_DETACH_INDEX)))
                    .addMethod(
                            METHOD_REFRESH_INDEX,
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.rany.service.platform.meta.RefreshIndexRequest,
                                            com.rany.service.platform.meta.RefreshIndexReply>(
                                            this, METHODID_REFRESH_INDEX)))
                    .build();
        }
    }

    /**
     *
     */
    public static final class MetaServiceStub extends io.grpc.stub.AbstractStub<MetaServiceStub> {
        private MetaServiceStub(io.grpc.Channel channel) {
            super(channel);
        }

        private MetaServiceStub(io.grpc.Channel channel,
                                io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected MetaServiceStub build(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            return new MetaServiceStub(channel, callOptions);
        }

        /**
         * <pre>
         * 集群相关
         * </pre>
         */
        public void createCluster(com.rany.service.platform.meta.CreateClusterRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateClusterReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_CREATE_CLUSTER, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void deleteCluster(com.rany.service.platform.meta.DeleteClusterRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteClusterReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_DELETE_CLUSTER, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void updateCluster(com.rany.service.platform.meta.UpdateClusterInfoRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateClusterInfoReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_UPDATE_CLUSTER, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void getClusterInfo(com.rany.service.platform.meta.GetClusterInfoRequest request,
                                   io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetClusterInfoReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_GET_CLUSTER_INFO, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void listCluster(com.rany.service.platform.meta.ListClusterRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListClusterReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_LIST_CLUSTER, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void listClusterDetails(com.rany.service.platform.meta.ListClusterDetailsRequest request,
                                       io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListClusterDetailsReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_LIST_CLUSTER_DETAILS, getCallOptions()), request, responseObserver);
        }

        /**
         * <pre>
         * 项目相关
         * </pre>
         */
        public void createProject(com.rany.service.platform.meta.CreateProjectRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateProjectReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_CREATE_PROJECT, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void deleteProject(com.rany.service.platform.meta.DeleteProjectRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteProjectReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_DELETE_PROJECT, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void updateProject(com.rany.service.platform.meta.UpdateProjectRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateProjectReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_UPDATE_PROJECT, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void getProject(com.rany.service.platform.meta.GetProjectRequest request,
                               io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetProjectReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_GET_PROJECT, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void listProject(com.rany.service.platform.meta.ListProjectRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListProjectReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_LIST_PROJECT, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void listProjectDetails(com.rany.service.platform.meta.ListProjectDetailsRequest request,
                                       io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListProjectDetailsReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_LIST_PROJECT_DETAILS, getCallOptions()), request, responseObserver);
        }

        /**
         * <pre>
         * 模版
         * </pre>
         */
        public void createIndexTemplate(com.rany.service.platform.meta.CreateIndexTemplateRequest request,
                                        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateIndexTemplateReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_CREATE_INDEX_TEMPLATE, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void getIndexTemplate(com.rany.service.platform.meta.GetIndexTemplateRequest request,
                                     io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetIndexTemplateReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_GET_INDEX_TEMPLATE, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void updateIndexTemplate(com.rany.service.platform.meta.UpdateIndexTemplateRequest request,
                                        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateIndexTemplateReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_UPDATE_INDEX_TEMPLATE, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void deleteIndexTemplate(com.rany.service.platform.meta.DeleteIndexTemplateRequest request,
                                        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteIndexTemplateReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_DELETE_INDEX_TEMPLATE, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void listIndexTemplate(com.rany.service.platform.meta.ListIndexTemplateRequest request,
                                      io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexTemplateReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX_TEMPLATE, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void listIndexTemplateDetails(com.rany.service.platform.meta.ListIndexTemplateDetailsRequest request,
                                             io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexTemplateDetailsReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX_TEMPLATE_DETAILS, getCallOptions()), request, responseObserver);
        }

        /**
         * <pre>
         * 索引相关
         * </pre>
         */
        public void createIndex(com.rany.service.platform.meta.CreateIndexRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateIndexReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_CREATE_INDEX, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void getIndex(com.rany.service.platform.meta.GetIndexRequest request,
                             io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetIndexReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_GET_INDEX, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void updateIndex(com.rany.service.platform.meta.UpdateIndexRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateIndexReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_UPDATE_INDEX, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void deleteIndex(com.rany.service.platform.meta.DeleteIndexRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteIndexReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_DELETE_INDEX, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void listIndex(com.rany.service.platform.meta.ListIndexRequest request,
                              io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void listIndexDetails(com.rany.service.platform.meta.ListIndexDetailsRequest request,
                                     io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexDetailsReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX_DETAILS, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void listIndexName(com.rany.service.platform.meta.ListIndexNameRequest request,
                                  io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexNameReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX_NAME, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void listIndexAliasName(com.rany.service.platform.meta.ListIndexAliasNameRequest request,
                                       io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexAliasNameReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX_ALIAS_NAME, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void attachIndex(com.rany.service.platform.meta.AttachIndexRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.AttachIndexReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_ATTACH_INDEX, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void detachIndex(com.rany.service.platform.meta.DetachIndexRequest request,
                                io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DetachIndexReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_DETACH_INDEX, getCallOptions()), request, responseObserver);
        }

        /**
         *
         */
        public void refreshIndex(com.rany.service.platform.meta.RefreshIndexRequest request,
                                 io.grpc.stub.StreamObserver<com.rany.service.platform.meta.RefreshIndexReply> responseObserver) {
            asyncUnaryCall(
                    getChannel().newCall(METHOD_REFRESH_INDEX, getCallOptions()), request, responseObserver);
        }
    }

    /**
     *
     */
    public static final class MetaServiceBlockingStub extends io.grpc.stub.AbstractStub<MetaServiceBlockingStub> {
        private MetaServiceBlockingStub(io.grpc.Channel channel) {
            super(channel);
        }

        private MetaServiceBlockingStub(io.grpc.Channel channel,
                                        io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected MetaServiceBlockingStub build(io.grpc.Channel channel,
                                                io.grpc.CallOptions callOptions) {
            return new MetaServiceBlockingStub(channel, callOptions);
        }

        /**
         * <pre>
         * 集群相关
         * </pre>
         */
        public com.rany.service.platform.meta.CreateClusterReply createCluster(com.rany.service.platform.meta.CreateClusterRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_CREATE_CLUSTER, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.DeleteClusterReply deleteCluster(com.rany.service.platform.meta.DeleteClusterRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_DELETE_CLUSTER, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.UpdateClusterInfoReply updateCluster(com.rany.service.platform.meta.UpdateClusterInfoRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_UPDATE_CLUSTER, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.GetClusterInfoReply getClusterInfo(com.rany.service.platform.meta.GetClusterInfoRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_GET_CLUSTER_INFO, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.ListClusterReply listCluster(com.rany.service.platform.meta.ListClusterRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_LIST_CLUSTER, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.ListClusterDetailsReply listClusterDetails(com.rany.service.platform.meta.ListClusterDetailsRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_LIST_CLUSTER_DETAILS, getCallOptions(), request);
        }

        /**
         * <pre>
         * 项目相关
         * </pre>
         */
        public com.rany.service.platform.meta.CreateProjectReply createProject(com.rany.service.platform.meta.CreateProjectRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_CREATE_PROJECT, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.DeleteProjectReply deleteProject(com.rany.service.platform.meta.DeleteProjectRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_DELETE_PROJECT, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.UpdateProjectReply updateProject(com.rany.service.platform.meta.UpdateProjectRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_UPDATE_PROJECT, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.GetProjectReply getProject(com.rany.service.platform.meta.GetProjectRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_GET_PROJECT, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.ListProjectReply listProject(com.rany.service.platform.meta.ListProjectRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_LIST_PROJECT, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.ListProjectDetailsReply listProjectDetails(com.rany.service.platform.meta.ListProjectDetailsRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_LIST_PROJECT_DETAILS, getCallOptions(), request);
        }

        /**
         * <pre>
         * 模版
         * </pre>
         */
        public com.rany.service.platform.meta.CreateIndexTemplateReply createIndexTemplate(com.rany.service.platform.meta.CreateIndexTemplateRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_CREATE_INDEX_TEMPLATE, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.GetIndexTemplateReply getIndexTemplate(com.rany.service.platform.meta.GetIndexTemplateRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_GET_INDEX_TEMPLATE, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.UpdateIndexTemplateReply updateIndexTemplate(com.rany.service.platform.meta.UpdateIndexTemplateRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_UPDATE_INDEX_TEMPLATE, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.DeleteIndexTemplateReply deleteIndexTemplate(com.rany.service.platform.meta.DeleteIndexTemplateRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_DELETE_INDEX_TEMPLATE, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.ListIndexTemplateReply listIndexTemplate(com.rany.service.platform.meta.ListIndexTemplateRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_LIST_INDEX_TEMPLATE, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.ListIndexTemplateDetailsReply listIndexTemplateDetails(com.rany.service.platform.meta.ListIndexTemplateDetailsRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_LIST_INDEX_TEMPLATE_DETAILS, getCallOptions(), request);
        }

        /**
         * <pre>
         * 索引相关
         * </pre>
         */
        public com.rany.service.platform.meta.CreateIndexReply createIndex(com.rany.service.platform.meta.CreateIndexRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_CREATE_INDEX, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.GetIndexReply getIndex(com.rany.service.platform.meta.GetIndexRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_GET_INDEX, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.UpdateIndexReply updateIndex(com.rany.service.platform.meta.UpdateIndexRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_UPDATE_INDEX, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.DeleteIndexReply deleteIndex(com.rany.service.platform.meta.DeleteIndexRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_DELETE_INDEX, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.ListIndexReply listIndex(com.rany.service.platform.meta.ListIndexRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_LIST_INDEX, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.ListIndexDetailsReply listIndexDetails(com.rany.service.platform.meta.ListIndexDetailsRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_LIST_INDEX_DETAILS, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.ListIndexNameReply listIndexName(com.rany.service.platform.meta.ListIndexNameRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_LIST_INDEX_NAME, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.ListIndexAliasNameReply listIndexAliasName(com.rany.service.platform.meta.ListIndexAliasNameRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_LIST_INDEX_ALIAS_NAME, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.AttachIndexReply attachIndex(com.rany.service.platform.meta.AttachIndexRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_ATTACH_INDEX, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.DetachIndexReply detachIndex(com.rany.service.platform.meta.DetachIndexRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_DETACH_INDEX, getCallOptions(), request);
        }

        /**
         *
         */
        public com.rany.service.platform.meta.RefreshIndexReply refreshIndex(com.rany.service.platform.meta.RefreshIndexRequest request) {
            return blockingUnaryCall(
                    getChannel(), METHOD_REFRESH_INDEX, getCallOptions(), request);
        }
    }

    /**
     *
     */
    public static final class MetaServiceFutureStub extends io.grpc.stub.AbstractStub<MetaServiceFutureStub> {
        private MetaServiceFutureStub(io.grpc.Channel channel) {
            super(channel);
        }

        private MetaServiceFutureStub(io.grpc.Channel channel,
                                      io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected MetaServiceFutureStub build(io.grpc.Channel channel,
                                              io.grpc.CallOptions callOptions) {
            return new MetaServiceFutureStub(channel, callOptions);
        }

        /**
         * <pre>
         * 集群相关
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.CreateClusterReply> createCluster(
                com.rany.service.platform.meta.CreateClusterRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_CREATE_CLUSTER, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.DeleteClusterReply> deleteCluster(
                com.rany.service.platform.meta.DeleteClusterRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_DELETE_CLUSTER, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.UpdateClusterInfoReply> updateCluster(
                com.rany.service.platform.meta.UpdateClusterInfoRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_UPDATE_CLUSTER, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.GetClusterInfoReply> getClusterInfo(
                com.rany.service.platform.meta.GetClusterInfoRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_GET_CLUSTER_INFO, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListClusterReply> listCluster(
                com.rany.service.platform.meta.ListClusterRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_LIST_CLUSTER, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListClusterDetailsReply> listClusterDetails(
                com.rany.service.platform.meta.ListClusterDetailsRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_LIST_CLUSTER_DETAILS, getCallOptions()), request);
        }

        /**
         * <pre>
         * 项目相关
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.CreateProjectReply> createProject(
                com.rany.service.platform.meta.CreateProjectRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_CREATE_PROJECT, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.DeleteProjectReply> deleteProject(
                com.rany.service.platform.meta.DeleteProjectRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_DELETE_PROJECT, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.UpdateProjectReply> updateProject(
                com.rany.service.platform.meta.UpdateProjectRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_UPDATE_PROJECT, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.GetProjectReply> getProject(
                com.rany.service.platform.meta.GetProjectRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_GET_PROJECT, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListProjectReply> listProject(
                com.rany.service.platform.meta.ListProjectRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_LIST_PROJECT, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListProjectDetailsReply> listProjectDetails(
                com.rany.service.platform.meta.ListProjectDetailsRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_LIST_PROJECT_DETAILS, getCallOptions()), request);
        }

        /**
         * <pre>
         * 模版
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.CreateIndexTemplateReply> createIndexTemplate(
                com.rany.service.platform.meta.CreateIndexTemplateRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_CREATE_INDEX_TEMPLATE, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.GetIndexTemplateReply> getIndexTemplate(
                com.rany.service.platform.meta.GetIndexTemplateRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_GET_INDEX_TEMPLATE, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.UpdateIndexTemplateReply> updateIndexTemplate(
                com.rany.service.platform.meta.UpdateIndexTemplateRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_UPDATE_INDEX_TEMPLATE, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.DeleteIndexTemplateReply> deleteIndexTemplate(
                com.rany.service.platform.meta.DeleteIndexTemplateRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_DELETE_INDEX_TEMPLATE, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexTemplateReply> listIndexTemplate(
                com.rany.service.platform.meta.ListIndexTemplateRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX_TEMPLATE, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexTemplateDetailsReply> listIndexTemplateDetails(
                com.rany.service.platform.meta.ListIndexTemplateDetailsRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX_TEMPLATE_DETAILS, getCallOptions()), request);
        }

        /**
         * <pre>
         * 索引相关
         * </pre>
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.CreateIndexReply> createIndex(
                com.rany.service.platform.meta.CreateIndexRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_CREATE_INDEX, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.GetIndexReply> getIndex(
                com.rany.service.platform.meta.GetIndexRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_GET_INDEX, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.UpdateIndexReply> updateIndex(
                com.rany.service.platform.meta.UpdateIndexRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_UPDATE_INDEX, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.DeleteIndexReply> deleteIndex(
                com.rany.service.platform.meta.DeleteIndexRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_DELETE_INDEX, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexReply> listIndex(
                com.rany.service.platform.meta.ListIndexRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexDetailsReply> listIndexDetails(
                com.rany.service.platform.meta.ListIndexDetailsRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX_DETAILS, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexNameReply> listIndexName(
                com.rany.service.platform.meta.ListIndexNameRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX_NAME, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexAliasNameReply> listIndexAliasName(
                com.rany.service.platform.meta.ListIndexAliasNameRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_LIST_INDEX_ALIAS_NAME, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.AttachIndexReply> attachIndex(
                com.rany.service.platform.meta.AttachIndexRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_ATTACH_INDEX, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.DetachIndexReply> detachIndex(
                com.rany.service.platform.meta.DetachIndexRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_DETACH_INDEX, getCallOptions()), request);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.RefreshIndexReply> refreshIndex(
                com.rany.service.platform.meta.RefreshIndexRequest request) {
            return futureUnaryCall(
                    getChannel().newCall(METHOD_REFRESH_INDEX, getCallOptions()), request);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final MetaServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(MetaServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE_CLUSTER:
                    serviceImpl.createCluster((com.rany.service.platform.meta.CreateClusterRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateClusterReply>) responseObserver);
                    break;
                case METHODID_DELETE_CLUSTER:
                    serviceImpl.deleteCluster((com.rany.service.platform.meta.DeleteClusterRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteClusterReply>) responseObserver);
                    break;
                case METHODID_UPDATE_CLUSTER:
                    serviceImpl.updateCluster((com.rany.service.platform.meta.UpdateClusterInfoRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateClusterInfoReply>) responseObserver);
                    break;
                case METHODID_GET_CLUSTER_INFO:
                    serviceImpl.getClusterInfo((com.rany.service.platform.meta.GetClusterInfoRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetClusterInfoReply>) responseObserver);
                    break;
                case METHODID_LIST_CLUSTER:
                    serviceImpl.listCluster((com.rany.service.platform.meta.ListClusterRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListClusterReply>) responseObserver);
                    break;
                case METHODID_LIST_CLUSTER_DETAILS:
                    serviceImpl.listClusterDetails((com.rany.service.platform.meta.ListClusterDetailsRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListClusterDetailsReply>) responseObserver);
                    break;
                case METHODID_CREATE_PROJECT:
                    serviceImpl.createProject((com.rany.service.platform.meta.CreateProjectRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateProjectReply>) responseObserver);
                    break;
                case METHODID_DELETE_PROJECT:
                    serviceImpl.deleteProject((com.rany.service.platform.meta.DeleteProjectRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteProjectReply>) responseObserver);
                    break;
                case METHODID_UPDATE_PROJECT:
                    serviceImpl.updateProject((com.rany.service.platform.meta.UpdateProjectRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateProjectReply>) responseObserver);
                    break;
                case METHODID_GET_PROJECT:
                    serviceImpl.getProject((com.rany.service.platform.meta.GetProjectRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetProjectReply>) responseObserver);
                    break;
                case METHODID_LIST_PROJECT:
                    serviceImpl.listProject((com.rany.service.platform.meta.ListProjectRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListProjectReply>) responseObserver);
                    break;
                case METHODID_LIST_PROJECT_DETAILS:
                    serviceImpl.listProjectDetails((com.rany.service.platform.meta.ListProjectDetailsRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListProjectDetailsReply>) responseObserver);
                    break;
                case METHODID_CREATE_INDEX_TEMPLATE:
                    serviceImpl.createIndexTemplate((com.rany.service.platform.meta.CreateIndexTemplateRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateIndexTemplateReply>) responseObserver);
                    break;
                case METHODID_GET_INDEX_TEMPLATE:
                    serviceImpl.getIndexTemplate((com.rany.service.platform.meta.GetIndexTemplateRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetIndexTemplateReply>) responseObserver);
                    break;
                case METHODID_UPDATE_INDEX_TEMPLATE:
                    serviceImpl.updateIndexTemplate((com.rany.service.platform.meta.UpdateIndexTemplateRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateIndexTemplateReply>) responseObserver);
                    break;
                case METHODID_DELETE_INDEX_TEMPLATE:
                    serviceImpl.deleteIndexTemplate((com.rany.service.platform.meta.DeleteIndexTemplateRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteIndexTemplateReply>) responseObserver);
                    break;
                case METHODID_LIST_INDEX_TEMPLATE:
                    serviceImpl.listIndexTemplate((com.rany.service.platform.meta.ListIndexTemplateRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexTemplateReply>) responseObserver);
                    break;
                case METHODID_LIST_INDEX_TEMPLATE_DETAILS:
                    serviceImpl.listIndexTemplateDetails((com.rany.service.platform.meta.ListIndexTemplateDetailsRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexTemplateDetailsReply>) responseObserver);
                    break;
                case METHODID_CREATE_INDEX:
                    serviceImpl.createIndex((com.rany.service.platform.meta.CreateIndexRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateIndexReply>) responseObserver);
                    break;
                case METHODID_GET_INDEX:
                    serviceImpl.getIndex((com.rany.service.platform.meta.GetIndexRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetIndexReply>) responseObserver);
                    break;
                case METHODID_UPDATE_INDEX:
                    serviceImpl.updateIndex((com.rany.service.platform.meta.UpdateIndexRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateIndexReply>) responseObserver);
                    break;
                case METHODID_DELETE_INDEX:
                    serviceImpl.deleteIndex((com.rany.service.platform.meta.DeleteIndexRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteIndexReply>) responseObserver);
                    break;
                case METHODID_LIST_INDEX:
                    serviceImpl.listIndex((com.rany.service.platform.meta.ListIndexRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexReply>) responseObserver);
                    break;
                case METHODID_LIST_INDEX_DETAILS:
                    serviceImpl.listIndexDetails((com.rany.service.platform.meta.ListIndexDetailsRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexDetailsReply>) responseObserver);
                    break;
                case METHODID_LIST_INDEX_NAME:
                    serviceImpl.listIndexName((com.rany.service.platform.meta.ListIndexNameRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexNameReply>) responseObserver);
                    break;
                case METHODID_LIST_INDEX_ALIAS_NAME:
                    serviceImpl.listIndexAliasName((com.rany.service.platform.meta.ListIndexAliasNameRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexAliasNameReply>) responseObserver);
                    break;
                case METHODID_ATTACH_INDEX:
                    serviceImpl.attachIndex((com.rany.service.platform.meta.AttachIndexRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.AttachIndexReply>) responseObserver);
                    break;
                case METHODID_DETACH_INDEX:
                    serviceImpl.detachIndex((com.rany.service.platform.meta.DetachIndexRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DetachIndexReply>) responseObserver);
                    break;
                case METHODID_REFRESH_INDEX:
                    serviceImpl.refreshIndex((com.rany.service.platform.meta.RefreshIndexRequest) request,
                            (io.grpc.stub.StreamObserver<com.rany.service.platform.meta.RefreshIndexReply>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class MetaServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
        MetaServiceBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return com.rany.service.platform.meta.SearchMiddlePlatformMetaService.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("MetaService");
        }
    }

    private static final class MetaServiceFileDescriptorSupplier
            extends MetaServiceBaseDescriptorSupplier {
        MetaServiceFileDescriptorSupplier() {
        }
    }

    private static final class MetaServiceMethodDescriptorSupplier
            extends MetaServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
        private final String methodName;

        MetaServiceMethodDescriptorSupplier(String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }
}
