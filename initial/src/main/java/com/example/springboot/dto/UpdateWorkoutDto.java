package com.example.springboot.dto;

import com.example.springboot.validation.NotBlankIfPresent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWorkoutDto {

    @NotBlankIfPresent(message = "Title cannot be blank if present")
    private String title;

    private String description;

}
