package com.example.demo.entity;

import jakarta.persistence.*;

// @Entity
// public class EmissionFactor {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Double factorValue;

//     @OneToOne
//     private ActivityType activityType;

//     // ===== GETTERS & SETTERS =====

//     public Long getId() {
//         return id;
//     }

//     public Double getFactorValue() {
//         return factorValue;
//     }

//     public void setFactorValue(Double factorValue) {
//         this.factorValue = factorValue;
//     }

//     public ActivityType getActivityType() {
//         return activityType;
//     }

//     public void setActivityType(ActivityType activityType) {
//         this.activityType = activityType;
//     }
// }

@Entity
public class EmissionFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Factor value is required")
    private Double factorValue;

    @OneToOne
    @NotNull(message = "Activity type must be provided")
    private ActivityType activityType;

    // getters & setters
}
