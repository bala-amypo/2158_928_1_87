// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.time.LocalDateTime;

// @Entity @Data
// public class ActivityType {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @Column(unique = true) private String typeName;
//     private String unit;
//     @ManyToOne @JoinColumn(name = "category_id")
//     private ActivityCategory category;
//     private LocalDateTime createdAt;

//     @PrePersist
//     protected void onCreate() { this.createdAt = LocalDateTime.now(); }
//}

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_types")
public class ActivityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ActivityCategory category;

    private String unit; // e.g., "km", "kWh"

    private LocalDateTime createdAt;

    public ActivityType() {}

    public ActivityType(Long id, String typeName, ActivityCategory category, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.typeName = typeName;
        this.category = category;
        this.unit = unit;
        this.createdAt = createdAt;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
    public ActivityCategory getCategory() { return category; }
    public void setCategory(ActivityCategory category) { this.category = category; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}