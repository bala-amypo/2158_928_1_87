package com.example.demo.service;

import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import org.springframework.stereotype.Service;

@Service
public class EmissionFactorService {

    private final EmissionFactorRepository repo;
    private final ActivityTypeRepository typeRepo;

    public EmissionFactorService(EmissionFactorRepository r, ActivityTypeRepository t) {
        this.repo = r;
        this.typeRepo = t;
    }

    public EmissionFactor create(Long typeId, EmissionFactor factor) {
        ActivityType type = typeRepo.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity type not found"));

        factor.setActivityType(type);
        return repo.save(factor);
    }
}
