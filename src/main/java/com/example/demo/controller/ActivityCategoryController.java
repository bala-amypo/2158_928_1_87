package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Activity Categories")
public class ActivityCategoryController {

    private final ActivityCategoryService service;

    public ActivityCategoryController(ActivityCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityCategory create(@RequestBody ActivityCategory category) {
        return service.createCategory(category);
    }

    @GetMapping
    public List<ActivityCategory> list() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ActivityCategory get(@PathVariable Long id) {
        return service.getCategory(id);
    }

    @PutMapping("/{id}")
    public ActivityCategory update(@PathVariable Long id,
                                   @RequestBody ActivityCategory category) {
        ActivityCategory existing = service.getCategory(id);
        existing.setCategoryName(category.getCategoryName());
        existing.setDescription(category.getDescription());
        return service.createCategory(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.getCategory(id);
    }
}
