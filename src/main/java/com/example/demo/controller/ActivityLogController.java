package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;

@RestController
@RequestMapping("/api/logs")
@Tag(name = "Activity Logs")
public class ActivityLogController {

    private final ActivityLogService service;

    public ActivityLogController(ActivityLogService service) {
        this.service = service;
    }

    @PostMapping("/{userId}/{typeId}")
    public ActivityLog log(@PathVariable Long userId,
                           @PathVariable Long typeId,
                           @RequestBody ActivityLogRequest req) {

        ActivityLog log = new ActivityLog();
        log.setQuantity(req.quantity);
        log.setActivityDate(req.activityDate);

        return service.logActivity(userId, typeId, log);
    }

    @GetMapping("/{id}")
    public ActivityLog get(@PathVariable Long id) {
        return service.getLog(id);
    }

    @GetMapping("/user/{userId}")
    public List<ActivityLog> getByDate(
            @PathVariable Long userId,
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return service.getLogsByUserAndDate(userId, start, end);
    }
}
