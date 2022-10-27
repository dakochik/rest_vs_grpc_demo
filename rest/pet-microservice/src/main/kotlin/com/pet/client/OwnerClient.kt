package com.pet.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient("owner")
interface OwnerClient {

    @GetMapping("/name")
    fun getName() : String
}