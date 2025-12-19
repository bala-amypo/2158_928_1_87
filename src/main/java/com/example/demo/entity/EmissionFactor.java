package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ActivityType activityType;

    private Double factor;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ActivityType getActivityType() { return activityType; }
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }

    public Double getFactor() { return factor; }
    public void setFactor(Double factor) { this.factor = factor; }
}
