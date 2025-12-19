package com.example.demo.controller;

import com.example.demo.dto.ActivityLogRequest;

import com.example.demo.entity.ActivityLog;

import com.example.demo.service.ActivityLogService;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;

@RestController

@RequestMapping("/logs")

public class ActivityLogController {

    private final ActivityLogService service;

    public ActivityLogController(ActivityLogService service) {

        this.service = service;

    }

    @PostMapping("/{userId}/{typeId}")

    public ActivityLog log(@PathVariable Long userId,
    
    @PathVariable Long typeId,

    @RequestBody ActivityLogRequest request) {

        ActivityLog log = new ActivityLog();

        log.setQuantity(request.quantity);

        log.setActivityDate(request.activityDate);

        return service.logActivity(userId, typeId, log);

    }

    @GetMapping("/{userId}")

    public List<ActivityLog> getLogs(@PathVariable Long userId,
    
    @RequestParam LocalDate start,

    @RequestParam LocalDate end) {

        return service.getLogsByUserAndDate(userId, start, end);

    }

}
   