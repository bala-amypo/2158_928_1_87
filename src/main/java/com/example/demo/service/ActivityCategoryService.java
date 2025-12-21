package com.example.demo.service;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityCategoryService {

    private final ActivityCategoryRepository repository;

    public ActivityCategoryService(ActivityCategoryRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public ActivityCategory create(ActivityCategory category) {
        return repository.save(category);
    }

    // GET ALL
    public List<ActivityCategory> getAll() {
        return repository.findAll();
    }
}


// package com.example.demo.service;



// import com.example.demo.entity.*;

// import com.example.demo.exception.*;

// import com.example.demo.repository.ActivityCategoryRepository;

// import java.util.*;


// import org.springframework.stereotype.Service;

// @Service
// public class ActivityCategoryService {

//     private final ActivityCategoryRepository repo;



//     public ActivityCategoryService(ActivityCategoryRepository repo) {

//         this.repo = repo;

//     }



//     public ActivityCategory createCategory(ActivityCategory c) {

//         if (repo.existsByCategoryName(c.getCategoryName()))

//         throw new ValidationException("Category name must be unique");

//         return repo.save(c);

//     }



//     public ActivityCategory getCategory(Long id) {

//         return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

//     }



//     public List<ActivityCategory> getAllCategories() {

//         return repo.findAll();

//     }

// }
