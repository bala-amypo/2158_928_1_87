package com.example.demo.service;

import com.example.demo.entity.*;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.exception.ValidationException;

import com.example.demo.repository.*;

import java.time.LocalDate;

import java.util.List;

public class ActivityLogService {

    private final ActivityLogRepository logRepo;

    private final UserRepository userRepo;

    private final ActivityTypeRepository typeRepo;

    private final EmissionFactorRepository factorRepo;

    public ActivityLogService(ActivityLogRepository l, UserRepository u, ActivityTypeRepository t, EmissionFactorRepository f) {

        this.logRepo = l;

        this.userRepo = u;

        this.typeRepo = t;

        this.factorRepo = f;

        }

        public ActivityLog logActivity(Long userId, Long typeId, ActivityLog log) {

            if (log.getActivityDate().isAfter(LocalDate.now()))

            throw new ValidationException("cannot be in the future");

            User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));

            ActivityType type = typeRepo.findById(typeId).orElseThrow(() -> new ResourceNotFoundException("Category not found"));

            EmissionFactor factor = factorRepo.findByActivityType_Id(typeId).orElseThrow(() -> new ValidationException("No emission factor configured"));

            log.setUser(user);

            log.setActivityType(type);

            log.setEstimatedEmission(log.getQuantity() * factor.getFactorValue());

            return logRepo.save(log);

        }

        public List<ActivityLog> getLogsByUserAndDate(Long userId, LocalDate start, LocalDate end) {

            return logRepo.findByUser_IdAndActivityDateBetween(userId, start, end);

        }

}
