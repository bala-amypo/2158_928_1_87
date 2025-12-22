package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = "typeName")
)
public class ActivityType {package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String typeName;

    @NotBlank
    private String unit;

    @ManyToOne
    private ActivityCategory category;

    // getters & setters
    public Long getId() { return id; }
    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public void setCategory(ActivityCategory category) { this.category = category; }
}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;

    private String unit;

    @ManyToOne(optional = false)
    private ActivityCategory category;

    private LocalDateTime createdAt;

    @PrePersist
    void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
