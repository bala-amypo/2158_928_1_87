package com.example.demo.service;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryService {

    private final ActivityCategoryRepository repo;

    public ActivityCategoryService(ActivityCategoryRepository repo) {
        this.repo = repo;
    }

    public ActivityCategory create(ActivityCategory category) {
        return repo.save(category);
    }

    public List<ActivityCategory> getAll() {
        return repo.findAll();
    }
}
