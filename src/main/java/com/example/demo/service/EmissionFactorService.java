package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.entity.ActivityType;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmissionFactorService {
    private final EmissionFactorRepository factorRepository;
    private final ActivityTypeRepository typeRepository;

    // Constructor Injection (Exact Order: FactorRepo, TypeRepo)
    public EmissionFactorService(EmissionFactorRepository factorRepository, ActivityTypeRepository typeRepository) {
        this.factorRepository = factorRepository;
        this.typeRepository = typeRepository;
    }

    public EmissionFactor createFactor(Long activityTypeId, EmissionFactor factor) {
        ActivityType type = typeRepository.findById(activityTypeId)
            .orElseThrow(() -> new ResourceNotFoundException("Activity type not found"));
        factor.setActivityType(type);
        return factorRepository.save(factor);
    }

    public EmissionFactor getFactor(Long id) {
        return factorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found"));
    }

    public EmissionFactor getFactorByType(Long typeId) {
        return factorRepository.findByActivityType_Id(typeId)
            .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found"));
    }

    public List<EmissionFactor> getAllFactors() {
        return factorRepository.findAll();
    }
}