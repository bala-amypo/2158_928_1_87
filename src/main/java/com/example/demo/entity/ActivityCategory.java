package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class ActivityCategory {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(unique = true)

    private String categoryName;

    private String description;

    private LocalDateTime createdAt;

    @PrePersist

    public void onCreate() {

        this.createdAt = LocalDateTime.now();

    }

    // getters and setters

}

