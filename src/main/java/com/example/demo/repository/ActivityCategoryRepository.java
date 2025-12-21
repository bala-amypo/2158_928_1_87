package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.ActivityCategory;

public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Long> {
    boolean existsByCategoryName(String categoryName);
}
