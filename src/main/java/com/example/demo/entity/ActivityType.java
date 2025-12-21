package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


// @Entity
// public class ActivityType {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String typeName;

//     @ManyToOne
//     private ActivityCategory category;

//     // getters & setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getTypeName() { return typeName; }
//     public void setTypeName(String typeName) { this.typeName = typeName; }

//     public ActivityCategory getCategory() { return category; }
//     public void setCategory(ActivityCategory category) { this.category = category; }
//}

@Entity
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Type name must not be empty")
    private String typeName;

    @ManyToOne
    @NotNull(message = "Category must be provided")
    private ActivityCategory category;

    // getters & setters
}

