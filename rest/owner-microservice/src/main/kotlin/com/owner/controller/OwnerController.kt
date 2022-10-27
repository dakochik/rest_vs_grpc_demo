package com.owner.controller

import com.owner.client.PetClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OwnerController {

    private val name = "Oleg"

    @Autowired
    lateinit var petClient: PetClient

    @GetMapping("/name")
    fun getName() = name

    @GetMapping("/name/pet")
    fun getPetName() = "My pet name is: ${petClient.getName()}"
}