package com.example.demo.controller;
import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController @RequestMapping("/api/logs")
@Tag(name = "ActivityLogController")
public class ActivityLogController {
    private final ActivityLogService logService;
    public ActivityLogController(ActivityLogService logService) { this.logService = logService; }

    @PostMapping("/{userId}/{typeId}")
    public ActivityLog log(@PathVariable Long userId, @PathVariable Long typeId, @RequestBody ActivityLogRequest req) {
        ActivityLog log = new ActivityLog();
        log.setQuantity(req.getQuantity());
        log.setActivityDate(req.getActivityDate());
        return logService.logActivity(userId, typeId, log);
    }

    @GetMapping("/user/{userId}")
    public List<ActivityLog> getByUser(@PathVariable Long userId) { return logService.getLogsByUser(userId); }

    @GetMapping("/user/{userId}/range")
    public List<ActivityLog> getByRange(@PathVariable Long userId, @RequestParam String start, @RequestParam String end) {
        return logService.getLogsByUserAndDate(userId, LocalDate.parse(start), LocalDate.parse(end));
    }
}