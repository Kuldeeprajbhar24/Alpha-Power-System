package com.alphapower.apigateway.filter;

import com.alphapower.apigateway.security.JwtTokenUtil;
import com.alphapower.apigateway.util.RouteValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationFilter implements GlobalFilter {
    private final RouteValidator routeValidator;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Insert in filter function : ");

        String path = exchange.getRequest().getURI().getPath();
        System.out.println("Filter Executed 🔥");
        System.out.println("Incoming request path: " + path);

        if (routeValidator.isSecured.test(path)) {

            System.out.println("SECURED ROUTE");

            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("Missing Authorization Header");
            }

            String authHeader = exchange.getRequest()
                    .getHeaders()
                    .get(HttpHeaders.AUTHORIZATION)
                    .get(0);

            if (authHeader != null && authHeader.startsWith("Bearer ")) {

                String token = authHeader.substring(7);

                System.out.println("Authorization Header: " + authHeader);
                System.out.println("Token: " + token);

                try {
                    jwtTokenUtil.validateToken(token);
                } catch (Exception e) {
                    throw new RuntimeException("Invalid JWT Token");
                }

            } else {
                throw new RuntimeException("Invalid Authorization Header");
            }
        }

        return chain.filter(exchange);
    }
}