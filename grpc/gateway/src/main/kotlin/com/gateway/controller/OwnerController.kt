package com.gateway.controller

import com.gateway.client.OwnerClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/owner")
class OwnerController {

    @Autowired
    lateinit var ownerClientService: OwnerClientService

    @GetMapping("/name")
    fun getName() = ownerClientService.getInfo()

    @GetMapping("/name/pet")
    fun getOwnerName() = ownerClientService.getPetName()
}