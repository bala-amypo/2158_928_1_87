package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;

@RestController
@RequestMapping("/api/categories")
public class ActivityCategoryController {

    private final ActivityCategoryService service;

    public ActivityCategoryController(ActivityCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityCategory create(@RequestBody ActivityCategory c) {
        return service.createCategory(c);
    }

    @GetMapping
    public List<ActivityCategory> all() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ActivityCategory get(@PathVariable Long id) {
        return service.getCategory(id);
    }
}
