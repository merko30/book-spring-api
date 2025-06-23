package com.example.springboot.validation;

import com.example.springboot.dto.CreateWorkoutSetDto;
import com.example.springboot.dto.UpdateWorkoutSetDto;
import com.example.springboot.dto.WorkoutSetDto.WorkoutSetType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WorkoutSetTypeFieldsValidator implements ConstraintValidator<ValidWorkoutSetTypeFields, Object> {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null)
            return true;
        if (value instanceof CreateWorkoutSetDto dto) {
            return validate(dto.getType(), dto.getValueTime(), dto.getValueDistance(), dto.getRestType(),
                    dto.getRestTime(), dto.getRestDistance(), context);
        } else if (value instanceof UpdateWorkoutSetDto dto) {
            return validate(dto.getType(), dto.getValueTime(), dto.getValueDistance(), dto.getRestType(),
                    dto.getRestTime(), dto.getRestDistance(), context);
        }
        return true;
    }

    private boolean validate(WorkoutSetType type, Integer valueTime, Integer valueDistance, WorkoutSetType restType,
            Integer restTime, Integer restDistance, ConstraintValidatorContext context) {
        boolean valid = true;
        context.disableDefaultConstraintViolation();
        // Validate value fields
        if (type == WorkoutSetType.TIME) {
            if (valueTime == null) {
                context.buildConstraintViolationWithTemplate("valueTime is required when type is TIME")
                        .addPropertyNode("valueTime").addConstraintViolation();
                valid = false;
            }
            if (valueDistance != null) {
                context.buildConstraintViolationWithTemplate("valueDistance must be null when type is TIME")
                        .addPropertyNode("valueDistance").addConstraintViolation();
                valid = false;
            }
        } else if (type == WorkoutSetType.DISTANCE) {
            if (valueDistance == null) {
                context.buildConstraintViolationWithTemplate("valueDistance is required when type is DISTANCE")
                        .addPropertyNode("valueDistance").addConstraintViolation();
                valid = false;
            }
            if (valueTime != null) {
                context.buildConstraintViolationWithTemplate("valueTime must be null when type is DISTANCE")
                        .addPropertyNode("valueTime").addConstraintViolation();
                valid = false;
            }
        }
        // Validate rest fields
        if (restType == WorkoutSetType.TIME) {
            if (restTime == null) {
                context.buildConstraintViolationWithTemplate("restTime is required when restType is TIME")
                        .addPropertyNode("restTime").addConstraintViolation();
                valid = false;
            }
            if (restDistance != null) {
                context.buildConstraintViolationWithTemplate("restDistance must be null when restType is TIME")
                        .addPropertyNode("restDistance").addConstraintViolation();
                valid = false;
            }
        } else if (restType == WorkoutSetType.DISTANCE) {
            if (restDistance == null) {
                context.buildConstraintViolationWithTemplate("restDistance is required when restType is DISTANCE")
                        .addPropertyNode("restDistance").addConstraintViolation();
                valid = false;
            }
            if (restTime != null) {
                context.buildConstraintViolationWithTemplate("restTime must be null when restType is DISTANCE")
                        .addPropertyNode("restTime").addConstraintViolation();
                valid = false;
            }
        }
        return valid;
    }
}
