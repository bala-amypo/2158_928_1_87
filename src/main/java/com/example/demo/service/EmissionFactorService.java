package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;

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
                .orElseThrow(() -> new RuntimeException("ActivityType not found"));

        factor.setActivityType(type);
        return factorRepo.save(factor);
    }

    public List<EmissionFactor> getAllFactors() {
        return factorRepo.findAll();
    }
}
