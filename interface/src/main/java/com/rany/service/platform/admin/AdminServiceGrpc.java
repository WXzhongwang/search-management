package com.rany.service.platform.admin;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: admin/admin.proto")
public final class AdminServiceGrpc {

  private AdminServiceGrpc() {}

  public static final String SERVICE_NAME = "AdminService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.admin.PingRequest,
      com.rany.service.platform.admin.PingReply> METHOD_PING =
      io.grpc.MethodDescriptor.<com.rany.service.platform.admin.PingRequest, com.rany.service.platform.admin.PingReply>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AdminService", "Ping"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.PingRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.PingReply.getDefaultInstance()))
          .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("Ping"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.admin.SetReadOnlyRequest,
      com.rany.service.platform.admin.ReadOnlyResponse> METHOD_SET_SERVICE_READ_ONLY =
      io.grpc.MethodDescriptor.<com.rany.service.platform.admin.SetReadOnlyRequest, com.rany.service.platform.admin.ReadOnlyResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AdminService", "SetServiceReadOnly"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.SetReadOnlyRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.ReadOnlyResponse.getDefaultInstance()))
          .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("SetServiceReadOnly"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.admin.SetInServiceRequest,
      com.rany.service.platform.admin.InServiceResponse> METHOD_SET_SERVICE_IN_SERVICE =
      io.grpc.MethodDescriptor.<com.rany.service.platform.admin.SetInServiceRequest, com.rany.service.platform.admin.InServiceResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AdminService", "SetServiceInService"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.SetInServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.InServiceResponse.getDefaultInstance()))
          .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("SetServiceInService"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.admin.SetSuspendRequest,
      com.rany.service.platform.admin.SuspendResponse> METHOD_SET_SERVICE_SUSPEND =
      io.grpc.MethodDescriptor.<com.rany.service.platform.admin.SetSuspendRequest, com.rany.service.platform.admin.SuspendResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AdminService", "SetServiceSuspend"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.SetSuspendRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.SuspendResponse.getDefaultInstance()))
          .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("SetServiceSuspend"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.admin.GetServiceModeRequest,
      com.rany.service.platform.admin.ServiceModeResponse> METHOD_GET_SERVICE_MODE =
      io.grpc.MethodDescriptor.<com.rany.service.platform.admin.GetServiceModeRequest, com.rany.service.platform.admin.ServiceModeResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AdminService", "GetServiceMode"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.GetServiceModeRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.ServiceModeResponse.getDefaultInstance()))
          .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("GetServiceMode"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.admin.SuspendWorkThreadRequest,
      com.rany.service.platform.admin.SuspendWorkThreadResponse> METHOD_SUSPEND_BACKEND_THREADS =
      io.grpc.MethodDescriptor.<com.rany.service.platform.admin.SuspendWorkThreadRequest, com.rany.service.platform.admin.SuspendWorkThreadResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AdminService", "SuspendBackendThreads"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.SuspendWorkThreadRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.SuspendWorkThreadResponse.getDefaultInstance()))
          .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("SuspendBackendThreads"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.admin.ResumeWorkThreadRequest,
      com.rany.service.platform.admin.ResumeWorkThreadResponse> METHOD_RESUME_BACKEND_THREADS =
      io.grpc.MethodDescriptor.<com.rany.service.platform.admin.ResumeWorkThreadRequest, com.rany.service.platform.admin.ResumeWorkThreadResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AdminService", "ResumeBackendThreads"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.ResumeWorkThreadRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.ResumeWorkThreadResponse.getDefaultInstance()))
          .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("ResumeBackendThreads"))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.rany.service.platform.admin.GetWorkThreadStatusRequest,
      com.rany.service.platform.admin.GetWorkThreadStatusResponse> METHOD_GET_BACKEND_THREADS_STATUS =
      io.grpc.MethodDescriptor.<com.rany.service.platform.admin.GetWorkThreadStatusRequest, com.rany.service.platform.admin.GetWorkThreadStatusResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "AdminService", "GetBackendThreadsStatus"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.GetWorkThreadStatusRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.rany.service.platform.admin.GetWorkThreadStatusResponse.getDefaultInstance()))
          .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("GetBackendThreadsStatus"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdminServiceStub newStub(io.grpc.Channel channel) {
    return new AdminServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdminServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AdminServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdminServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AdminServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AdminServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void ping(com.rany.service.platform.admin.PingRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.PingReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PING, responseObserver);
    }

    /**
     */
    public void setServiceReadOnly(com.rany.service.platform.admin.SetReadOnlyRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.ReadOnlyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_SERVICE_READ_ONLY, responseObserver);
    }

    /**
     */
    public void setServiceInService(com.rany.service.platform.admin.SetInServiceRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.InServiceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_SERVICE_IN_SERVICE, responseObserver);
    }

    /**
     */
    public void setServiceSuspend(com.rany.service.platform.admin.SetSuspendRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.SuspendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SET_SERVICE_SUSPEND, responseObserver);
    }

    /**
     */
    public void getServiceMode(com.rany.service.platform.admin.GetServiceModeRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.ServiceModeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_SERVICE_MODE, responseObserver);
    }

