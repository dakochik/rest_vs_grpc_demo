package com.pet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class PetApplication

fun main(args: Array<String>) {
    runApplication<PetApplication>(*args)
}