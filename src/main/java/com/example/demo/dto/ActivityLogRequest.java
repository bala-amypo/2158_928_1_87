package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ActivityLogRequest {
    private Double quantity;
    private LocalDate activityDate;
}