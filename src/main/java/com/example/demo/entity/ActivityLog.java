package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private ActivityType activityType;

    @ManyToOne(optional = false)
    private User user;

    private Double quantity;

    private LocalDate activityDate;

    private Double estimatedEmission;

    private LocalDateTime loggedAt;

    @PrePersist
    void prePersist() {
        loggedAt = LocalDateTime.now();
    }
}
