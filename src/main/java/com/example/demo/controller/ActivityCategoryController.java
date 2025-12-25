// package com.example.demo.controller;

// import com.example.demo.entity.ActivityCategory;
// import com.example.demo.service.ActivityCategoryService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/categories")
// @Tag(name = "ActivityCategoryController")
// public class ActivityCategoryController {
//     private final ActivityCategoryService categoryService;

//     public ActivityCategoryController(ActivityCategoryService categoryService) {
//         this.categoryService = categoryService;
//     }

//     @PostMapping("/")
//     public ActivityCategory create(@RequestBody ActivityCategory category) {
//         return categoryService.createCategory(category);
//     }

//     @GetMapping("/")
//     public List<ActivityCategory> list() {
//         return categoryService.getAllCategories();
//     }

//     @GetMapping("/{id}")
//     public ActivityCategory get(@PathVariable Long id) {
//         return categoryService.getCategory(id);
//     }
// }


package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ActivityCategoryController {

    private final ActivityCategoryService categoryService;

    public ActivityCategoryController(ActivityCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<ActivityCategory> createCategory(@RequestBody ActivityCategory category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping
    public ResponseEntity<List<ActivityCategory>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityCategory> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
}