package com.rany.service.component.impl;

import com.rany.service.common.constants.Constants;
import com.rany.service.common.exception.CommonReturnCode;
import com.rany.service.platform.admin.*;
import io.grpc.stub.StreamObserver;

/**
 * @author zhongshengwang
 * @description TODO
 * @date 2022/3/29 11:06 下午
 * @email 18668485565@163.com
 */

public class AdminServiceComponent extends AdminServiceGrpc.AdminServiceImplBase {

    private MasterServiceInternalImpl internal;

    public AdminServiceComponent(MasterServiceInternalImpl internal) {
        this.internal = internal;
    }

    @Override
    public void ping(PingRequest request, StreamObserver<PingReply> responseObserver) {
        PingReply reply = PingReply.newBuilder()
                .setPong(Constants.PONG)
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


    @Override
    public void setServiceReadOnly(SetReadOnlyRequest request, StreamObserver<ReadOnlyResponse> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        internal.setReadonly();
        ReadOnlyResponse reply = ReadOnlyResponse.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void setServiceSuspend(SetSuspendRequest request, StreamObserver<SuspendResponse> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        internal.setSuspend();
        SuspendResponse reply = SuspendResponse.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void setServiceInService(SetInServiceRequest request, StreamObserver<InServiceResponse> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        internal.setNormal();
        InServiceResponse reply = InServiceResponse.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getServiceMode(GetServiceModeRequest request, StreamObserver<ServiceModeResponse> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        MasterServiceInternalImpl.RUNNING_STATUS status = internal.getStatus();
        ServiceModeResponse reply = ServiceModeResponse.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .setMode(status.name())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void suspendBackendThreads(SuspendWorkThreadRequest request, StreamObserver<SuspendWorkThreadResponse> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        internal.suspendBackgroundExecutors();
        SuspendWorkThreadResponse reply = SuspendWorkThreadResponse.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void resumeBackendThreads(ResumeWorkThreadRequest request, StreamObserver<ResumeWorkThreadResponse> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        internal.resumeBackgroundExecutors();
        ResumeWorkThreadResponse reply = ResumeWorkThreadResponse.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void getBackendThreadsStatus(GetWorkThreadStatusRequest request, StreamObserver<GetWorkThreadStatusResponse> responseObserver) {
        CommonReturnCode code = CommonReturnCode.SUCCEED;
        boolean running = internal.getBackgroundExecutorsStatus();
        GetWorkThreadStatusResponse reply = GetWorkThreadStatusResponse.newBuilder()
                .setCode(code.getCode())
                .setMessage(code.getMessage())
                .setRunning(running)
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
