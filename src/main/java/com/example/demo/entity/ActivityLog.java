package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Data
public class ActivityLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "type_id")
    private ActivityType activityType;
    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
    private Double quantity;
    private LocalDate activityDate;
    private LocalDateTime loggedAt;
    private Double estimatedEmission;

    @PrePersist
    protected void onCreate() { this.loggedAt = LocalDateTime.now(); }
}