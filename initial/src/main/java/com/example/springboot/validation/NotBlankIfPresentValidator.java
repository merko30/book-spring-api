package com.example.springboot.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankIfPresentValidator implements ConstraintValidator<NotBlankIfPresent, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // If value is null, skip validation (valid)
        if (value == null) {
            return true;
        }
        // If value is present, it must not be blank
        return !value.trim().isEmpty();
    }
}
