package com.example.Dynamic_Routes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.Dynamic_Routes.entity.RouteEntity;
import com.example.Dynamic_Routes.service.RouteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    public RouteEntity addRoute(@RequestBody RouteEntity route) {
        return routeService.addRoute(route);
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Long id) {
        routeService.deleteRoute(id);
    }

    @GetMapping
    public List<RouteEntity> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/refreshroutes")
    public String refreshRoutes() throws Exception {
        return routeService.refreshRoutes();
    }
}
