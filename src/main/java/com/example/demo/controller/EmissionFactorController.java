package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorService factorService;

    public EmissionFactorController(EmissionFactorService factorService) {
        this.factorService = factorService;
    }

    @PostMapping("/type/{typeId}")
    public ResponseEntity<EmissionFactor> createFactor(@PathVariable Long typeId, @RequestBody EmissionFactor factor) {
        return ResponseEntity.ok(factorService.createFactor(typeId, factor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmissionFactor> getFactor(@PathVariable Long id) {
        return ResponseEntity.ok(factorService.getFactor(id));
    }

    @GetMapping("/type/{typeId}")
    public ResponseEntity<EmissionFactor> getFactorByType(@PathVariable Long typeId) {
        return ResponseEntity.ok(factorService.getFactorByType(typeId));
    }

    @GetMapping
    public ResponseEntity<List<EmissionFactor>> getAllFactors() {
        return ResponseEntity.ok(factorService.getAllFactors());
    }
}
