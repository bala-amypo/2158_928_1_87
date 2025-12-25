// package com.example.demo.service;

// import com.example.demo.entity.ActivityType;
// import com.example.demo.entity.ActivityCategory;
// import com.example.demo.repository.ActivityTypeRepository;
// import com.example.demo.repository.ActivityCategoryRepository;
// import com.example.demo.exception.ResourceNotFoundException;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class ActivityTypeService {
//     private final ActivityTypeRepository typeRepository;
//     private final ActivityCategoryRepository categoryRepository;

//     // Constructor Injection (Exact Order: TypeRepo, CategoryRepo)
//     public ActivityTypeService(ActivityTypeRepository typeRepository, ActivityCategoryRepository categoryRepository) {
//         this.typeRepository = typeRepository;
//         this.categoryRepository = categoryRepository;
//     }

//     public ActivityType createType(Long categoryId, ActivityType type) {
//         ActivityCategory category = categoryRepository.findById(categoryId)
//             .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
//         type.setCategory(category);
//         return typeRepository.save(type);
//     }

//     public ActivityType getType(Long id) {
//         return typeRepository.findById(id)
//             .orElseThrow(() -> new ResourceNotFoundException("Activity type not found"));
//     }

//     public List<ActivityType> getTypesByCategory(Long categoryId) {
//         return typeRepository.findByCategory_Id(categoryId);
//     }
// }


package com.example.demo.service;

import com.example.demo.entity.ActivityType;
import java.util.List;

public interface ActivityTypeService {
    ActivityType createType(Long categoryId, ActivityType type);
    ActivityType getType(Long id);
    List<ActivityType> getTypesByCategory(Long categoryId);
}