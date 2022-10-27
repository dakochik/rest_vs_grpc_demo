package com.owner.service

import com.grpc.OwnerInfo
import com.grpc.OwnerInfoServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.springframework.beans.factory.annotation.Autowired

@GrpcService
class OwnerService : OwnerInfoServiceGrpc.OwnerInfoServiceImplBase() {

    private val name = "gRPC Oleg"

    @Autowired
    lateinit var petClientService: PetClientService

    override fun getName(
        request: OwnerInfo.OwnerInfoRequest?,
        responseObserver: StreamObserver<OwnerInfo.OwnerInfoResponse>?
    ) {
        val builder = OwnerInfo.OwnerInfoResponse.newBuilder().apply {
            info = name
        }.build()
        responseObserver!!.onNext(builder)
        responseObserver.onCompleted()
    }

    override fun getPetName(
        request: OwnerInfo.OwnerInfoRequest?,
        responseObserver: StreamObserver<OwnerInfo.OwnerInfoResponse>?
    ) {
        val builder = OwnerInfo.OwnerInfoResponse.newBuilder().apply {
            info = "My pet name is:  ${petClientService.getInfo()}"
        }.build()
        responseObserver!!.onNext(builder)
        responseObserver.onCompleted()
    }
}