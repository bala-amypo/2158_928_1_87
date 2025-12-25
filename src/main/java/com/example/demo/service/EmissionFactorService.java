package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;
import java.util.List;

public interface EmissionFactorService {
    // Methods named to match Controller expectations
    EmissionFactor createFactor(Long typeId, EmissionFactor factor);
    EmissionFactor getFactor(Long typeId);
    List<EmissionFactor> getAllFactors();
}