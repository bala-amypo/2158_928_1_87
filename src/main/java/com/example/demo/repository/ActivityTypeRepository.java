// package com.example.demo.repository;
// import com.example.demo.entity.ActivityType;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
//     List<ActivityType> findByCategory_Id(Long id);
// }

package com.example.demo.repository;

import com.example.demo.entity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
    // Verified in test t43_typesByCategoryRepositoryMethod
    List<ActivityType> findByCategory_Id(Long categoryId);
}