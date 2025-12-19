// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDate;

// @Entity
// public class ActivityLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     private User user;

//     @ManyToOne
//     private ActivityType activityType;

//     private Double quantity;

//     private LocalDate activityDate;

//     private Double emission;

//     // ✅ GETTERS & SETTERS

//     public Long getId() {
//         return id;
//     }

//     public User getUser() {
//         return user;
//     }

//     public void setUser(User user) {
//         this.user = user;
//     }

//     public ActivityType getActivityType() {
//         return activityType;
//     }

//     public void setActivityType(ActivityType activityType) {
//         this.activityType = activityType;
//     }

//     public Double getQuantity() {
//         return quantity;
//     }

//     public void setQuantity(Double quantity) {
//         this.quantity = quantity;
//     }

//     public LocalDate getActivityDate() {
//         return activityDate;
//     }

//     public void setActivityDate(LocalDate activityDate) {
//         this.activityDate = activityDate;
//     }

//     public Double getEmission() {
//         return emission;
//     }

//     public void setEmission(Double emission) {
//         this.emission = emission;
//     }
// }

package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double estimatedEmission;

    // other fields if needed
    // private String activityName;
    // private double quantity;

    // Default constructor
    public ActivityLog() {
    }

    // Getter and Setter for estimatedEmission
    public double getEstimatedEmission() {
        return estimatedEmission;
    }

    public void setEstimatedEmission(double estimatedEmission) {
        this.estimatedEmission = estimatedEmission;
    }

    // Add other getters/setters for your fields if needed
}
