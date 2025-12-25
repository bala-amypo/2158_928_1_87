// package com.example.demo.repository;
// import com.example.demo.entity.ActivityCategory;
// import org.springframework.data.jpa.repository.JpaRepository;

// public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Long> {
//     boolean existsByCategoryName(String name);
// }

package com.example.demo.repository;

import com.example.demo.entity.ActivityCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Long> {
    // Checked in test t15_createCategory_duplicateName
    boolean existsByCategoryName(String name);
}