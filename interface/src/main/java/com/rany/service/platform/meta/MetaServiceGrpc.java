package com.rany.service.platform.meta;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: admin/meta.proto")
public final class MetaServiceGrpc {

  private MetaServiceGrpc() {}

  public static final String SERVICE_NAME = "MetaService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateClusterRequest,
      com.rany.service.platform.meta.CreateClusterReply> METHOD_CREATE_CLUSTER = getCreateClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateClusterRequest,
      com.rany.service.platform.meta.CreateClusterReply> getCreateClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateClusterRequest,
      com.rany.service.platform.meta.CreateClusterReply> getCreateClusterMethod() {
    return getCreateClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateClusterRequest,
      com.rany.service.platform.meta.CreateClusterReply> getCreateClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateClusterRequest, com.rany.service.platform.meta.CreateClusterReply> getCreateClusterMethod;
    if ((getCreateClusterMethod = MetaServiceGrpc.getCreateClusterMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getCreateClusterMethod = MetaServiceGrpc.getCreateClusterMethod) == null) {
          MetaServiceGrpc.getCreateClusterMethod = getCreateClusterMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.CreateClusterRequest, com.rany.service.platform.meta.CreateClusterReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "CreateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.CreateClusterReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("CreateCluster"))
                  .build();
          }
        }
     }
     return getCreateClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteClusterRequest,
      com.rany.service.platform.meta.DeleteClusterReply> METHOD_DELETE_CLUSTER = getDeleteClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteClusterRequest,
      com.rany.service.platform.meta.DeleteClusterReply> getDeleteClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteClusterRequest,
      com.rany.service.platform.meta.DeleteClusterReply> getDeleteClusterMethod() {
    return getDeleteClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteClusterRequest,
      com.rany.service.platform.meta.DeleteClusterReply> getDeleteClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteClusterRequest, com.rany.service.platform.meta.DeleteClusterReply> getDeleteClusterMethod;
    if ((getDeleteClusterMethod = MetaServiceGrpc.getDeleteClusterMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getDeleteClusterMethod = MetaServiceGrpc.getDeleteClusterMethod) == null) {
          MetaServiceGrpc.getDeleteClusterMethod = getDeleteClusterMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.DeleteClusterRequest, com.rany.service.platform.meta.DeleteClusterReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "DeleteCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.DeleteClusterReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("DeleteCluster"))
                  .build();
          }
        }
     }
     return getDeleteClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateClusterInfoRequest,
      com.rany.service.platform.meta.UpdateClusterInfoReply> METHOD_UPDATE_CLUSTER = getUpdateClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateClusterInfoRequest,
      com.rany.service.platform.meta.UpdateClusterInfoReply> getUpdateClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateClusterInfoRequest,
      com.rany.service.platform.meta.UpdateClusterInfoReply> getUpdateClusterMethod() {
    return getUpdateClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateClusterInfoRequest,
      com.rany.service.platform.meta.UpdateClusterInfoReply> getUpdateClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateClusterInfoRequest, com.rany.service.platform.meta.UpdateClusterInfoReply> getUpdateClusterMethod;
    if ((getUpdateClusterMethod = MetaServiceGrpc.getUpdateClusterMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getUpdateClusterMethod = MetaServiceGrpc.getUpdateClusterMethod) == null) {
          MetaServiceGrpc.getUpdateClusterMethod = getUpdateClusterMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.UpdateClusterInfoRequest, com.rany.service.platform.meta.UpdateClusterInfoReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "UpdateCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.UpdateClusterInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.UpdateClusterInfoReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("UpdateCluster"))
                  .build();
          }
        }
     }
     return getUpdateClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetClusterInfoMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetClusterInfoRequest,
      com.rany.service.platform.meta.GetClusterInfoReply> METHOD_GET_CLUSTER_INFO = getGetClusterInfoMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetClusterInfoRequest,
      com.rany.service.platform.meta.GetClusterInfoReply> getGetClusterInfoMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetClusterInfoRequest,
      com.rany.service.platform.meta.GetClusterInfoReply> getGetClusterInfoMethod() {
    return getGetClusterInfoMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetClusterInfoRequest,
      com.rany.service.platform.meta.GetClusterInfoReply> getGetClusterInfoMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetClusterInfoRequest, com.rany.service.platform.meta.GetClusterInfoReply> getGetClusterInfoMethod;
    if ((getGetClusterInfoMethod = MetaServiceGrpc.getGetClusterInfoMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getGetClusterInfoMethod = MetaServiceGrpc.getGetClusterInfoMethod) == null) {
          MetaServiceGrpc.getGetClusterInfoMethod = getGetClusterInfoMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.GetClusterInfoRequest, com.rany.service.platform.meta.GetClusterInfoReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "GetClusterInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.GetClusterInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.GetClusterInfoReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("GetClusterInfo"))
                  .build();
          }
        }
     }
     return getGetClusterInfoMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListClusterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterRequest,
      com.rany.service.platform.meta.ListClusterReply> METHOD_LIST_CLUSTER = getListClusterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterRequest,
      com.rany.service.platform.meta.ListClusterReply> getListClusterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterRequest,
      com.rany.service.platform.meta.ListClusterReply> getListClusterMethod() {
    return getListClusterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterRequest,
      com.rany.service.platform.meta.ListClusterReply> getListClusterMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterRequest, com.rany.service.platform.meta.ListClusterReply> getListClusterMethod;
    if ((getListClusterMethod = MetaServiceGrpc.getListClusterMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getListClusterMethod = MetaServiceGrpc.getListClusterMethod) == null) {
          MetaServiceGrpc.getListClusterMethod = getListClusterMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListClusterRequest, com.rany.service.platform.meta.ListClusterReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "ListCluster"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListClusterReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListCluster"))
                  .build();
          }
        }
     }
     return getListClusterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListClusterDetailsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterDetailsRequest,
      com.rany.service.platform.meta.ListClusterDetailsReply> METHOD_LIST_CLUSTER_DETAILS = getListClusterDetailsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterDetailsRequest,
      com.rany.service.platform.meta.ListClusterDetailsReply> getListClusterDetailsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterDetailsRequest,
      com.rany.service.platform.meta.ListClusterDetailsReply> getListClusterDetailsMethod() {
    return getListClusterDetailsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterDetailsRequest,
      com.rany.service.platform.meta.ListClusterDetailsReply> getListClusterDetailsMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListClusterDetailsRequest, com.rany.service.platform.meta.ListClusterDetailsReply> getListClusterDetailsMethod;
    if ((getListClusterDetailsMethod = MetaServiceGrpc.getListClusterDetailsMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getListClusterDetailsMethod = MetaServiceGrpc.getListClusterDetailsMethod) == null) {
          MetaServiceGrpc.getListClusterDetailsMethod = getListClusterDetailsMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListClusterDetailsRequest, com.rany.service.platform.meta.ListClusterDetailsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "ListClusterDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListClusterDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListClusterDetailsReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListClusterDetails"))
                  .build();
          }
        }
     }
     return getListClusterDetailsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateProjectMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateProjectRequest,
      com.rany.service.platform.meta.CreateProjectReply> METHOD_CREATE_PROJECT = getCreateProjectMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateProjectRequest,
      com.rany.service.platform.meta.CreateProjectReply> getCreateProjectMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateProjectRequest,
      com.rany.service.platform.meta.CreateProjectReply> getCreateProjectMethod() {
    return getCreateProjectMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateProjectRequest,
      com.rany.service.platform.meta.CreateProjectReply> getCreateProjectMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateProjectRequest, com.rany.service.platform.meta.CreateProjectReply> getCreateProjectMethod;
    if ((getCreateProjectMethod = MetaServiceGrpc.getCreateProjectMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getCreateProjectMethod = MetaServiceGrpc.getCreateProjectMethod) == null) {
          MetaServiceGrpc.getCreateProjectMethod = getCreateProjectMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.CreateProjectRequest, com.rany.service.platform.meta.CreateProjectReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "CreateProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.CreateProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.CreateProjectReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("CreateProject"))
                  .build();
          }
        }
     }
     return getCreateProjectMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteProjectMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteProjectRequest,
      com.rany.service.platform.meta.DeleteProjectReply> METHOD_DELETE_PROJECT = getDeleteProjectMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteProjectRequest,
      com.rany.service.platform.meta.DeleteProjectReply> getDeleteProjectMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteProjectRequest,
      com.rany.service.platform.meta.DeleteProjectReply> getDeleteProjectMethod() {
    return getDeleteProjectMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteProjectRequest,
      com.rany.service.platform.meta.DeleteProjectReply> getDeleteProjectMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteProjectRequest, com.rany.service.platform.meta.DeleteProjectReply> getDeleteProjectMethod;
    if ((getDeleteProjectMethod = MetaServiceGrpc.getDeleteProjectMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getDeleteProjectMethod = MetaServiceGrpc.getDeleteProjectMethod) == null) {
          MetaServiceGrpc.getDeleteProjectMethod = getDeleteProjectMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.DeleteProjectRequest, com.rany.service.platform.meta.DeleteProjectReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "DeleteProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.DeleteProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.DeleteProjectReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("DeleteProject"))
                  .build();
          }
        }
     }
     return getDeleteProjectMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateProjectMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateProjectRequest,
      com.rany.service.platform.meta.UpdateProjectReply> METHOD_UPDATE_PROJECT = getUpdateProjectMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateProjectRequest,
      com.rany.service.platform.meta.UpdateProjectReply> getUpdateProjectMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateProjectRequest,
      com.rany.service.platform.meta.UpdateProjectReply> getUpdateProjectMethod() {
    return getUpdateProjectMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateProjectRequest,
      com.rany.service.platform.meta.UpdateProjectReply> getUpdateProjectMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateProjectRequest, com.rany.service.platform.meta.UpdateProjectReply> getUpdateProjectMethod;
    if ((getUpdateProjectMethod = MetaServiceGrpc.getUpdateProjectMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getUpdateProjectMethod = MetaServiceGrpc.getUpdateProjectMethod) == null) {
          MetaServiceGrpc.getUpdateProjectMethod = getUpdateProjectMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.UpdateProjectRequest, com.rany.service.platform.meta.UpdateProjectReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "UpdateProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.UpdateProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.UpdateProjectReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("UpdateProject"))
                  .build();
          }
        }
     }
     return getUpdateProjectMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetProjectMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetProjectRequest,
      com.rany.service.platform.meta.GetProjectReply> METHOD_GET_PROJECT = getGetProjectMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetProjectRequest,
      com.rany.service.platform.meta.GetProjectReply> getGetProjectMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetProjectRequest,
      com.rany.service.platform.meta.GetProjectReply> getGetProjectMethod() {
    return getGetProjectMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetProjectRequest,
      com.rany.service.platform.meta.GetProjectReply> getGetProjectMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetProjectRequest, com.rany.service.platform.meta.GetProjectReply> getGetProjectMethod;
    if ((getGetProjectMethod = MetaServiceGrpc.getGetProjectMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getGetProjectMethod = MetaServiceGrpc.getGetProjectMethod) == null) {
          MetaServiceGrpc.getGetProjectMethod = getGetProjectMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.GetProjectRequest, com.rany.service.platform.meta.GetProjectReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "GetProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.GetProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.GetProjectReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("GetProject"))
                  .build();
          }
        }
     }
     return getGetProjectMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListProjectMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectRequest,
      com.rany.service.platform.meta.ListProjectReply> METHOD_LIST_PROJECT = getListProjectMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectRequest,
      com.rany.service.platform.meta.ListProjectReply> getListProjectMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectRequest,
      com.rany.service.platform.meta.ListProjectReply> getListProjectMethod() {
    return getListProjectMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectRequest,
      com.rany.service.platform.meta.ListProjectReply> getListProjectMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectRequest, com.rany.service.platform.meta.ListProjectReply> getListProjectMethod;
    if ((getListProjectMethod = MetaServiceGrpc.getListProjectMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getListProjectMethod = MetaServiceGrpc.getListProjectMethod) == null) {
          MetaServiceGrpc.getListProjectMethod = getListProjectMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListProjectRequest, com.rany.service.platform.meta.ListProjectReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "ListProject"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListProjectReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListProject"))
                  .build();
          }
        }
     }
     return getListProjectMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListProjectDetailsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectDetailsRequest,
      com.rany.service.platform.meta.ListProjectDetailsReply> METHOD_LIST_PROJECT_DETAILS = getListProjectDetailsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectDetailsRequest,
      com.rany.service.platform.meta.ListProjectDetailsReply> getListProjectDetailsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectDetailsRequest,
      com.rany.service.platform.meta.ListProjectDetailsReply> getListProjectDetailsMethod() {
    return getListProjectDetailsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectDetailsRequest,
      com.rany.service.platform.meta.ListProjectDetailsReply> getListProjectDetailsMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListProjectDetailsRequest, com.rany.service.platform.meta.ListProjectDetailsReply> getListProjectDetailsMethod;
    if ((getListProjectDetailsMethod = MetaServiceGrpc.getListProjectDetailsMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getListProjectDetailsMethod = MetaServiceGrpc.getListProjectDetailsMethod) == null) {
          MetaServiceGrpc.getListProjectDetailsMethod = getListProjectDetailsMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListProjectDetailsRequest, com.rany.service.platform.meta.ListProjectDetailsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "ListProjectDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListProjectDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListProjectDetailsReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListProjectDetails"))
                  .build();
          }
        }
     }
     return getListProjectDetailsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateIndexTemplateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexTemplateRequest,
      com.rany.service.platform.meta.CreateIndexTemplateReply> METHOD_CREATE_INDEX_TEMPLATE = getCreateIndexTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexTemplateRequest,
      com.rany.service.platform.meta.CreateIndexTemplateReply> getCreateIndexTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexTemplateRequest,
      com.rany.service.platform.meta.CreateIndexTemplateReply> getCreateIndexTemplateMethod() {
    return getCreateIndexTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexTemplateRequest,
      com.rany.service.platform.meta.CreateIndexTemplateReply> getCreateIndexTemplateMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexTemplateRequest, com.rany.service.platform.meta.CreateIndexTemplateReply> getCreateIndexTemplateMethod;
    if ((getCreateIndexTemplateMethod = MetaServiceGrpc.getCreateIndexTemplateMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getCreateIndexTemplateMethod = MetaServiceGrpc.getCreateIndexTemplateMethod) == null) {
          MetaServiceGrpc.getCreateIndexTemplateMethod = getCreateIndexTemplateMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.CreateIndexTemplateRequest, com.rany.service.platform.meta.CreateIndexTemplateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "CreateIndexTemplate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.CreateIndexTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.CreateIndexTemplateReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("CreateIndexTemplate"))
                  .build();
          }
        }
     }
     return getCreateIndexTemplateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIndexTemplateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexTemplateRequest,
      com.rany.service.platform.meta.GetIndexTemplateReply> METHOD_GET_INDEX_TEMPLATE = getGetIndexTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexTemplateRequest,
      com.rany.service.platform.meta.GetIndexTemplateReply> getGetIndexTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexTemplateRequest,
      com.rany.service.platform.meta.GetIndexTemplateReply> getGetIndexTemplateMethod() {
    return getGetIndexTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexTemplateRequest,
      com.rany.service.platform.meta.GetIndexTemplateReply> getGetIndexTemplateMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexTemplateRequest, com.rany.service.platform.meta.GetIndexTemplateReply> getGetIndexTemplateMethod;
    if ((getGetIndexTemplateMethod = MetaServiceGrpc.getGetIndexTemplateMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getGetIndexTemplateMethod = MetaServiceGrpc.getGetIndexTemplateMethod) == null) {
          MetaServiceGrpc.getGetIndexTemplateMethod = getGetIndexTemplateMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.GetIndexTemplateRequest, com.rany.service.platform.meta.GetIndexTemplateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "GetIndexTemplate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.GetIndexTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.GetIndexTemplateReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("GetIndexTemplate"))
                  .build();
          }
        }
     }
     return getGetIndexTemplateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateIndexTemplateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexTemplateRequest,
      com.rany.service.platform.meta.UpdateIndexTemplateReply> METHOD_UPDATE_INDEX_TEMPLATE = getUpdateIndexTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexTemplateRequest,
      com.rany.service.platform.meta.UpdateIndexTemplateReply> getUpdateIndexTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexTemplateRequest,
      com.rany.service.platform.meta.UpdateIndexTemplateReply> getUpdateIndexTemplateMethod() {
    return getUpdateIndexTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexTemplateRequest,
      com.rany.service.platform.meta.UpdateIndexTemplateReply> getUpdateIndexTemplateMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexTemplateRequest, com.rany.service.platform.meta.UpdateIndexTemplateReply> getUpdateIndexTemplateMethod;
    if ((getUpdateIndexTemplateMethod = MetaServiceGrpc.getUpdateIndexTemplateMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getUpdateIndexTemplateMethod = MetaServiceGrpc.getUpdateIndexTemplateMethod) == null) {
          MetaServiceGrpc.getUpdateIndexTemplateMethod = getUpdateIndexTemplateMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.UpdateIndexTemplateRequest, com.rany.service.platform.meta.UpdateIndexTemplateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "UpdateIndexTemplate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.UpdateIndexTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.UpdateIndexTemplateReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("UpdateIndexTemplate"))
                  .build();
          }
        }
     }
     return getUpdateIndexTemplateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteIndexTemplateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexTemplateRequest,
      com.rany.service.platform.meta.DeleteIndexTemplateReply> METHOD_DELETE_INDEX_TEMPLATE = getDeleteIndexTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexTemplateRequest,
      com.rany.service.platform.meta.DeleteIndexTemplateReply> getDeleteIndexTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexTemplateRequest,
      com.rany.service.platform.meta.DeleteIndexTemplateReply> getDeleteIndexTemplateMethod() {
    return getDeleteIndexTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexTemplateRequest,
      com.rany.service.platform.meta.DeleteIndexTemplateReply> getDeleteIndexTemplateMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexTemplateRequest, com.rany.service.platform.meta.DeleteIndexTemplateReply> getDeleteIndexTemplateMethod;
    if ((getDeleteIndexTemplateMethod = MetaServiceGrpc.getDeleteIndexTemplateMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getDeleteIndexTemplateMethod = MetaServiceGrpc.getDeleteIndexTemplateMethod) == null) {
          MetaServiceGrpc.getDeleteIndexTemplateMethod = getDeleteIndexTemplateMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.DeleteIndexTemplateRequest, com.rany.service.platform.meta.DeleteIndexTemplateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "DeleteIndexTemplate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.DeleteIndexTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.DeleteIndexTemplateReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("DeleteIndexTemplate"))
                  .build();
          }
        }
     }
     return getDeleteIndexTemplateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListIndexTemplateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateRequest,
      com.rany.service.platform.meta.ListIndexTemplateReply> METHOD_LIST_INDEX_TEMPLATE = getListIndexTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateRequest,
      com.rany.service.platform.meta.ListIndexTemplateReply> getListIndexTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateRequest,
      com.rany.service.platform.meta.ListIndexTemplateReply> getListIndexTemplateMethod() {
    return getListIndexTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateRequest,
      com.rany.service.platform.meta.ListIndexTemplateReply> getListIndexTemplateMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateRequest, com.rany.service.platform.meta.ListIndexTemplateReply> getListIndexTemplateMethod;
    if ((getListIndexTemplateMethod = MetaServiceGrpc.getListIndexTemplateMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getListIndexTemplateMethod = MetaServiceGrpc.getListIndexTemplateMethod) == null) {
          MetaServiceGrpc.getListIndexTemplateMethod = getListIndexTemplateMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexTemplateRequest, com.rany.service.platform.meta.ListIndexTemplateReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "ListIndexTemplate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexTemplateReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndexTemplate"))
                  .build();
          }
        }
     }
     return getListIndexTemplateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListIndexTemplateDetailsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateDetailsRequest,
      com.rany.service.platform.meta.ListIndexTemplateDetailsReply> METHOD_LIST_INDEX_TEMPLATE_DETAILS = getListIndexTemplateDetailsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateDetailsRequest,
      com.rany.service.platform.meta.ListIndexTemplateDetailsReply> getListIndexTemplateDetailsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateDetailsRequest,
      com.rany.service.platform.meta.ListIndexTemplateDetailsReply> getListIndexTemplateDetailsMethod() {
    return getListIndexTemplateDetailsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateDetailsRequest,
      com.rany.service.platform.meta.ListIndexTemplateDetailsReply> getListIndexTemplateDetailsMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexTemplateDetailsRequest, com.rany.service.platform.meta.ListIndexTemplateDetailsReply> getListIndexTemplateDetailsMethod;
    if ((getListIndexTemplateDetailsMethod = MetaServiceGrpc.getListIndexTemplateDetailsMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getListIndexTemplateDetailsMethod = MetaServiceGrpc.getListIndexTemplateDetailsMethod) == null) {
          MetaServiceGrpc.getListIndexTemplateDetailsMethod = getListIndexTemplateDetailsMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexTemplateDetailsRequest, com.rany.service.platform.meta.ListIndexTemplateDetailsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "ListIndexTemplateDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexTemplateDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexTemplateDetailsReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndexTemplateDetails"))
                  .build();
          }
        }
     }
     return getListIndexTemplateDetailsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateIndexMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexRequest,
      com.rany.service.platform.meta.CreateIndexReply> METHOD_CREATE_INDEX = getCreateIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexRequest,
      com.rany.service.platform.meta.CreateIndexReply> getCreateIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexRequest,
      com.rany.service.platform.meta.CreateIndexReply> getCreateIndexMethod() {
    return getCreateIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexRequest,
      com.rany.service.platform.meta.CreateIndexReply> getCreateIndexMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.CreateIndexRequest, com.rany.service.platform.meta.CreateIndexReply> getCreateIndexMethod;
    if ((getCreateIndexMethod = MetaServiceGrpc.getCreateIndexMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getCreateIndexMethod = MetaServiceGrpc.getCreateIndexMethod) == null) {
          MetaServiceGrpc.getCreateIndexMethod = getCreateIndexMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.CreateIndexRequest, com.rany.service.platform.meta.CreateIndexReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "CreateIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.CreateIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.CreateIndexReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("CreateIndex"))
                  .build();
          }
        }
     }
     return getCreateIndexMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIndexMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexRequest,
      com.rany.service.platform.meta.GetIndexReply> METHOD_GET_INDEX = getGetIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexRequest,
      com.rany.service.platform.meta.GetIndexReply> getGetIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexRequest,
      com.rany.service.platform.meta.GetIndexReply> getGetIndexMethod() {
    return getGetIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexRequest,
      com.rany.service.platform.meta.GetIndexReply> getGetIndexMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.GetIndexRequest, com.rany.service.platform.meta.GetIndexReply> getGetIndexMethod;
    if ((getGetIndexMethod = MetaServiceGrpc.getGetIndexMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getGetIndexMethod = MetaServiceGrpc.getGetIndexMethod) == null) {
          MetaServiceGrpc.getGetIndexMethod = getGetIndexMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.GetIndexRequest, com.rany.service.platform.meta.GetIndexReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "GetIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.GetIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.GetIndexReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("GetIndex"))
                  .build();
          }
        }
     }
     return getGetIndexMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateIndexMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexRequest,
      com.rany.service.platform.meta.UpdateIndexReply> METHOD_UPDATE_INDEX = getUpdateIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexRequest,
      com.rany.service.platform.meta.UpdateIndexReply> getUpdateIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexRequest,
      com.rany.service.platform.meta.UpdateIndexReply> getUpdateIndexMethod() {
    return getUpdateIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexRequest,
      com.rany.service.platform.meta.UpdateIndexReply> getUpdateIndexMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.UpdateIndexRequest, com.rany.service.platform.meta.UpdateIndexReply> getUpdateIndexMethod;
    if ((getUpdateIndexMethod = MetaServiceGrpc.getUpdateIndexMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getUpdateIndexMethod = MetaServiceGrpc.getUpdateIndexMethod) == null) {
          MetaServiceGrpc.getUpdateIndexMethod = getUpdateIndexMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.UpdateIndexRequest, com.rany.service.platform.meta.UpdateIndexReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "UpdateIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.UpdateIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.UpdateIndexReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("UpdateIndex"))
                  .build();
          }
        }
     }
     return getUpdateIndexMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteIndexMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexRequest,
      com.rany.service.platform.meta.DeleteIndexReply> METHOD_DELETE_INDEX = getDeleteIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexRequest,
      com.rany.service.platform.meta.DeleteIndexReply> getDeleteIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexRequest,
      com.rany.service.platform.meta.DeleteIndexReply> getDeleteIndexMethod() {
    return getDeleteIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexRequest,
      com.rany.service.platform.meta.DeleteIndexReply> getDeleteIndexMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.DeleteIndexRequest, com.rany.service.platform.meta.DeleteIndexReply> getDeleteIndexMethod;
    if ((getDeleteIndexMethod = MetaServiceGrpc.getDeleteIndexMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getDeleteIndexMethod = MetaServiceGrpc.getDeleteIndexMethod) == null) {
          MetaServiceGrpc.getDeleteIndexMethod = getDeleteIndexMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.DeleteIndexRequest, com.rany.service.platform.meta.DeleteIndexReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "DeleteIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.DeleteIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.DeleteIndexReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("DeleteIndex"))
                  .build();
          }
        }
     }
     return getDeleteIndexMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListIndexMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexRequest,
      com.rany.service.platform.meta.ListIndexReply> METHOD_LIST_INDEX = getListIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexRequest,
      com.rany.service.platform.meta.ListIndexReply> getListIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexRequest,
      com.rany.service.platform.meta.ListIndexReply> getListIndexMethod() {
    return getListIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexRequest,
      com.rany.service.platform.meta.ListIndexReply> getListIndexMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexRequest, com.rany.service.platform.meta.ListIndexReply> getListIndexMethod;
    if ((getListIndexMethod = MetaServiceGrpc.getListIndexMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getListIndexMethod = MetaServiceGrpc.getListIndexMethod) == null) {
          MetaServiceGrpc.getListIndexMethod = getListIndexMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexRequest, com.rany.service.platform.meta.ListIndexReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "ListIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndex"))
                  .build();
          }
        }
     }
     return getListIndexMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListIndexDetailsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexDetailsRequest,
      com.rany.service.platform.meta.ListIndexDetailsReply> METHOD_LIST_INDEX_DETAILS = getListIndexDetailsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexDetailsRequest,
      com.rany.service.platform.meta.ListIndexDetailsReply> getListIndexDetailsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexDetailsRequest,
      com.rany.service.platform.meta.ListIndexDetailsReply> getListIndexDetailsMethod() {
    return getListIndexDetailsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexDetailsRequest,
      com.rany.service.platform.meta.ListIndexDetailsReply> getListIndexDetailsMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexDetailsRequest, com.rany.service.platform.meta.ListIndexDetailsReply> getListIndexDetailsMethod;
    if ((getListIndexDetailsMethod = MetaServiceGrpc.getListIndexDetailsMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getListIndexDetailsMethod = MetaServiceGrpc.getListIndexDetailsMethod) == null) {
          MetaServiceGrpc.getListIndexDetailsMethod = getListIndexDetailsMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexDetailsRequest, com.rany.service.platform.meta.ListIndexDetailsReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "ListIndexDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexDetailsReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndexDetails"))
                  .build();
          }
        }
     }
     return getListIndexDetailsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListIndexNameMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexNameRequest,
      com.rany.service.platform.meta.ListIndexNameReply> METHOD_LIST_INDEX_NAME = getListIndexNameMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexNameRequest,
      com.rany.service.platform.meta.ListIndexNameReply> getListIndexNameMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexNameRequest,
      com.rany.service.platform.meta.ListIndexNameReply> getListIndexNameMethod() {
    return getListIndexNameMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexNameRequest,
      com.rany.service.platform.meta.ListIndexNameReply> getListIndexNameMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexNameRequest, com.rany.service.platform.meta.ListIndexNameReply> getListIndexNameMethod;
    if ((getListIndexNameMethod = MetaServiceGrpc.getListIndexNameMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getListIndexNameMethod = MetaServiceGrpc.getListIndexNameMethod) == null) {
          MetaServiceGrpc.getListIndexNameMethod = getListIndexNameMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexNameRequest, com.rany.service.platform.meta.ListIndexNameReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "ListIndexName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexNameReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndexName"))
                  .build();
          }
        }
     }
     return getListIndexNameMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListIndexAliasNameMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexAliasNameRequest,
      com.rany.service.platform.meta.ListIndexAliasNameReply> METHOD_LIST_INDEX_ALIAS_NAME = getListIndexAliasNameMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexAliasNameRequest,
      com.rany.service.platform.meta.ListIndexAliasNameReply> getListIndexAliasNameMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexAliasNameRequest,
      com.rany.service.platform.meta.ListIndexAliasNameReply> getListIndexAliasNameMethod() {
    return getListIndexAliasNameMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexAliasNameRequest,
      com.rany.service.platform.meta.ListIndexAliasNameReply> getListIndexAliasNameMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.ListIndexAliasNameRequest, com.rany.service.platform.meta.ListIndexAliasNameReply> getListIndexAliasNameMethod;
    if ((getListIndexAliasNameMethod = MetaServiceGrpc.getListIndexAliasNameMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getListIndexAliasNameMethod = MetaServiceGrpc.getListIndexAliasNameMethod) == null) {
          MetaServiceGrpc.getListIndexAliasNameMethod = getListIndexAliasNameMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.ListIndexAliasNameRequest, com.rany.service.platform.meta.ListIndexAliasNameReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "ListIndexAliasName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexAliasNameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.ListIndexAliasNameReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("ListIndexAliasName"))
                  .build();
          }
        }
     }
     return getListIndexAliasNameMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAttachIndexMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.AttachIndexRequest,
      com.rany.service.platform.meta.AttachIndexReply> METHOD_ATTACH_INDEX = getAttachIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.AttachIndexRequest,
      com.rany.service.platform.meta.AttachIndexReply> getAttachIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.AttachIndexRequest,
      com.rany.service.platform.meta.AttachIndexReply> getAttachIndexMethod() {
    return getAttachIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.AttachIndexRequest,
      com.rany.service.platform.meta.AttachIndexReply> getAttachIndexMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.AttachIndexRequest, com.rany.service.platform.meta.AttachIndexReply> getAttachIndexMethod;
    if ((getAttachIndexMethod = MetaServiceGrpc.getAttachIndexMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getAttachIndexMethod = MetaServiceGrpc.getAttachIndexMethod) == null) {
          MetaServiceGrpc.getAttachIndexMethod = getAttachIndexMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.AttachIndexRequest, com.rany.service.platform.meta.AttachIndexReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "AttachIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.AttachIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.AttachIndexReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("AttachIndex"))
                  .build();
          }
        }
     }
     return getAttachIndexMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDetachIndexMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.DetachIndexRequest,
      com.rany.service.platform.meta.DetachIndexReply> METHOD_DETACH_INDEX = getDetachIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.DetachIndexRequest,
      com.rany.service.platform.meta.DetachIndexReply> getDetachIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.DetachIndexRequest,
      com.rany.service.platform.meta.DetachIndexReply> getDetachIndexMethod() {
    return getDetachIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.DetachIndexRequest,
      com.rany.service.platform.meta.DetachIndexReply> getDetachIndexMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.DetachIndexRequest, com.rany.service.platform.meta.DetachIndexReply> getDetachIndexMethod;
    if ((getDetachIndexMethod = MetaServiceGrpc.getDetachIndexMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getDetachIndexMethod = MetaServiceGrpc.getDetachIndexMethod) == null) {
          MetaServiceGrpc.getDetachIndexMethod = getDetachIndexMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.DetachIndexRequest, com.rany.service.platform.meta.DetachIndexReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "DetachIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.DetachIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.DetachIndexReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("DetachIndex"))
                  .build();
          }
        }
     }
     return getDetachIndexMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRefreshIndexMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.meta.RefreshIndexRequest,
      com.rany.service.platform.meta.RefreshIndexReply> METHOD_REFRESH_INDEX = getRefreshIndexMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.rany.service.platform.meta.RefreshIndexRequest,
      com.rany.service.platform.meta.RefreshIndexReply> getRefreshIndexMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.rany.service.platform.meta.RefreshIndexRequest,
      com.rany.service.platform.meta.RefreshIndexReply> getRefreshIndexMethod() {
    return getRefreshIndexMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.rany.service.platform.meta.RefreshIndexRequest,
      com.rany.service.platform.meta.RefreshIndexReply> getRefreshIndexMethodHelper() {
    io.grpc.MethodDescriptor<com.rany.service.platform.meta.RefreshIndexRequest, com.rany.service.platform.meta.RefreshIndexReply> getRefreshIndexMethod;
    if ((getRefreshIndexMethod = MetaServiceGrpc.getRefreshIndexMethod) == null) {
      synchronized (MetaServiceGrpc.class) {
        if ((getRefreshIndexMethod = MetaServiceGrpc.getRefreshIndexMethod) == null) {
          MetaServiceGrpc.getRefreshIndexMethod = getRefreshIndexMethod = 
              io.grpc.MethodDescriptor.<com.rany.service.platform.meta.RefreshIndexRequest, com.rany.service.platform.meta.RefreshIndexReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MetaService", "RefreshIndex"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.RefreshIndexRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.rany.service.platform.meta.RefreshIndexReply.getDefaultInstance()))
                  .setSchemaDescriptor(new MetaServiceMethodDescriptorSupplier("RefreshIndex"))
                  .build();
          }
        }
     }
     return getRefreshIndexMethod;
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

  /**
   */
  public static abstract class MetaServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 集群相关
     * </pre>
     */
    public void createCluster(com.rany.service.platform.meta.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateClusterReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateClusterMethodHelper(), responseObserver);
    }

    /**
     */
    public void deleteCluster(com.rany.service.platform.meta.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteClusterReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteClusterMethodHelper(), responseObserver);
    }

    /**
     */
    public void updateCluster(com.rany.service.platform.meta.UpdateClusterInfoRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateClusterInfoReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateClusterMethodHelper(), responseObserver);
    }

    /**
     */
    public void getClusterInfo(com.rany.service.platform.meta.GetClusterInfoRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetClusterInfoReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetClusterInfoMethodHelper(), responseObserver);
    }

    /**
     */
    public void listCluster(com.rany.service.platform.meta.ListClusterRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListClusterReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListClusterMethodHelper(), responseObserver);
    }

    /**
     */
    public void listClusterDetails(com.rany.service.platform.meta.ListClusterDetailsRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListClusterDetailsReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListClusterDetailsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * 项目相关
     * </pre>
     */
    public void createProject(com.rany.service.platform.meta.CreateProjectRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateProjectReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateProjectMethodHelper(), responseObserver);
    }

    /**
     */
    public void deleteProject(com.rany.service.platform.meta.DeleteProjectRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteProjectReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteProjectMethodHelper(), responseObserver);
    }

    /**
     */
    public void updateProject(com.rany.service.platform.meta.UpdateProjectRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateProjectReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateProjectMethodHelper(), responseObserver);
    }

    /**
     */
    public void getProject(com.rany.service.platform.meta.GetProjectRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetProjectReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProjectMethodHelper(), responseObserver);
    }

    /**
     */
    public void listProject(com.rany.service.platform.meta.ListProjectRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListProjectReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListProjectMethodHelper(), responseObserver);
    }

    /**
     */
    public void listProjectDetails(com.rany.service.platform.meta.ListProjectDetailsRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListProjectDetailsReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListProjectDetailsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * 模版
     * </pre>
     */
    public void createIndexTemplate(com.rany.service.platform.meta.CreateIndexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateIndexTemplateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateIndexTemplateMethodHelper(), responseObserver);
    }

    /**
     */
    public void getIndexTemplate(com.rany.service.platform.meta.GetIndexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetIndexTemplateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIndexTemplateMethodHelper(), responseObserver);
    }

    /**
     */
    public void updateIndexTemplate(com.rany.service.platform.meta.UpdateIndexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateIndexTemplateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateIndexTemplateMethodHelper(), responseObserver);
    }

    /**
     */
    public void deleteIndexTemplate(com.rany.service.platform.meta.DeleteIndexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteIndexTemplateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteIndexTemplateMethodHelper(), responseObserver);
    }

    /**
     */
    public void listIndexTemplate(com.rany.service.platform.meta.ListIndexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexTemplateReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListIndexTemplateMethodHelper(), responseObserver);
    }

    /**
     */
    public void listIndexTemplateDetails(com.rany.service.platform.meta.ListIndexTemplateDetailsRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexTemplateDetailsReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListIndexTemplateDetailsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * 索引相关
     * </pre>
     */
    public void createIndex(com.rany.service.platform.meta.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateIndexReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateIndexMethodHelper(), responseObserver);
    }

    /**
     */
    public void getIndex(com.rany.service.platform.meta.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetIndexReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIndexMethodHelper(), responseObserver);
    }

    /**
     */
    public void updateIndex(com.rany.service.platform.meta.UpdateIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateIndexReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateIndexMethodHelper(), responseObserver);
    }

    /**
     */
    public void deleteIndex(com.rany.service.platform.meta.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteIndexReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteIndexMethodHelper(), responseObserver);
    }

    /**
     */
    public void listIndex(com.rany.service.platform.meta.ListIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListIndexMethodHelper(), responseObserver);
    }

    /**
     */
    public void listIndexDetails(com.rany.service.platform.meta.ListIndexDetailsRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexDetailsReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListIndexDetailsMethodHelper(), responseObserver);
    }

    /**
     */
    public void listIndexName(com.rany.service.platform.meta.ListIndexNameRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexNameReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListIndexNameMethodHelper(), responseObserver);
    }

    /**
     */
    public void listIndexAliasName(com.rany.service.platform.meta.ListIndexAliasNameRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexAliasNameReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListIndexAliasNameMethodHelper(), responseObserver);
    }

    /**
     */
    public void attachIndex(com.rany.service.platform.meta.AttachIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.AttachIndexReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAttachIndexMethodHelper(), responseObserver);
    }

    /**
     */
    public void detachIndex(com.rany.service.platform.meta.DetachIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DetachIndexReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDetachIndexMethodHelper(), responseObserver);
    }

    /**
     */
    public void refreshIndex(com.rany.service.platform.meta.RefreshIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.RefreshIndexReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRefreshIndexMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.CreateClusterRequest,
                com.rany.service.platform.meta.CreateClusterReply>(
                  this, METHODID_CREATE_CLUSTER)))
          .addMethod(
            getDeleteClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.DeleteClusterRequest,
                com.rany.service.platform.meta.DeleteClusterReply>(
                  this, METHODID_DELETE_CLUSTER)))
          .addMethod(
            getUpdateClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.UpdateClusterInfoRequest,
                com.rany.service.platform.meta.UpdateClusterInfoReply>(
                  this, METHODID_UPDATE_CLUSTER)))
          .addMethod(
            getGetClusterInfoMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.GetClusterInfoRequest,
                com.rany.service.platform.meta.GetClusterInfoReply>(
                  this, METHODID_GET_CLUSTER_INFO)))
          .addMethod(
            getListClusterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.ListClusterRequest,
                com.rany.service.platform.meta.ListClusterReply>(
                  this, METHODID_LIST_CLUSTER)))
          .addMethod(
            getListClusterDetailsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.ListClusterDetailsRequest,
                com.rany.service.platform.meta.ListClusterDetailsReply>(
                  this, METHODID_LIST_CLUSTER_DETAILS)))
          .addMethod(
            getCreateProjectMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.CreateProjectRequest,
                com.rany.service.platform.meta.CreateProjectReply>(
                  this, METHODID_CREATE_PROJECT)))
          .addMethod(
            getDeleteProjectMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.DeleteProjectRequest,
                com.rany.service.platform.meta.DeleteProjectReply>(
                  this, METHODID_DELETE_PROJECT)))
          .addMethod(
            getUpdateProjectMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.UpdateProjectRequest,
                com.rany.service.platform.meta.UpdateProjectReply>(
                  this, METHODID_UPDATE_PROJECT)))
          .addMethod(
            getGetProjectMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.GetProjectRequest,
                com.rany.service.platform.meta.GetProjectReply>(
                  this, METHODID_GET_PROJECT)))
          .addMethod(
            getListProjectMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.ListProjectRequest,
                com.rany.service.platform.meta.ListProjectReply>(
                  this, METHODID_LIST_PROJECT)))
          .addMethod(
            getListProjectDetailsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.ListProjectDetailsRequest,
                com.rany.service.platform.meta.ListProjectDetailsReply>(
                  this, METHODID_LIST_PROJECT_DETAILS)))
          .addMethod(
            getCreateIndexTemplateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.CreateIndexTemplateRequest,
                com.rany.service.platform.meta.CreateIndexTemplateReply>(
                  this, METHODID_CREATE_INDEX_TEMPLATE)))
          .addMethod(
            getGetIndexTemplateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.GetIndexTemplateRequest,
                com.rany.service.platform.meta.GetIndexTemplateReply>(
                  this, METHODID_GET_INDEX_TEMPLATE)))
          .addMethod(
            getUpdateIndexTemplateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.UpdateIndexTemplateRequest,
                com.rany.service.platform.meta.UpdateIndexTemplateReply>(
                  this, METHODID_UPDATE_INDEX_TEMPLATE)))
          .addMethod(
            getDeleteIndexTemplateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.DeleteIndexTemplateRequest,
                com.rany.service.platform.meta.DeleteIndexTemplateReply>(
                  this, METHODID_DELETE_INDEX_TEMPLATE)))
          .addMethod(
            getListIndexTemplateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.ListIndexTemplateRequest,
                com.rany.service.platform.meta.ListIndexTemplateReply>(
                  this, METHODID_LIST_INDEX_TEMPLATE)))
          .addMethod(
            getListIndexTemplateDetailsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.ListIndexTemplateDetailsRequest,
                com.rany.service.platform.meta.ListIndexTemplateDetailsReply>(
                  this, METHODID_LIST_INDEX_TEMPLATE_DETAILS)))
          .addMethod(
            getCreateIndexMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.CreateIndexRequest,
                com.rany.service.platform.meta.CreateIndexReply>(
                  this, METHODID_CREATE_INDEX)))
          .addMethod(
            getGetIndexMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.GetIndexRequest,
                com.rany.service.platform.meta.GetIndexReply>(
                  this, METHODID_GET_INDEX)))
          .addMethod(
            getUpdateIndexMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.UpdateIndexRequest,
                com.rany.service.platform.meta.UpdateIndexReply>(
                  this, METHODID_UPDATE_INDEX)))
          .addMethod(
            getDeleteIndexMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.DeleteIndexRequest,
                com.rany.service.platform.meta.DeleteIndexReply>(
                  this, METHODID_DELETE_INDEX)))
          .addMethod(
            getListIndexMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.ListIndexRequest,
                com.rany.service.platform.meta.ListIndexReply>(
                  this, METHODID_LIST_INDEX)))
          .addMethod(
            getListIndexDetailsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.ListIndexDetailsRequest,
                com.rany.service.platform.meta.ListIndexDetailsReply>(
                  this, METHODID_LIST_INDEX_DETAILS)))
          .addMethod(
            getListIndexNameMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.ListIndexNameRequest,
                com.rany.service.platform.meta.ListIndexNameReply>(
                  this, METHODID_LIST_INDEX_NAME)))
          .addMethod(
            getListIndexAliasNameMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.ListIndexAliasNameRequest,
                com.rany.service.platform.meta.ListIndexAliasNameReply>(
                  this, METHODID_LIST_INDEX_ALIAS_NAME)))
          .addMethod(
            getAttachIndexMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.AttachIndexRequest,
                com.rany.service.platform.meta.AttachIndexReply>(
                  this, METHODID_ATTACH_INDEX)))
          .addMethod(
            getDetachIndexMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.DetachIndexRequest,
                com.rany.service.platform.meta.DetachIndexReply>(
                  this, METHODID_DETACH_INDEX)))
          .addMethod(
            getRefreshIndexMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.meta.RefreshIndexRequest,
                com.rany.service.platform.meta.RefreshIndexReply>(
                  this, METHODID_REFRESH_INDEX)))
          .build();
    }
  }

  /**
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
          getChannel().newCall(getCreateClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCluster(com.rany.service.platform.meta.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteClusterReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateCluster(com.rany.service.platform.meta.UpdateClusterInfoRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateClusterInfoReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getClusterInfo(com.rany.service.platform.meta.GetClusterInfoRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetClusterInfoReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetClusterInfoMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listCluster(com.rany.service.platform.meta.ListClusterRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListClusterReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListClusterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listClusterDetails(com.rany.service.platform.meta.ListClusterDetailsRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListClusterDetailsReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListClusterDetailsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 项目相关
     * </pre>
     */
    public void createProject(com.rany.service.platform.meta.CreateProjectRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateProjectReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateProjectMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteProject(com.rany.service.platform.meta.DeleteProjectRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteProjectReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteProjectMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateProject(com.rany.service.platform.meta.UpdateProjectRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateProjectReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateProjectMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProject(com.rany.service.platform.meta.GetProjectRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetProjectReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProjectMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listProject(com.rany.service.platform.meta.ListProjectRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListProjectReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListProjectMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listProjectDetails(com.rany.service.platform.meta.ListProjectDetailsRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListProjectDetailsReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListProjectDetailsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 模版
     * </pre>
     */
    public void createIndexTemplate(com.rany.service.platform.meta.CreateIndexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateIndexTemplateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateIndexTemplateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getIndexTemplate(com.rany.service.platform.meta.GetIndexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetIndexTemplateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIndexTemplateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateIndexTemplate(com.rany.service.platform.meta.UpdateIndexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateIndexTemplateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateIndexTemplateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteIndexTemplate(com.rany.service.platform.meta.DeleteIndexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteIndexTemplateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteIndexTemplateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listIndexTemplate(com.rany.service.platform.meta.ListIndexTemplateRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexTemplateReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListIndexTemplateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listIndexTemplateDetails(com.rany.service.platform.meta.ListIndexTemplateDetailsRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexTemplateDetailsReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListIndexTemplateDetailsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 索引相关
     * </pre>
     */
    public void createIndex(com.rany.service.platform.meta.CreateIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.CreateIndexReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateIndexMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getIndex(com.rany.service.platform.meta.GetIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.GetIndexReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIndexMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateIndex(com.rany.service.platform.meta.UpdateIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.UpdateIndexReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateIndexMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteIndex(com.rany.service.platform.meta.DeleteIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DeleteIndexReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteIndexMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listIndex(com.rany.service.platform.meta.ListIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListIndexMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listIndexDetails(com.rany.service.platform.meta.ListIndexDetailsRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexDetailsReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListIndexDetailsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listIndexName(com.rany.service.platform.meta.ListIndexNameRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexNameReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListIndexNameMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listIndexAliasName(com.rany.service.platform.meta.ListIndexAliasNameRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.ListIndexAliasNameReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListIndexAliasNameMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void attachIndex(com.rany.service.platform.meta.AttachIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.AttachIndexReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAttachIndexMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void detachIndex(com.rany.service.platform.meta.DetachIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.DetachIndexReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDetachIndexMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void refreshIndex(com.rany.service.platform.meta.RefreshIndexRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.meta.RefreshIndexReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRefreshIndexMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
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
          getChannel(), getCreateClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.DeleteClusterReply deleteCluster(com.rany.service.platform.meta.DeleteClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.UpdateClusterInfoReply updateCluster(com.rany.service.platform.meta.UpdateClusterInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.GetClusterInfoReply getClusterInfo(com.rany.service.platform.meta.GetClusterInfoRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetClusterInfoMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.ListClusterReply listCluster(com.rany.service.platform.meta.ListClusterRequest request) {
      return blockingUnaryCall(
          getChannel(), getListClusterMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.ListClusterDetailsReply listClusterDetails(com.rany.service.platform.meta.ListClusterDetailsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListClusterDetailsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 项目相关
     * </pre>
     */
    public com.rany.service.platform.meta.CreateProjectReply createProject(com.rany.service.platform.meta.CreateProjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateProjectMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.DeleteProjectReply deleteProject(com.rany.service.platform.meta.DeleteProjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteProjectMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.UpdateProjectReply updateProject(com.rany.service.platform.meta.UpdateProjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateProjectMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.GetProjectReply getProject(com.rany.service.platform.meta.GetProjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetProjectMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.ListProjectReply listProject(com.rany.service.platform.meta.ListProjectRequest request) {
      return blockingUnaryCall(
          getChannel(), getListProjectMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.ListProjectDetailsReply listProjectDetails(com.rany.service.platform.meta.ListProjectDetailsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListProjectDetailsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 模版
     * </pre>
     */
    public com.rany.service.platform.meta.CreateIndexTemplateReply createIndexTemplate(com.rany.service.platform.meta.CreateIndexTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateIndexTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.GetIndexTemplateReply getIndexTemplate(com.rany.service.platform.meta.GetIndexTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIndexTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.UpdateIndexTemplateReply updateIndexTemplate(com.rany.service.platform.meta.UpdateIndexTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateIndexTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.DeleteIndexTemplateReply deleteIndexTemplate(com.rany.service.platform.meta.DeleteIndexTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteIndexTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.ListIndexTemplateReply listIndexTemplate(com.rany.service.platform.meta.ListIndexTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getListIndexTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.ListIndexTemplateDetailsReply listIndexTemplateDetails(com.rany.service.platform.meta.ListIndexTemplateDetailsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListIndexTemplateDetailsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 索引相关
     * </pre>
     */
    public com.rany.service.platform.meta.CreateIndexReply createIndex(com.rany.service.platform.meta.CreateIndexRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateIndexMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.GetIndexReply getIndex(com.rany.service.platform.meta.GetIndexRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIndexMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.UpdateIndexReply updateIndex(com.rany.service.platform.meta.UpdateIndexRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateIndexMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.DeleteIndexReply deleteIndex(com.rany.service.platform.meta.DeleteIndexRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteIndexMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.ListIndexReply listIndex(com.rany.service.platform.meta.ListIndexRequest request) {
      return blockingUnaryCall(
          getChannel(), getListIndexMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.ListIndexDetailsReply listIndexDetails(com.rany.service.platform.meta.ListIndexDetailsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListIndexDetailsMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.ListIndexNameReply listIndexName(com.rany.service.platform.meta.ListIndexNameRequest request) {
      return blockingUnaryCall(
          getChannel(), getListIndexNameMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.ListIndexAliasNameReply listIndexAliasName(com.rany.service.platform.meta.ListIndexAliasNameRequest request) {
      return blockingUnaryCall(
          getChannel(), getListIndexAliasNameMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.AttachIndexReply attachIndex(com.rany.service.platform.meta.AttachIndexRequest request) {
      return blockingUnaryCall(
          getChannel(), getAttachIndexMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.DetachIndexReply detachIndex(com.rany.service.platform.meta.DetachIndexRequest request) {
      return blockingUnaryCall(
          getChannel(), getDetachIndexMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.meta.RefreshIndexReply refreshIndex(com.rany.service.platform.meta.RefreshIndexRequest request) {
      return blockingUnaryCall(
          getChannel(), getRefreshIndexMethodHelper(), getCallOptions(), request);
    }
  }

  /**
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
          getChannel().newCall(getCreateClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.DeleteClusterReply> deleteCluster(
        com.rany.service.platform.meta.DeleteClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.UpdateClusterInfoReply> updateCluster(
        com.rany.service.platform.meta.UpdateClusterInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.GetClusterInfoReply> getClusterInfo(
        com.rany.service.platform.meta.GetClusterInfoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetClusterInfoMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListClusterReply> listCluster(
        com.rany.service.platform.meta.ListClusterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListClusterMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListClusterDetailsReply> listClusterDetails(
        com.rany.service.platform.meta.ListClusterDetailsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListClusterDetailsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 项目相关
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.CreateProjectReply> createProject(
        com.rany.service.platform.meta.CreateProjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateProjectMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.DeleteProjectReply> deleteProject(
        com.rany.service.platform.meta.DeleteProjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteProjectMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.UpdateProjectReply> updateProject(
        com.rany.service.platform.meta.UpdateProjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateProjectMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.GetProjectReply> getProject(
        com.rany.service.platform.meta.GetProjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProjectMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListProjectReply> listProject(
        com.rany.service.platform.meta.ListProjectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListProjectMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListProjectDetailsReply> listProjectDetails(
        com.rany.service.platform.meta.ListProjectDetailsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListProjectDetailsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 模版
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.CreateIndexTemplateReply> createIndexTemplate(
        com.rany.service.platform.meta.CreateIndexTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateIndexTemplateMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.GetIndexTemplateReply> getIndexTemplate(
        com.rany.service.platform.meta.GetIndexTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIndexTemplateMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.UpdateIndexTemplateReply> updateIndexTemplate(
        com.rany.service.platform.meta.UpdateIndexTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateIndexTemplateMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.DeleteIndexTemplateReply> deleteIndexTemplate(
        com.rany.service.platform.meta.DeleteIndexTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteIndexTemplateMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexTemplateReply> listIndexTemplate(
        com.rany.service.platform.meta.ListIndexTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListIndexTemplateMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexTemplateDetailsReply> listIndexTemplateDetails(
        com.rany.service.platform.meta.ListIndexTemplateDetailsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListIndexTemplateDetailsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 索引相关
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.CreateIndexReply> createIndex(
        com.rany.service.platform.meta.CreateIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateIndexMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.GetIndexReply> getIndex(
        com.rany.service.platform.meta.GetIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIndexMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.UpdateIndexReply> updateIndex(
        com.rany.service.platform.meta.UpdateIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateIndexMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.DeleteIndexReply> deleteIndex(
        com.rany.service.platform.meta.DeleteIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteIndexMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexReply> listIndex(
        com.rany.service.platform.meta.ListIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListIndexMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexDetailsReply> listIndexDetails(
        com.rany.service.platform.meta.ListIndexDetailsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListIndexDetailsMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexNameReply> listIndexName(
        com.rany.service.platform.meta.ListIndexNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListIndexNameMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.ListIndexAliasNameReply> listIndexAliasName(
        com.rany.service.platform.meta.ListIndexAliasNameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListIndexAliasNameMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.AttachIndexReply> attachIndex(
        com.rany.service.platform.meta.AttachIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAttachIndexMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.DetachIndexReply> detachIndex(
        com.rany.service.platform.meta.DetachIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDetachIndexMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.meta.RefreshIndexReply> refreshIndex(
        com.rany.service.platform.meta.RefreshIndexRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRefreshIndexMethodHelper(), getCallOptions()), request);
    }
  }

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
    MetaServiceBaseDescriptorSupplier() {}

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
    MetaServiceFileDescriptorSupplier() {}
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

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MetaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MetaServiceFileDescriptorSupplier())
              .addMethod(getCreateClusterMethodHelper())
              .addMethod(getDeleteClusterMethodHelper())
              .addMethod(getUpdateClusterMethodHelper())
              .addMethod(getGetClusterInfoMethodHelper())
              .addMethod(getListClusterMethodHelper())
              .addMethod(getListClusterDetailsMethodHelper())
              .addMethod(getCreateProjectMethodHelper())
              .addMethod(getDeleteProjectMethodHelper())
              .addMethod(getUpdateProjectMethodHelper())
              .addMethod(getGetProjectMethodHelper())
              .addMethod(getListProjectMethodHelper())
              .addMethod(getListProjectDetailsMethodHelper())
              .addMethod(getCreateIndexTemplateMethodHelper())
              .addMethod(getGetIndexTemplateMethodHelper())
              .addMethod(getUpdateIndexTemplateMethodHelper())
              .addMethod(getDeleteIndexTemplateMethodHelper())
              .addMethod(getListIndexTemplateMethodHelper())
              .addMethod(getListIndexTemplateDetailsMethodHelper())
              .addMethod(getCreateIndexMethodHelper())
              .addMethod(getGetIndexMethodHelper())
              .addMethod(getUpdateIndexMethodHelper())
              .addMethod(getDeleteIndexMethodHelper())
              .addMethod(getListIndexMethodHelper())
              .addMethod(getListIndexDetailsMethodHelper())
              .addMethod(getListIndexNameMethodHelper())
              .addMethod(getListIndexAliasNameMethodHelper())
              .addMethod(getAttachIndexMethodHelper())
              .addMethod(getDetachIndexMethodHelper())
              .addMethod(getRefreshIndexMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
