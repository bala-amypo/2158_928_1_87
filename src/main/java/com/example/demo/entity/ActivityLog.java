package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Double estimatedEmission;
    private LocalDateTime loggedAt;

    @PrePersist
    public void onCreate() {
        loggedAt = LocalDateTime.now();
    }

    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
    public void setUser(User user) { this.user = user; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }
    public Double getQuantity() { return quantity; }
    public LocalDate getActivityDate() { return activityDate; }
    public void setEstimatedEmission(Double estimatedEmission) { this.estimatedEmission = estimatedEmission; }
}
