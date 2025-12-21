package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;

import com.example.demo.service.ActivityCategoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;


// @RestController

// @RequestMapping("/categories")

// public class ActivityCategoryController {

//     private final ActivityCategoryService service;

//     public ActivityCategoryController(ActivityCategoryService service) {

//         this.service = service;

//     }

//     @PostMapping

//     public ActivityCategory create(@RequestBody ActivityCategory category) {

//         return service.createCategory(category);

//     }

//     @GetMapping("/{id}")

//     public ActivityCategory get(@PathVariable Long id) {

//         return service.getCategory(id);

//     }

//     @GetMapping

//     public List<ActivityCategory> getAll() {

//         return service.getAllCategories();

//     }

// }
 @RestController
@RequestMapping("/categories")
public class ActivityCategoryController {

    private final ActivityCategoryService service;

    public ActivityCategoryController(ActivityCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityCategory create(@Valid @RequestBody ActivityCategory c) {
        return service.create(c);
    }

    @GetMapping
    public List<ActivityCategory> getAll() {
        return service.getAll();
    }
}
 