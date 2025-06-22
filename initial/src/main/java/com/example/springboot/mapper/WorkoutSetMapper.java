package com.example.springboot.mapper;

import com.example.springboot.dto.CreateWorkoutSetDto;
import com.example.springboot.entity.WorkoutSet;

import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkoutSetMapper {

    WorkoutSet toEntity(CreateWorkoutSetDto dto);

    void updateWorkoutFromDto(CreateWorkoutSetDto dto, @MappingTarget WorkoutSet workout);

    // @BeanMapping(nullValuePropertyMappingStrategy =
    // NullValuePropertyMappingStrategy.IGNORE)
    // void updateWorkoutSetFromDto(UpdateWorkoutSetDto dto, @MappingTarget
    // WorkoutSet workout);
}