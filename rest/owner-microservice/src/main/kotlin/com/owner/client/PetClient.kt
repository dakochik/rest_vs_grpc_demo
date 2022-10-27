package com.owner.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient("pet")
interface PetClient {

    @GetMapping("/name")
    fun getName() : String
}