    /**
     */
    public void suspendBackendThreads(com.rany.service.platform.admin.SuspendWorkThreadRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.SuspendWorkThreadResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SUSPEND_BACKEND_THREADS, responseObserver);
    }

    /**
     */
    public void resumeBackendThreads(com.rany.service.platform.admin.ResumeWorkThreadRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.ResumeWorkThreadResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_RESUME_BACKEND_THREADS, responseObserver);
    }

    /**
     */
    public void getBackendThreadsStatus(com.rany.service.platform.admin.GetWorkThreadStatusRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.GetWorkThreadStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_BACKEND_THREADS_STATUS, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_PING,
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.admin.PingRequest,
                com.rany.service.platform.admin.PingReply>(
                  this, METHODID_PING)))
          .addMethod(
            METHOD_SET_SERVICE_READ_ONLY,
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.admin.SetReadOnlyRequest,
                com.rany.service.platform.admin.ReadOnlyResponse>(
                  this, METHODID_SET_SERVICE_READ_ONLY)))
          .addMethod(
            METHOD_SET_SERVICE_IN_SERVICE,
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.admin.SetInServiceRequest,
                com.rany.service.platform.admin.InServiceResponse>(
                  this, METHODID_SET_SERVICE_IN_SERVICE)))
          .addMethod(
            METHOD_SET_SERVICE_SUSPEND,
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.admin.SetSuspendRequest,
                com.rany.service.platform.admin.SuspendResponse>(
                  this, METHODID_SET_SERVICE_SUSPEND)))
          .addMethod(
            METHOD_GET_SERVICE_MODE,
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.admin.GetServiceModeRequest,
                com.rany.service.platform.admin.ServiceModeResponse>(
                  this, METHODID_GET_SERVICE_MODE)))
          .addMethod(
            METHOD_SUSPEND_BACKEND_THREADS,
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.admin.SuspendWorkThreadRequest,
                com.rany.service.platform.admin.SuspendWorkThreadResponse>(
                  this, METHODID_SUSPEND_BACKEND_THREADS)))
          .addMethod(
            METHOD_RESUME_BACKEND_THREADS,
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.admin.ResumeWorkThreadRequest,
                com.rany.service.platform.admin.ResumeWorkThreadResponse>(
                  this, METHODID_RESUME_BACKEND_THREADS)))
          .addMethod(
            METHOD_GET_BACKEND_THREADS_STATUS,
            asyncUnaryCall(
              new MethodHandlers<
                com.rany.service.platform.admin.GetWorkThreadStatusRequest,
                com.rany.service.platform.admin.GetWorkThreadStatusResponse>(
                  this, METHODID_GET_BACKEND_THREADS_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class AdminServiceStub extends io.grpc.stub.AbstractStub<AdminServiceStub> {
    private AdminServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdminServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdminServiceStub(channel, callOptions);
    }

    /**
     */
    public void ping(com.rany.service.platform.admin.PingRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.PingReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PING, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setServiceReadOnly(com.rany.service.platform.admin.SetReadOnlyRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.ReadOnlyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_SERVICE_READ_ONLY, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setServiceInService(com.rany.service.platform.admin.SetInServiceRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.InServiceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_SERVICE_IN_SERVICE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setServiceSuspend(com.rany.service.platform.admin.SetSuspendRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.SuspendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SET_SERVICE_SUSPEND, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getServiceMode(com.rany.service.platform.admin.GetServiceModeRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.ServiceModeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_SERVICE_MODE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void suspendBackendThreads(com.rany.service.platform.admin.SuspendWorkThreadRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.SuspendWorkThreadResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SUSPEND_BACKEND_THREADS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void resumeBackendThreads(com.rany.service.platform.admin.ResumeWorkThreadRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.ResumeWorkThreadResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_RESUME_BACKEND_THREADS, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBackendThreadsStatus(com.rany.service.platform.admin.GetWorkThreadStatusRequest request,
        io.grpc.stub.StreamObserver<com.rany.service.platform.admin.GetWorkThreadStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_BACKEND_THREADS_STATUS, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AdminServiceBlockingStub extends io.grpc.stub.AbstractStub<AdminServiceBlockingStub> {
    private AdminServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdminServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdminServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.rany.service.platform.admin.PingReply ping(com.rany.service.platform.admin.PingRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PING, getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.admin.ReadOnlyResponse setServiceReadOnly(com.rany.service.platform.admin.SetReadOnlyRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_SERVICE_READ_ONLY, getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.admin.InServiceResponse setServiceInService(com.rany.service.platform.admin.SetInServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_SERVICE_IN_SERVICE, getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.admin.SuspendResponse setServiceSuspend(com.rany.service.platform.admin.SetSuspendRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SET_SERVICE_SUSPEND, getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.admin.ServiceModeResponse getServiceMode(com.rany.service.platform.admin.GetServiceModeRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_SERVICE_MODE, getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.admin.SuspendWorkThreadResponse suspendBackendThreads(com.rany.service.platform.admin.SuspendWorkThreadRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SUSPEND_BACKEND_THREADS, getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.admin.ResumeWorkThreadResponse resumeBackendThreads(com.rany.service.platform.admin.ResumeWorkThreadRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_RESUME_BACKEND_THREADS, getCallOptions(), request);
    }

    /**
     */
    public com.rany.service.platform.admin.GetWorkThreadStatusResponse getBackendThreadsStatus(com.rany.service.platform.admin.GetWorkThreadStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_BACKEND_THREADS_STATUS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AdminServiceFutureStub extends io.grpc.stub.AbstractStub<AdminServiceFutureStub> {
    private AdminServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AdminServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AdminServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.admin.PingReply> ping(
        com.rany.service.platform.admin.PingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PING, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.admin.ReadOnlyResponse> setServiceReadOnly(
        com.rany.service.platform.admin.SetReadOnlyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_SERVICE_READ_ONLY, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.admin.InServiceResponse> setServiceInService(
        com.rany.service.platform.admin.SetInServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_SERVICE_IN_SERVICE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.admin.SuspendResponse> setServiceSuspend(
        com.rany.service.platform.admin.SetSuspendRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SET_SERVICE_SUSPEND, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.admin.ServiceModeResponse> getServiceMode(
        com.rany.service.platform.admin.GetServiceModeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_SERVICE_MODE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.admin.SuspendWorkThreadResponse> suspendBackendThreads(
        com.rany.service.platform.admin.SuspendWorkThreadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SUSPEND_BACKEND_THREADS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.admin.ResumeWorkThreadResponse> resumeBackendThreads(
        com.rany.service.platform.admin.ResumeWorkThreadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_RESUME_BACKEND_THREADS, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.rany.service.platform.admin.GetWorkThreadStatusResponse> getBackendThreadsStatus(
        com.rany.service.platform.admin.GetWorkThreadStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_BACKEND_THREADS_STATUS, getCallOptions()), request);
    }
  }

  private static final int METHODID_PING = 0;
  private static final int METHODID_SET_SERVICE_READ_ONLY = 1;
  private static final int METHODID_SET_SERVICE_IN_SERVICE = 2;
  private static final int METHODID_SET_SERVICE_SUSPEND = 3;
  private static final int METHODID_GET_SERVICE_MODE = 4;
  private static final int METHODID_SUSPEND_BACKEND_THREADS = 5;
  private static final int METHODID_RESUME_BACKEND_THREADS = 6;
  private static final int METHODID_GET_BACKEND_THREADS_STATUS = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AdminServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AdminServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PING:
          serviceImpl.ping((com.rany.service.platform.admin.PingRequest) request,
              (io.grpc.stub.StreamObserver<com.rany.service.platform.admin.PingReply>) responseObserver);
          break;
        case METHODID_SET_SERVICE_READ_ONLY:
          serviceImpl.setServiceReadOnly((com.rany.service.platform.admin.SetReadOnlyRequest) request,
              (io.grpc.stub.StreamObserver<com.rany.service.platform.admin.ReadOnlyResponse>) responseObserver);
          break;
        case METHODID_SET_SERVICE_IN_SERVICE:
          serviceImpl.setServiceInService((com.rany.service.platform.admin.SetInServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.rany.service.platform.admin.InServiceResponse>) responseObserver);
          break;
        case METHODID_SET_SERVICE_SUSPEND:
          serviceImpl.setServiceSuspend((com.rany.service.platform.admin.SetSuspendRequest) request,
              (io.grpc.stub.StreamObserver<com.rany.service.platform.admin.SuspendResponse>) responseObserver);
          break;
        case METHODID_GET_SERVICE_MODE:
          serviceImpl.getServiceMode((com.rany.service.platform.admin.GetServiceModeRequest) request,
              (io.grpc.stub.StreamObserver<com.rany.service.platform.admin.ServiceModeResponse>) responseObserver);
          break;
        case METHODID_SUSPEND_BACKEND_THREADS:
          serviceImpl.suspendBackendThreads((com.rany.service.platform.admin.SuspendWorkThreadRequest) request,
              (io.grpc.stub.StreamObserver<com.rany.service.platform.admin.SuspendWorkThreadResponse>) responseObserver);
          break;
        case METHODID_RESUME_BACKEND_THREADS:
          serviceImpl.resumeBackendThreads((com.rany.service.platform.admin.ResumeWorkThreadRequest) request,
              (io.grpc.stub.StreamObserver<com.rany.service.platform.admin.ResumeWorkThreadResponse>) responseObserver);
          break;
        case METHODID_GET_BACKEND_THREADS_STATUS:
          serviceImpl.getBackendThreadsStatus((com.rany.service.platform.admin.GetWorkThreadStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.rany.service.platform.admin.GetWorkThreadStatusResponse>) responseObserver);
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

  private static abstract class AdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdminServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.rany.service.platform.admin.SearchMiddlePlatformAdminService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdminService");
    }
  }

  private static final class AdminServiceFileDescriptorSupplier
      extends AdminServiceBaseDescriptorSupplier {
    AdminServiceFileDescriptorSupplier() {}
  }

  private static final class AdminServiceMethodDescriptorSupplier
      extends AdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AdminServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AdminServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdminServiceFileDescriptorSupplier())
              .addMethod(METHOD_PING)
              .addMethod(METHOD_SET_SERVICE_READ_ONLY)
              .addMethod(METHOD_SET_SERVICE_IN_SERVICE)
              .addMethod(METHOD_SET_SERVICE_SUSPEND)
              .addMethod(METHOD_GET_SERVICE_MODE)
              .addMethod(METHOD_SUSPEND_BACKEND_THREADS)
              .addMethod(METHOD_RESUME_BACKEND_THREADS)
              .addMethod(METHOD_GET_BACKEND_THREADS_STATUS)
              .build();
        }
      }
    }
    return result;
  }
}
