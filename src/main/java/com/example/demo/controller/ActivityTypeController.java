package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    private final ActivityTypeService service;

    public ActivityTypeController(ActivityTypeService service) {
        this.service = service;
    }

    @PostMapping("/{categoryId}")
    public ActivityType create(
            @PathVariable Long categoryId,
            @RequestBody ActivityType type) {
        return service.create(categoryId, type);
    }

    @GetMapping
    public List<ActivityType> getAll() {
        return service.getAll();
    }
}
