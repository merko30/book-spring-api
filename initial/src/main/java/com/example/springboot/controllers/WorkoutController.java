package com.example.springboot.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.CreateWorkoutDto;
import com.example.springboot.dto.UpdateWorkoutDto;
import com.example.springboot.entity.Workout;
import com.example.springboot.mapper.WorkoutMapper;
import com.example.springboot.repository.WorkoutRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

	private final WorkoutRepository workoutRepository;
	private final WorkoutMapper workoutMapper;

	public WorkoutController(WorkoutRepository workoutRepository,
			WorkoutMapper workoutMapper) {
		this.workoutRepository = workoutRepository;
		this.workoutMapper = workoutMapper;
	}

	@PostMapping()
	public Workout createWorkout(@Valid @RequestBody CreateWorkoutDto workoutInput) {
		Workout workout = workoutMapper.toEntity(workoutInput);
		return workoutRepository.save(workout);
	}

	@GetMapping("/workouts")
	public List<Workout> index() {
		return workoutRepository.findAll();
	}

	@GetMapping("/{id}")
	public Workout details(@PathVariable UUID id) {
		return workoutRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + id));
	}

	@PutMapping("/workouts/{id}")
	public Workout updateWorkout(@PathVariable UUID id, @Valid @RequestBody UpdateWorkoutDto workoutDto){
		return workoutRepository.findById(id)
				.map(existingWorkout -> {
					workoutMapper.updateWorkoutFromDto(workoutDto, existingWorkout);
					return workoutRepository.save(existingWorkout);
				})
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + id));
	}

	@DeleteMapping("/workouts/{id}")
	public void deleteWorkout(@PathVariable UUID id) {
		workoutRepository.deleteById(id);
	}



}
