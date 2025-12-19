package com.example.demo.service;



import com.example.demo.entity.*;

import com.example.demo.exception.*;

import com.example.demo.repository.*;

import java.util.*;



public class ActivityTypeService {

    private final ActivityTypeRepository typeRepo;

    private final ActivityCategoryRepository catRepo;



    public ActivityTypeService(ActivityTypeRepository t, ActivityCategoryRepository c) {

        this.typeRepo = t;

        this.catRepo = c;

        }



        public ActivityType createType(Long categoryId, ActivityType type) {

            ActivityCategory cat = catRepo.findById(categoryId)

            .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

            type.setCategory(cat);

            return typeRepo.save(type);

        }



        public ActivityType getType(Long id) {

            return typeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        }



        public List<ActivityType> getTypesByCategory(Long id) {

            return typeRepo.findByCategory_Id(id);

        }

}
