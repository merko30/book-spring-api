package com.example.springboot.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
import com.example.springboot.entity.User;
import com.example.springboot.entity.Workout;
import com.example.springboot.entity.WorkoutSet;
import com.example.springboot.mapper.WorkoutMapper;
import com.example.springboot.mapper.WorkoutSetMapper;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.repository.WorkoutRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

	private final WorkoutRepository workoutRepository;
	private final WorkoutMapper workoutMapper;
	private final WorkoutSetMapper workoutSetMapper;
	private final UserRepository userRepository;

	public WorkoutController(WorkoutRepository workoutRepository,
			WorkoutMapper workoutMapper, UserRepository userRepository,
			WorkoutSetMapper workoutSetMapper) {
		this.workoutRepository = workoutRepository;
		this.workoutMapper = workoutMapper;
		this.userRepository = userRepository;
		this.workoutSetMapper = workoutSetMapper;
	}

	@PostMapping()
	public ResponseEntity<Workout> createWorkout(@Valid @RequestBody CreateWorkoutDto workoutInput,
			Authentication authentication) {
		Workout workout = workoutMapper.toEntity(workoutInput);
		System.out.println("DTO title: " + workoutInput.getTitle());
		System.out.println("Mapped Workout title: " + workout.getTitle());
		List<WorkoutSet> createWorkoutSets = Optional.ofNullable(workoutInput.getSets())
				.orElse(Collections.emptyList())
				.stream()
				.map(workoutSetDto -> {
					WorkoutSet workoutSet = workoutSetMapper.toEntity(workoutSetDto);
					workoutSet.setWorkout(workout);
					return workoutSet;
				}).toList();

		workout.setSets(createWorkoutSets);
		String username = authentication.getName();
		User user = this.userRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("User not found with username: " + username));
		workout.setUser(user);
		Workout savedWorkout = workoutRepository.save(workout);

		return ResponseEntity.status(HttpStatus.CREATED).body(savedWorkout);
	}

	@GetMapping()
	public List<Workout> index() {
		return workoutRepository.findAll();
	}

	@GetMapping("/{id}")
	public Workout details(@PathVariable UUID id) {
		return workoutRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + id.toString()));
	}

	@PutMapping("/{id}")
	public Workout updateWorkout(@PathVariable UUID id, @Valid @RequestBody UpdateWorkoutDto workoutDto) {
		return workoutRepository.findById(id)
				.map(existingWorkout -> {
					workoutMapper.updateWorkoutFromDto(workoutDto, existingWorkout);
					return workoutRepository.save(existingWorkout);
				})
				.orElseThrow(() -> new RuntimeException("Workout not found with id: " + id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWorkout(@PathVariable UUID id) {
		if (!workoutRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		workoutRepository.deleteById(id);

		return ResponseEntity.noContent().build(); // 204 No Content

	}

}
