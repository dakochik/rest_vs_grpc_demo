package com.owner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class OwnerApplication

fun main(args: Array<String>) {
    runApplication<OwnerApplication>(*args)
}