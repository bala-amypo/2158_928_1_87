package com.example.demo.service;



import com.example.demo.entity.*;

import com.example.demo.exception.*;

import com.example.demo.repository.ActivityCategoryRepository;

import java.util.*;



public class ActivityCategoryService {

    private final ActivityCategoryRepository repo;



    public ActivityCategoryService(ActivityCategoryRepository repo) {

        this.repo = repo;

    }



    public ActivityCategory createCategory(ActivityCategory c) {

        if (repo.existsByCategoryName(c.getCategoryName()))

        throw new ValidationException("Category name must be unique");

        return repo.save(c);

    }



    public ActivityCategory getCategory(Long id) {

        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

    }



    public List<ActivityCategory> getAllCategories() {

        return repo.findAll();

    }

}
