package com.example.springboot.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkoutDto {
    @NotBlank(message = "Title cannot be blank")
    private String title;

    private String description;

    @Valid
    private List<CreateWorkoutSetDto> sets;

}