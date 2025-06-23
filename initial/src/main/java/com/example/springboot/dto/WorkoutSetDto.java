package com.example.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutSetDto {
    private Integer repetitions;
    private WorkoutSetType type;
    private WorkoutSetType restType;
    private Integer valueTime; // in seconds, if type == TIME
    private Integer valueDistance; // in meters, if type == DISTANCE
    private Integer restTime; // in seconds, if restType == TIME
    private Integer restDistance; // in meters, if restType == DISTANCE
    private String description;

    public enum WorkoutSetType {
        TIME,
        DISTANCE
    }
}
