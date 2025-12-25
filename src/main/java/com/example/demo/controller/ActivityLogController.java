// package com.example.demo.controller;
// import com.example.demo.dto.ActivityLogRequest;
// import com.example.demo.entity.ActivityLog;
// import com.example.demo.service.ActivityLogService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;
// import java.time.LocalDate;
// import java.util.List;

// @RestController @RequestMapping("/api/logs")
// @Tag(name = "ActivityLogController")
// public class ActivityLogController {
//     private final ActivityLogService logService;
//     public ActivityLogController(ActivityLogService logService) { this.logService = logService; }

//     @PostMapping("/{userId}/{typeId}")
//     public ActivityLog log(@PathVariable Long userId, @PathVariable Long typeId, @RequestBody ActivityLogRequest req) {
//         ActivityLog log = new ActivityLog();
//         log.setQuantity(req.getQuantity());
//         log.setActivityDate(req.getActivityDate());
//         return logService.logActivity(userId, typeId, log);
//     }

//     @GetMapping("/user/{userId}")
//     public List<ActivityLog> getByUser(@PathVariable Long userId) { return logService.getLogsByUser(userId); }

//     @GetMapping("/user/{userId}/range")
//     public List<ActivityLog> getByRange(@PathVariable Long userId, @RequestParam String start, @RequestParam String end) {
//         return logService.getLogsByUserAndDate(userId, LocalDate.parse(start), LocalDate.parse(end));
//     }
// }

package com.example.demo.controller;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class ActivityLogController {

    private final ActivityLogService logService;

    public ActivityLogController(ActivityLogService logService) {
        this.logService = logService;
    }

    @PostMapping("/{userId}/{typeId}")
    public ResponseEntity<ActivityLog> logActivity(
            @PathVariable Long userId, 
            @PathVariable Long typeId, 
            @RequestBody ActivityLogRequest request) {
        
        ActivityLog log = new ActivityLog();
        log.setQuantity(request.getQuantity());
        log.setActivityDate(request.getActivityDate());
        
        return ResponseEntity.ok(logService.logActivity(userId, typeId, log));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityLog>> getLogsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(logService.getLogsByUser(userId));
    }

    @GetMapping("/user/{userId}/range")
    public ResponseEntity<List<ActivityLog>> getLogsByRange(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        
        return ResponseEntity.ok(logService.getLogsByUserAndDate(userId, start, end));
    }
}