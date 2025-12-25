// // package com.example.demo.repository;

// // import com.example.demo.entity.ActivityLog;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import java.time.LocalDate;
// // import java.util.List;

// // public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
// //     List<ActivityLog> findByUserId(Long userId);
// //     List<ActivityLog> findByUserIdAndActivityDateBetween(Long userId, LocalDate start, LocalDate end);
// // }

package com.example.demo.repository;

import com.example.demo.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    
    // Required by tests: uses underscore to traverse to User's ID
    List<ActivityLog> findByUser_Id(long userId);
    
    // Required by tests: date range filtering for a specific user
    List<ActivityLog> findByUser_IdAndActivityDateBetween(long userId, LocalDate start, LocalDate end);
    
    // Required by your service implementation
    List<ActivityLog> findByUserId(Long userId);
}

