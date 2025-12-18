package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.*;

@Entity

public class ActivityLog {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne

    private ActivityType activityType;

    @ManyToOne

    private User user;

    private Double quantity;

    private LocalDate activityDate;

    private LocalDateTime loggedAt;

    private Double estimatedEmission;

    @PrePersist

    public void onCreate() {

        this.loggedAt = LocalDateTime.now();

    }

    // getters and setters

}
