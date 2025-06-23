package com.example.springboot.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WorkoutSet {

    public enum WorkoutSetType {
        TIME,
        DISTANCE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Integer repetitions;

    // Deprecated: use valueTime/valueDistance instead
    // @Column(nullable = false)
    // private Integer value;

    // Deprecated: use restTime/restDistance instead
    // @Column(nullable = false)
    // private Integer rest;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkoutSetType type; // TIME or DISTANCE for value

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkoutSetType restType; // TIME or DISTANCE for rest

    // Value fields
    @Column(nullable = true)
    private Integer valueTime; // in seconds, if type == TIME

    @Column(nullable = true)
    private Integer valueDistance; // in meters, if type == DISTANCE

    // Rest fields
    @Column(nullable = true)
    private Integer restTime; // in seconds, if type == TIME

    @Column(nullable = true)
    private Integer restDistance; // in meters, if type == DISTANCE

    @Column(nullable = true)
    private String description;

    public WorkoutSet(Integer repetitions, WorkoutSetType type, WorkoutSetType restType, Integer valueTime,
            Integer valueDistance, Integer restTime, Integer restDistance, String description) {
        this.repetitions = repetitions;
        this.type = type;
        this.restType = restType;
        this.valueTime = valueTime;
        this.valueDistance = valueDistance;
        this.restTime = restTime;
        this.restDistance = restDistance;
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;
}