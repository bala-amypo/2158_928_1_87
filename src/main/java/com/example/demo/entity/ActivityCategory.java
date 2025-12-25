// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.time.LocalDateTime;

// @Entity @Data
// public class ActivityCategory {
//     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @Column(unique = true) private String categoryName;
//     private String description;
//     private LocalDateTime createdAt;

//     @PrePersist
//     protected void onCreate() { this.createdAt = LocalDateTime.now(); }
//}

// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "activity_categories")
// public class ActivityCategory {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true, nullable = false)
//     private String categoryName;

//     private String description;

//     private LocalDateTime createdAt;

//     public ActivityCategory() {}

//     public ActivityCategory(Long id, String categoryName, String description, LocalDateTime createdAt) {
//         this.id = id;
//         this.categoryName = categoryName;
//         this.description = description;
//         this.createdAt = createdAt;
//     }

//     @PrePersist
//     protected void onCreate() {
//         this.createdAt = LocalDateTime.now();
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getCategoryName() { return categoryName; }
//     public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }
//     public LocalDateTime getCreatedAt() { return createdAt; }
// }

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_categories")
public class ActivityCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;
    private String description;
    private LocalDateTime createdAt;

    public ActivityCategory() {}

    public ActivityCategory(Long id, String categoryName, String description) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
    }

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}