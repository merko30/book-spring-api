package com.example.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkoutSet{

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private Integer repetitions;

    @Column(nullable = false)
    private Integer rest;

    @Column(nullable = false)
    private String type; // e.g., "repetitions", "time"

    @Column(nullable = true)
    private String description;

    public WorkoutSet() {
    }

    public WorkoutSet(Integer repetitions, Integer rest, String type, String description) {
        this.repetitions = repetitions;
        this.rest = rest;
        this.type = type;
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name="workout_id")
    private Workout workout;
}