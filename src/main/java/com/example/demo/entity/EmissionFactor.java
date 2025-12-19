package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class EmissionFactor {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @OneToOne

    private ActivityType activityType;

    private Double factorValue;

    private String unit;

    private LocalDateTime createdAt;

    @PrePersist

    public void onCreate() {

        this.createdAt = LocalDateTime.now();

    }

    // getters and setters

}

