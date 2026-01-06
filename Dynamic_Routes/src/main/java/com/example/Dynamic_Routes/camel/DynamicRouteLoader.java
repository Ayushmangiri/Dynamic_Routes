package com.example.Dynamic_Routes.camel;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.example.Dynamic_Routes.entity.RouteEntity;
import com.example.Dynamic_Routes.repository.RouteRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DynamicRouteLoader {

    private final CamelContext camelContext;
    private final RouteRepository routeRepository;

    public void refreshRoutes() throws Exception {

        camelContext.getRoutes().forEach(route -> {
            try {
                camelContext.getRouteController().stopRoute(route.getId());
                camelContext.removeRoute(route.getId());
            } catch (Exception e) {
                System.err.println("Error removing route: " + e.getMessage());
            }
        });

        List<RouteEntity> routes = routeRepository.findAll();

        for (RouteEntity route : routes) {

            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {

                    if ("FILE".equalsIgnoreCase(route.getRouteType())) {

                        from("file:" + route.getFromFolder())
                                .routeId("file-route-" + route.getId())
                                .to("file:" + route.getToFolder());
                    }

                    else if ("QUEUE".equalsIgnoreCase(route.getRouteType())) {

                        from("jms:queue:" + route.getFromFolder())
                                .routeId("queue-route-" + route.getId())
                                .to("jms:queue:" + route.getToFolder());
                    }
                }
            });
        }
    }
}
