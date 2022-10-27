package com.gateway.client

import com.grpc.PetInfo
import com.grpc.PetInfoServiceGrpc
import net.devh.boot.grpc.client.inject.GrpcClient
import org.springframework.stereotype.Service

@Service
class PetClientService {

    @GrpcClient("pet-grpc")
    lateinit var blockingStub: PetInfoServiceGrpc.PetInfoServiceBlockingStub

    fun getInfo(): String = blockingStub.getName(PetInfo.PetInfoRequest.newBuilder().build()).info

    fun getOwnerName(): String = blockingStub.getOwnerName(PetInfo.PetInfoRequest.newBuilder().build()).info
}