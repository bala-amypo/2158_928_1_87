package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;
import java.util.List;

public interface EmissionFactorService {
    EmissionFactor saveFactor(Long typeId, EmissionFactor factor);
    EmissionFactor getFactorByType(Long typeId); // Match the name required by your error
    List<EmissionFactor> getAllFactors();
}