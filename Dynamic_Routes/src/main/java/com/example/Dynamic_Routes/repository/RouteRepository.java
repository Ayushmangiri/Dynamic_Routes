package com.example.Dynamic_Routes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Dynamic_Routes.entity.RouteEntity;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
}
