package com.example.demo.service;



import com.example.demo.entity.*;

import com.example.demo.exception.*;

import com.example.demo.repository.*;

import java.util.*;



public class EmissionFactorService {

    private final EmissionFactorRepository repo;

    private final ActivityTypeRepository typeRepo;



    public EmissionFactorService(EmissionFactorRepository r, ActivityTypeRepository t) {

        this.repo = r;

        this.typeRepo = t;

    }



    public EmissionFactor createFactor(Long typeId, EmissionFactor f) {

        ActivityType t = typeRepo.findById(typeId)

        .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        f.setActivityType(t);

        return repo.save(f);

    }



    public EmissionFactor getFactor(Long id) {

        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

    }



    public EmissionFactor getFactorByType(Long typeId) {

        return repo.findByActivityType_Id(typeId)

        .orElseThrow(() -> new ValidationException("Emission factor not found"));

    }

}

