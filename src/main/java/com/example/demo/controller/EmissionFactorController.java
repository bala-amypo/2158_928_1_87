package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorService service;

    public EmissionFactorController(EmissionFactorService service) {
        this.service = service;
    }

    @PostMapping("/{typeId}")
    public EmissionFactor create(@PathVariable Long typeId,
                                 @RequestBody EmissionFactor factor) {
        return service.createFactor(typeId, factor);
    }

    @GetMapping("/{id}")
    public EmissionFactor get(@PathVariable Long id) {
        return service.getFactor(id);
    }

    @GetMapping
    public List<EmissionFactor> all() {
        return service.getAllFactors();
    }
}
