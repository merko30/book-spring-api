package com.example.springboot.dto;

import com.example.springboot.validation.NotBlankIfPresent;

public class UpdateWorkoutDto {

    @NotBlankIfPresent(message = "Title cannot be blank if present")
    private String title;
    
    
    private String description;

    public UpdateWorkoutDto() {}

    public UpdateWorkoutDto(String title, String description) {
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
