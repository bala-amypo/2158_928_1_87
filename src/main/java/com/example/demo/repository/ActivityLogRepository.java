// package com.example.demo.repository;
// import com.example.demo.entity.ActivityLog;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.time.LocalDate;
// import java.util.List;

// public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
//     List<ActivityLog> findByUser_Id(Long userId);
//     List<ActivityLog> findByUser_IdAndActivityDateBetween(Long userId, LocalDate start, LocalDate end);
// }

package com.example.demo.repository;

import com.example.demo.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    
    // Used in t44_logsByUserAndDateRepositoryMethod and t80_getLogsByUserAndDate_service
    List<ActivityLog> findByUser_IdAndActivityDateBetween(Long userId, LocalDate start, LocalDate end);

    // Used in test t81_getLogsByUser_service
    List<ActivityLog> findByUser_Id(Long userId);
}