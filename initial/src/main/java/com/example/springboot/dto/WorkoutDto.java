package com.example.springboot.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Workout DTO for API responses (no user workouts inside user to avoid recursion)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDto {
    private UUID id;
    private String title;
    private String description;
    private List<WorkoutSetDto> sets; // You can create a DTO for WorkoutSet similarly
    private UserDto user; // To avoid full user with workouts, create a lightweight user DTO below
}
