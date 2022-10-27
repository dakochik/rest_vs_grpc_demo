package com.pet.service

import com.grpc.OwnerInfo
import com.grpc.OwnerInfoServiceGrpc
import net.devh.boot.grpc.client.inject.GrpcClient
import org.springframework.stereotype.Service

@Service
class OwnerClientService {

    @GrpcClient("owner-grpc")
    lateinit var blockingStub: OwnerInfoServiceGrpc.OwnerInfoServiceBlockingStub

    fun getInfo(): String = blockingStub.getName(OwnerInfo.OwnerInfoRequest.newBuilder().build()).info
}