package com.example.springboot.dto;

import com.example.springboot.validation.ValidWorkoutSetTypeFields;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ValidWorkoutSetTypeFields
public class UpdateWorkoutSetDto {
    @Min(1)
    @Max(100)
    private Integer repetitions;
    @jakarta.validation.constraints.NotNull(message = "Type is required field")
    private WorkoutSetDto.WorkoutSetType type;
    @jakarta.validation.constraints.NotNull(message = "Rest type is required field")
    private WorkoutSetDto.WorkoutSetType restType;

    @Min(value = 1, message = "Time must be at least 1 second")
    @Max(value = 21600, message = "Time cannot exceed 6 hours (21600 seconds)")
    private Integer valueTime; // in seconds, if type == TIME

    @Min(value = 1, message = "Distance must be at least 1 meter")
    @Max(value = 100000, message = "Distance cannot exceed 100,000 meters (100 km)")
    private Integer valueDistance; // in meters, if type == DISTANCE

    @Min(value = 1, message = "Rest time must be at least 1 second")
    @Max(value = 21600, message = "Rest time cannot exceed 6 hours (21600 seconds)")
    private Integer restTime; // in seconds, if restType == TIME

    @Min(value = 1, message = "Rest distance must be at least 1 meter")
    @Max(value = 100000, message = "Rest distance cannot exceed 100,000 meters (100 km)")
    private Integer restDistance; // in meters, if restType == DISTANCE

    private String description;
}
