package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// @Entity
// @Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String fullName;
//     private String email;
//     private String password;
//     private String role = "USER";
//     private LocalDateTime createdAt;

//     @PrePersist
//     public void onCreate() {
//         this.createdAt = LocalDateTime.now();
//     }

//     public Long getId() { return id; }
//     public String getFullName() { return fullName; }
//     public void setFullName(String fullName) { this.fullName = fullName; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public String getRole() { return role; }
//}

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must not be empty")
    private String fullName;

    @NotBlank(message = "Email must not be empty")
    private String email;

    @NotBlank(message = "Password must not be empty")
    private String password;

    private String role = "USER";

    // getters & setters
}
