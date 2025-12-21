package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;

@RestController
@RequestMapping("/api/types")
@Tag(name = "Activity Types")
public class ActivityTypeController {

    private final ActivityTypeService service;

    public ActivityTypeController(ActivityTypeService service) {
        this.service = service;
    }

    @PostMapping("/category/{categoryId}")
    public ActivityType create(@PathVariable Long categoryId,
                               @RequestBody ActivityType type) {
        return service.createType(categoryId, type);
    }

    @GetMapping("/category/{categoryId}")
    public List<ActivityType> listByCategory(@PathVariable Long categoryId) {
        return service.getTypesByCategory(categoryId);
    }

    @GetMapping("/{id}")
    public ActivityType get(@PathVariable Long id) {
        return service.getType(id);
    }
}
