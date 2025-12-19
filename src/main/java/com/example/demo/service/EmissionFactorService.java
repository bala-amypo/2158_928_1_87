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

    public EmissionFactor create(Long typeId, EmissionFactor f) {
        ActivityType type = typeRepo.findById(typeId)
                .orElseThrow(() -> new RuntimeException("ActivityType not found"));
        f.setActivityType(type);
        return factorRepo.save(f);
    }

    public List<EmissionFactor> getAllFactors() {
        return factorRepo.findAll();
    }

    public EmissionFactor getById(Long id) {
        return factorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("EmissionFactor not found"));
    }

    public EmissionFactor update(Long id, EmissionFactor f) {
        EmissionFactor existing = getById(id);
        existing.setFactorValue(f.getFactorValue());
        return factorRepo.save(existing);
    }

    public void delete(Long id) {
        factorRepo.deleteById(id);
    }
}
