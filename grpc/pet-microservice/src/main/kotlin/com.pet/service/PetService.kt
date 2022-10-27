package com.pet.service

import com.grpc.PetInfo
import com.grpc.PetInfoServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.springframework.beans.factory.annotation.Autowired

@GrpcService
class PetService : PetInfoServiceGrpc.PetInfoServiceImplBase() {

    private val name = "gRPC Sobaka"

    @Autowired
    lateinit var ownerClientService: OwnerClientService

    override fun getName(
        request: PetInfo.PetInfoRequest?,
        responseObserver: StreamObserver<PetInfo.PetInfoResponse>?
    ) {
        val builder = PetInfo.PetInfoResponse.newBuilder().apply {
            info = name
        }.build()
        responseObserver!!.onNext(builder)
        responseObserver.onCompleted()
    }

    override fun getOwnerName(
        request: PetInfo.PetInfoRequest?,
        responseObserver: StreamObserver<PetInfo.PetInfoResponse>?
    ) {
        val builder = PetInfo.PetInfoResponse.newBuilder().apply {
            info = "My owner name is:  ${ownerClientService.getInfo()}"
        }.build()
        responseObserver!!.onNext(builder)
        responseObserver.onCompleted()
    }
}