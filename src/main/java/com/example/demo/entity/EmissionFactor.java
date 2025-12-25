// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.time.LocalDateTime;

// @Entity @Data
// public class EmissionFactor {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @OneToOne @JoinColumn(name = "activity_type_id")
//     private ActivityType activityType;
//     private Double factorValue;
//     private String unit;
//     private LocalDateTime createdAt;

//     @PrePersist
//     protected void onCreate() { this.createdAt = LocalDateTime.now(); }
// }

// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "emission_factors")
// public class EmissionFactor {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @OneToOne // Or ManyToOne depending on requirement, spec uses findByActivityType_Id
//     @JoinColumn(name = "activity_type_id", nullable = false)
//     private ActivityType activityType;

//     private Double factorValue;
//     private String unit;
//     private LocalDateTime createdAt;

//     public EmissionFactor() {}

//     public EmissionFactor(Long id, ActivityType activityType, Double factorValue, String unit, LocalDateTime createdAt) {
//         this.id = id;
//         this.activityType = activityType;
//         this.factorValue = factorValue;
//         this.unit = unit;
//         this.createdAt = createdAt;
//     }

//     @PrePersist
//     protected void onCreate() {
//         this.createdAt = LocalDateTime.now();
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public ActivityType getActivityType() { return activityType; }
//     public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
//     public Double getFactorValue() { return factorValue; }
//     public void setFactorValue(Double factorValue) { this.factorValue = factorValue; }
//     public String getUnit() { return unit; }
//     public void setUnit(String unit) { this.unit = unit; }
//     public LocalDateTime getCreatedAt() { return createdAt; }
// }

// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "emission_factors")
// public class EmissionFactor {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Double factorValue;
//     private String unit;
//     private LocalDateTime createdAt;

//     @OneToOne
//     @JoinColumn(name = "type_id")
//     private ActivityType activityType;

//     public EmissionFactor() {}

//     public EmissionFactor(Long id, Double factorValue, String unit, ActivityType activityType) {
//         this.id = id;
//         this.factorValue = factorValue;
//         this.unit = unit;
//         this.activityType = activityType;
//     }

//     @PrePersist
//     public void prePersist() {
//         if (this.createdAt == null) {
//             this.createdAt = LocalDateTime.now();
//         }
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public Double getFactorValue() { return factorValue; }
//     public void setFactorValue(Double factorValue) { this.factorValue = factorValue; }
//     public String getUnit() { return unit; }
//     public void setUnit(String unit) { this.unit = unit; }
//     public ActivityType getActivityType() { return activityType; }
//     public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
//     public LocalDateTime getCreatedAt() { return createdAt; }
// }


// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "emission_factors")
// public class EmissionFactor {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Double factorValue;
//     private String unit;
//     private LocalDateTime createdAt;

//     @OneToOne
//     @JoinColumn(name = "type_id")
//     private ActivityType activityType;

//     public EmissionFactor() {}

//     public EmissionFactor(Long id, Double factorValue, String unit, ActivityType activityType) {
//         this.id = id;
//         this.factorValue = factorValue;
//         this.unit = unit;
//         this.activityType = activityType;
//     }

//     @PrePersist
//     public void prePersist() {
//         if (this.createdAt == null) {
//             this.createdAt = LocalDateTime.now();
//         }
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public Double getFactorValue() { return factorValue; }
//     public void setFactorValue(Double factorValue) { this.factorValue = factorValue; }
//     public String getUnit() { return unit; }
//     public void setUnit(String unit) { this.unit = unit; }
//     public ActivityType getActivityType() { return activityType; }
//     public void setActivityType(ActivityType activityType) { this.activityType = activityType; }
//     public LocalDateTime getCreatedAt() { return createdAt; }
// }

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emission_factors")
public class EmissionFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double factorValue;
    private String unit;
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "type_id")
    private ActivityType activityType;

    public EmissionFactor() {}

    // FIX: Constructor required by tests
    public EmissionFactor(Long id, ActivityType activityType, Double factorValue, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.activityType = activityType;
        this.factorValue = factorValue;
        this.unit = unit;
        this.createdAt = createdAt;
    }

    // Standard constructor for service logic
    public EmissionFactor(Long id, Double factorValue, String unit, ActivityType activityType) {
        this.id = id;
        this.factorValue = factorValue;
        this.unit = unit;
        this.activityType = activityType;
    }

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Long getId() { return id; }
    public Double getFactorValue() { return factorValue; }
    public String getUnit() { return unit; }
    public ActivityType getActivityType() { return activityType; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}