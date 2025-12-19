package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ActivityType activityType;

    private Double factorValue;

    // ✅ GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Double getFactorValue() {
        return factorValue;
    }

    public void setFactorValue(Double factorValue) {
        this.factorValue = factorValue;
    }
}
