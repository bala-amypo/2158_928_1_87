package com.example.demo.repository;

import com.example.demo.entity.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Long> {
    boolean existsByCategoryName(String categoryName);
}
