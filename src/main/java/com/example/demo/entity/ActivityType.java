package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class ActivityType {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(unique = true)

    private String typeName;

    private String unit;

    @ManyToOne

    private ActivityCategory category;

    private LocalDateTime createdAt;

    @PrePersist

    public void onCreate() {

        this.createdAt = LocalDateTime.now();

    }

    // getters and setters

}


  