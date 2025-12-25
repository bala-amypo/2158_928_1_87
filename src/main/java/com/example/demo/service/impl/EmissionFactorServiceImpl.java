package com.example.demo.service.impl;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    private final EmissionFactorRepository factorRepository;

    public EmissionFactorServiceImpl(EmissionFactorRepository factorRepository) {
        this.factorRepository = factorRepository;
    }

    @Override
    public EmissionFactor saveFactor(Long typeId, EmissionFactor factor) {
        // Logic to link factor to activity type would go here
        return factorRepository.save(factor);
    }

    @Override
    public EmissionFactor getByActivityType(Long typeId) {
        // Updated to match the Repository method name
        return factorRepository.findByActivityTypeId(typeId)
                .orElseThrow(() -> new RuntimeException("Emission Factor not found for type: " + typeId));
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return factorRepository.findAll();
    }
}