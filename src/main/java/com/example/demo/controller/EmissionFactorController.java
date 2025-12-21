package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;

@RestController
@RequestMapping("/api/factors")
@Tag(name = "Emission Factors")
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

    @GetMapping
    public List<EmissionFactor> list() {
        return service.getAllFactors();
    }

    @GetMapping("/{id}")
    public EmissionFactor get(@PathVariable Long id) {
        return service.getFactor(id);
    }
}
