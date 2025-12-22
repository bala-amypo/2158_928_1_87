package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Entity
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ActivityType activityType;

    @Positive
    private double factorValue;

    // getters & setters
    public double getFactorValue() { return factorValue; }
    public void setFactorValue(double factorValue) { this.factorValue = factorValue; }
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
}
