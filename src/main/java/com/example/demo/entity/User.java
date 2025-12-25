// package com.example.demo.entity;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.time.LocalDateTime;

// @Entity @Data
// public class User {
//     @Id 
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String fullName;
//     @Column(unique = true) private String email;
//     private String password;
//     private String role = "USER";
//     private LocalDateTime createdAt;

//     @PrePersist
//     protected void onCreate() { this.createdAt = LocalDateTime.now(); }
// }

// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "users")
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String fullName;

//     @Column(unique = true, nullable = false)
//     private String email;

//     @Column(nullable = false)
//     private String password;

//     private String role; // "USER" or "ADMIN"

//     private LocalDateTime createdAt;

//     public User() {}

//     // Parameterized constructor used in tests
//     public User(Long id, String fullName, String email, String password, String role, LocalDateTime createdAt) {
//         this.id = id;
//         this.fullName = fullName;
//         this.email = email;
//         this.password = password;
//         this.role = role;
//         this.createdAt = createdAt;
//     }

//     @PrePersist
//     protected void onCreate() {
//         this.createdAt = LocalDateTime.now();
//         if (this.role == null) {
//             this.role = "USER";
//         }
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getFullName() { return fullName; }
//     public void setFullName(String fullName) { this.fullName = fullName; }
//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }
//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }
//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
//     public LocalDateTime getCreatedAt() { return createdAt; }
//     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
// }

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role;
    private LocalDateTime createdAt;

    public User() {}

    public User(Long id, String fullName, String email, String password, String role, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
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
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}