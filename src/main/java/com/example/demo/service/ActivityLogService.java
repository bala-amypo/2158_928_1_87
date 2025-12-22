package com.example.demo.service;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.EmissionFactorRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogService {

    private final ActivityLogRepository logRepo;
    private final ActivityTypeRepository typeRepo;
    private final EmissionFactorRepository factorRepo;

    public ActivityLogService(ActivityLogRepository l,
                              ActivityTypeRepository t,
                              EmissionFactorRepository f) {
        this.logRepo = l;
        this.typeRepo = t;
        this.factorRepo = f;
    }

    public ActivityLog logActivity(Long typeId, ActivityLogRequest request) {

        ActivityType type = typeRepo.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity type not found"));

        EmissionFactor factor = factorRepo.findByActivityType_Id(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found"));

        ActivityLog log = new ActivityLog();
        log.setActivityType(type);
        log.setQuantity(request.getQuantity());
        log.setActivityDate(request.getActivityDate());
        log.setEstimatedEmission(request.getQuantity() * factor.getFactorValue());

        return logRepo.save(log);
    }
}
