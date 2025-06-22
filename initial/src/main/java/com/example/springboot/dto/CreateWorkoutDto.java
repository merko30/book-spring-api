package com.example.springboot.dto;

import com.example.springboot.entity.User;

import jakarta.validation.constraints.NotBlank;

public class CreateWorkoutDto {
    @NotBlank(message = "Title cannot be blank")
    private String title;

    private String description;

    public CreateWorkoutDto() {
    }
    public CreateWorkoutDto(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}