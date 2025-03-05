package com.example.api_gate.configurations;

import com.example.api_gate.services.ApiExplorer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class RouteConfigurations {
    @Autowired
    private ApiExplorer apiExplorer;
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        var apis = apiExplorer.Behave();
        var routes = builder.routes();

        for(Map.Entry<String, List<String>> pair : apis.entrySet()){
            for(String route : pair.getValue()) {
                routes.route(UUID.randomUUID().toString(),
                            r -> r
                                .path(route)
                                .uri(pair.getKey())
                        );
            }
        }
        return routes.build();
    }
}