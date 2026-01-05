package com.example.Dynamic_Routes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "routes")
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_folder", nullable = false)
    private String fromFolder;

    @Column(name = "to_folder", nullable = false)
    private String toFolder;
}
