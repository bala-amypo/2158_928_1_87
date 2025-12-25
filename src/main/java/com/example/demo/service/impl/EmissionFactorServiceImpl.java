package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository factorRepository;
    private final ActivityTypeRepository typeRepository;

    public EmissionFactorServiceImpl(EmissionFactorRepository factorRepository, 
                                     ActivityTypeRepository typeRepository) {
        this.factorRepository = factorRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public EmissionFactor createFactor(Long typeId, EmissionFactor factor) {
        ActivityType type = typeRepository.findById(typeId)
                .orElseThrow(() -> new RuntimeException("Activity Type not found"));
        factor.setActivityType(type);
        return factorRepository.save(factor);
    }

    @Override
    public EmissionFactor getFactor(Long typeId) {
        // Uses the findByActivityTypeId method in the repository
        return factorRepository.findByActivityTypeId(typeId)
                .orElseThrow(() -> new RuntimeException("Emission Factor not found for type: " + typeId));
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return factorRepository.findAll();
    }
}