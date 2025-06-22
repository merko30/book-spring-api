package com.example.springboot.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    @OneToMany(mappedBy="workout", cascade = CascadeType.ALL, orphanRemoval = true)
    List<WorkoutSet> sets;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
    
    public Workout() {
    }
    public Workout(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public String getTitle() {
        return title;
    }
}