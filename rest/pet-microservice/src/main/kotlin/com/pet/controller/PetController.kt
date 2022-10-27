package com.pet.controller

import com.pet.client.OwnerClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PetController {

    private val name = "Sobaka"

    @Autowired
    lateinit var ownerClient: OwnerClient

    @GetMapping("/name")
    fun getName() = name

    @GetMapping("/name/owner")
    fun getPetName() = "My owner name is: ${ownerClient.getName()}"
}