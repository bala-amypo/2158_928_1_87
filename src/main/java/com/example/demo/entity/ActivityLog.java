package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private ActivityType activityType;

    private Double quantity;

    private LocalDate activityDate;

    private Double estimatedEmission;   // ✅ REQUIRED FIELD

    // ===== getters & setters =====

    public Double getEstimatedEmission() {
        return estimatedEmission;
    }

    public void setEstimatedEmission(Double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
