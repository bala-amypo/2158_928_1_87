package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;

@RestController
@RequestMapping("/api/logs")
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
}
