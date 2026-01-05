package com.example.Dynamic_Routes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Dynamic_Routes.entity.RouteEntity;
import com.example.Dynamic_Routes.repository.RouteRepository;
import com.example.Dynamic_Routes.camel.DynamicRouteLoader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final DynamicRouteLoader routeLoader;

    public RouteEntity addRoute(RouteEntity route) {
        return routeRepository.save(route);
    }

    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }

    public List<RouteEntity> getAllRoutes() {
        return routeRepository.findAll();
    }

    public String refreshRoutes() throws Exception {
        routeLoader.refreshRoutes();
        return "Routes refreshed successfully";
    }
}
