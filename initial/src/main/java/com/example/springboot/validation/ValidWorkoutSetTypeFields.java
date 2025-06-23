package com.example.springboot.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = WorkoutSetTypeFieldsValidator.class)
@Target({ TYPE })
@Retention(RUNTIME)
public @interface ValidWorkoutSetTypeFields {
    String message() default "Invalid value/rest fields for the selected type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
