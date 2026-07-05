package com.alphapower.apigateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RequestLoggingFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("Incoming Request : {}", exchange.getRequest().getURI());

        return chain.filter(exchange)
                .then(Mono.fromRunnable(() ->
                        log.info("Response Status : {}", exchange.getResponse().getStatusCode())));
    }
}