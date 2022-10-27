package com.gateway.controller

import com.gateway.client.PetClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/pet")
class PetController {

    @Autowired
    lateinit var petClientService: PetClientService

    @GetMapping("/name")
    fun getName() = petClientService.getInfo()

    @GetMapping("/name/owner")
    fun getOwnerName() = petClientService.getOwnerName()
}