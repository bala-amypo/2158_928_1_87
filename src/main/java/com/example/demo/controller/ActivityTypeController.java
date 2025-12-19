package com.example.demo.controller;

import com.example.demo.entity.ActivityType;

import com.example.demo.service.ActivityTypeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/types")

public class ActivityTypeController {

    private final ActivityTypeService service;

    public ActivityTypeController(ActivityTypeService service) {

        this.service = service;

    }

    @PostMapping("/{categoryId}")

    public ActivityType create(@PathVariable Long categoryId,
    )
    @RequestBody ActivityType type) {

        return service.createType(categoryId, type);

    }

    @GetMapping("/{id}")

    public ActivityType get(@PathVariable Long id) {

        return service.getType(id);

    }

    @GetMapping("/category/{id}")

    public List<ActivityType> getByCategory(@PathVariable Long id) {

        return service.getTypesByCategory(id);

    }

}