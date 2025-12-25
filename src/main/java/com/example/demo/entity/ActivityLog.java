// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.time.LocalDate;
// import java.time.LocalDateTime;

// @Entity @Data
// public class ActivityLog {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @ManyToOne @JoinColumn(name = "type_id")
//     private ActivityType activityType;
//     @ManyToOne @JoinColumn(name = "user_id")
//     private User user;
//     private Double quantity;
//     private LocalDate activityDate;
//     private LocalDateTime loggedAt;
//     private Double estimatedEmission;

//     @PrePersist
//     protected void onCreate() { this.loggedAt = LocalDateTime.now(); }
// }

// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDate;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "activity_logs")
// public class ActivityLog {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "type_id", nullable = false)
//     private ActivityType activityType;

//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;

//     private Double quantity;
//     private LocalDate activityDate;
//     private LocalDateTime loggedAt;
//     private Double estimatedEmission;

//     public ActivityLog() {}

//     public ActivityLog(Long id, ActivityType activityType, User user, Double quantity, LocalDate activityDate, LocalDateTime loggedAt, Double estimatedEmission) {
//         this.id = id;
//         this.activityType = activityType;
//         this.user = user;
//         this.quantity = quantity;
//         this.activityDate = activityDate;
//         this.loggedAt = loggedAt;
//         this.estimatedEmission = estimatedEmission;
//     }

//     @PrePersist
//     protected void onLog() {
//         this.loggedAt = LocalDateTime.now();
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public ActivityType getActivityType() { return activityType; }
//     public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }
//     public Double getQuantity() { return quantity; }
//     public void setQuantity(Double quantity) { this.quantity = quantity; }
//     public LocalDate getActivityDate() { return activityDate; }
//     public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }
//     public LocalDateTime getLoggedAt() { return loggedAt; }
//     public Double getEstimatedEmission() { return estimatedEmission; }
//     public void setEstimatedEmission(Double estimatedEmission) { this.estimatedEmission = estimatedEmission; }
// }

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double quantity;
    private Double estimatedEmission;
    private LocalDate activityDate;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ActivityType activityType;

    public ActivityLog() {}

    // Manual constructor matching test requirements
    public ActivityLog(Long id, Double quantity, Double estimatedEmission, LocalDate activityDate, User user, ActivityType activityType) {
        this.id = id;
        this.quantity = quantity;
        this.estimatedEmission = estimatedEmission;
        this.activityDate = activityDate;
        this.user = user;
        this.activityType = activityType;
    }

    // FIX: Add prePersist for the test suite
    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    public Double getEstimatedEmission() { return estimatedEmission; }
    public void setEstimatedEmission(Double estimatedEmission) { this.estimatedEmission = estimatedEmission; }
    public LocalDate getActivityDate() { return activityDate; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public ActivityType getActivityType() { return activityType; }
    public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
}