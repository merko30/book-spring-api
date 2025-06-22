package com.example.springboot.mapper;

import com.example.springboot.dto.CreateWorkoutDto;
import com.example.springboot.dto.UpdateWorkoutDto;
import com.example.springboot.entity.Workout;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkoutMapper {

    @Mapping(source = "title", target = "title")
    Workout toEntity(CreateWorkoutDto dto);

    void updateWorkoutFromDto(CreateWorkoutDto dto, @MappingTarget Workout workout);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateWorkoutFromDto(UpdateWorkoutDto dto, @MappingTarget Workout workout);
}