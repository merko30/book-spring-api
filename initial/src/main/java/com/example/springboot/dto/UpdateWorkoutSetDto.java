
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
public class UpdateWorkoutSetDto {

    @NotBlankIfPresent(message = "Value is required field")
    private Integer value;
    @NotBlankIfPresent(message = "Repetition count is required field")
    private Integer repetitions;
    @NotBlankIfPresent(message = "Rest time is required field")
    private Integer rest;
    @NotBlankIfPresent(message = "Type is required field")
    private String type;

    private String description;
}
