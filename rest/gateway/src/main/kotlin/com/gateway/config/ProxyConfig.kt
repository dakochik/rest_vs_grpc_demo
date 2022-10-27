package com.gateway.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProxyConfig {

    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator =
        builder.routes()
            .route("owner") { r -> r.path("/owner/**").filters { f -> f.stripPrefix(1) }.uri("lb://OWNER") }
            .route("pet") { r -> r.path("/pet/**").filters { f -> f.stripPrefix(1) }.uri("lb://PET")}
            .build()
}