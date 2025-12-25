// package com.example.demo.service;
// import com.example.demo.entity.*;
// import com.example.demo.repository.*;
// import com.example.demo.exception.ValidationException;
// import com.example.demo.exception.ResourceNotFoundException;
// import org.springframework.stereotype.Service;
// import java.time.LocalDate;
// import java.util.List;

// @Service
// public class ActivityLogService {
//     private final ActivityLogRepository logRepo;
//     private final UserRepository userRepo;
//     private final ActivityTypeRepository typeRepo;
//     private final EmissionFactorRepository factorRepo;

//     public ActivityLogService(ActivityLogRepository logRepo, UserRepository userRepo, ActivityTypeRepository typeRepo, EmissionFactorRepository factorRepo) {
//         this.logRepo = logRepo;
//         this.userRepo = userRepo;
//         this.typeRepo = typeRepo;
//         this.factorRepo = factorRepo;
//     }

//     public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {
//         if (log.getActivityDate().isAfter(LocalDate.now())) throw new ValidationException("cannot be in the future");
//         User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
//         ActivityType type = typeRepo.findById(typeId).orElseThrow(() -> new ResourceNotFoundException("Activity type not found"));
//         EmissionFactor factor = factorRepo.findByActivityType_Id(typeId).orElseThrow(() -> new ValidationException("No emission factor configured"));

//         log.setUser(user);
//         log.setActivityType(type);
//         log.setEstimatedEmission(log.getQuantity() * factor.getFactorValue());
//         return logRepo.save(log);
//     }

//     public List<ActivityLog> getLogsByUser(Long userId) { return logRepo.findByUser_Id(userId); }
//     public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end) { return logRepo.findByUser_IdAndActivityDateBetween(userId, start, end); }
// }

// package com.example.demo.service;

// import com.example.demo.entity.ActivityLog;
// import java.time.LocalDate;
// import java.util.List;

// public interface ActivityLogService {
//     ActivityLog logActivity(Long userId, Long typeId, ActivityLog log);
//     List<ActivityLog> getLogsByUser(Long userId);
//     List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end);
//     ActivityLog getLog(Long id);
// }

package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import java.util.List;

public interface ActivityLogService {
    ActivityLog saveLog(Long userId, Long typeId, ActivityLog log);
    List<ActivityLog> getLogsByUser(Long userId);
}