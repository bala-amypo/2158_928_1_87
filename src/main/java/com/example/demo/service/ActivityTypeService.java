package com.example.demo.service;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeService {

    private final ActivityTypeRepository typeRepo;
    private final ActivityCategoryRepository categoryRepo;

    public ActivityTypeService(ActivityTypeRepository t, ActivityCategoryRepository c) {
        this.typeRepo = t;
        this.categoryRepo = c;
    }

    public ActivityType create(Long categoryId, ActivityType type) {
        ActivityCategory category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        type.setCategory(category);
        return typeRepo.save(type);
    }

    public List<ActivityType> getAll() {
        return typeRepo.findAll();
    }
}
