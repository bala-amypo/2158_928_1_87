// package com.example.demo.controller;

// import com.example.demo.entity.ActivityType;
// import com.example.demo.service.ActivityTypeService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/types")
// @Tag(name = "ActivityTypeController")
// public class ActivityTypeController {
//     private final ActivityTypeService typeService;

//     public ActivityTypeController(ActivityTypeService typeService) {
//         this.typeService = typeService;
//     }

//     @PostMapping("/category/{categoryId}")
//     public ActivityType create(@PathVariable Long categoryId, @RequestBody ActivityType type) {
//         return typeService.createType(categoryId, type);
//     }

//     @GetMapping("/category/{categoryId}")
//     public List<ActivityType> listByCategory(@PathVariable Long categoryId) {
//         return typeService.getTypesByCategory(categoryId);
//     }

//     @GetMapping("/{id}")
//     public ActivityType get(@PathVariable Long id) {
//         return typeService.getType(id);
//     }
// }

package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    private final ActivityTypeService typeService;

    public ActivityTypeController(ActivityTypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping("/category/{categoryId}")
    public ResponseEntity<ActivityType> createType(@PathVariable Long categoryId, @RequestBody ActivityType type) {
        return ResponseEntity.ok(typeService.createType(categoryId, type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityType> getTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(typeService.getType(id));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getTypesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(typeService.getTypesByCategory(categoryId));
    }
}