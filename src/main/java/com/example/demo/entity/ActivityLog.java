package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityType activityType;

    @Positive
    private double quantity;

    private LocalDate activityDate;

    private double estimatedEmission;

    // getters & setters
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
    public double getQuantity() { return quantity; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }
    public LocalDate getActivityDate() { return activityDate; }
    public void setEstimatedEmission(double estimatedEmission) { this.estimatedEmission = estimatedEmission; }
}
