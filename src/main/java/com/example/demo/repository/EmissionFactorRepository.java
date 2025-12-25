package com.example.demo.repository;

import com.example.demo.entity.EmissionFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmissionFactorRepository extends JpaRepository<EmissionFactor, Long> {
    // FIX: Add this specific method name to match your Service Implementation
    Optional<EmissionFactor> findByActivityType_Id(Long typeId);
    
    // Also keep this one as it's standard camelCase
    Optional<EmissionFactor> findByActivityTypeId(Long typeId);
}