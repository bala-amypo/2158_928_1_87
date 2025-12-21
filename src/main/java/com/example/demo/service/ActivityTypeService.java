package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.ActivityType;
import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ActivityTypeService {

    private final ActivityTypeRepository typeRepo;
    private final ActivityCategoryRepository categoryRepo;

    public ActivityTypeService(ActivityTypeRepository typeRepo,
                               ActivityCategoryRepository categoryRepo) {
        this.typeRepo = typeRepo;
        this.categoryRepo = categoryRepo;
    }

    public ActivityType createType(Long categoryId, ActivityType type) {
        ActivityCategory category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        type.setCategory(category);
        return typeRepo.save(type);
    }

    public ActivityType getType(Long id) {
        return typeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found"));
    }

    public List<ActivityType> getTypesByCategory(Long categoryId) {
        return typeRepo.findByCategory_Id(categoryId);
    }
}
