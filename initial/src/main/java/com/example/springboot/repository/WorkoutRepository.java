package com.example.springboot.repository;

import com.example.springboot.entity.Workout;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, UUID> {

    @EntityGraph(attributePaths = { "sets", "user" })
    List<Workout> findAll();

    // Custom query method to find workouts by title
    List<Workout> findByTitle(String title);
}