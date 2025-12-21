package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.entity.ActivityType;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class EmissionFactorService {

    private final EmissionFactorRepository factorRepo;
    private final ActivityTypeRepository typeRepo;

    public EmissionFactorService(EmissionFactorRepository factorRepo,
                                 ActivityTypeRepository typeRepo) {
        this.factorRepo = factorRepo;
        this.typeRepo = typeRepo;
    }

    public EmissionFactor createFactor(Long typeId, EmissionFactor factor) {
        ActivityType type = typeRepo.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found"));

        factor.setActivityType(type);
        return factorRepo.save(factor);
    }

    public EmissionFactor getFactor(Long id) {
        return factorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found"));
    }

    public EmissionFactor getFactorByType(Long typeId) {
        return factorRepo.findByActivityType_Id(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found"));
    }

    public List<EmissionFactor> getAllFactors() {
        return factorRepo.findAll();
    }
}
