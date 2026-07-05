package com.alphapower.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        return builder.routes()

                .route("auth-service", r -> r
                        .path("/api/auth/**")
                        .uri("http://localhost:8081"))

                .route("product-service", r -> r
                        .path("/api/products/**")
                        .uri("http://localhost:8082"))

                .route("order-service", r -> r
                        .path("/api/orders/**")
                        .uri("http://localhost:8083"))

                .route("payment-service", r -> r
                        .path("/api/payments/**")
                        .uri("http://localhost:8084"))

                .build();
    }
}