package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    private final EmissionFactorService service;

    public EmissionFactorController(EmissionFactorService service) {
        this.service = service;
    }

    @PostMapping("/{typeId}")
    public EmissionFactor create(
            @PathVariable Long typeId,
            @RequestBody EmissionFactor factor) {
        return service.create(typeId, factor);
    }
}
