// package com.example.demo.service;

// import com.example.demo.entity.ActivityCategory;
// import com.example.demo.repository.ActivityCategoryRepository;
// import com.example.demo.exception.ValidationException;
// import com.example.demo.exception.ResourceNotFoundException;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class ActivityCategoryService {
//     private final ActivityCategoryRepository categoryRepository;

//     // Constructor Injection (Exact Order)
//     public ActivityCategoryService(ActivityCategoryRepository categoryRepository) {
//         this.categoryRepository = categoryRepository;
//     }

//     public ActivityCategory createCategory(ActivityCategory category) {
//         if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
//             throw new ValidationException("Category name must be unique");
//         }
//         return categoryRepository.save(category);
//     }

//     public ActivityCategory getCategory(Long id) {
//         return categoryRepository.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
//     }

//     public List<ActivityCategory> getAllCategories() {
//         return categoryRepository.findAll();
//     }
// }

package com.example.demo.service;

import com.example.demo.entity.ActivityCategory;
import java.util.List;

public interface ActivityCategoryService {
    ActivityCategory createCategory(ActivityCategory category);
    ActivityCategory getCategory(Long id);
    List<ActivityCategory> getAllCategories();
}