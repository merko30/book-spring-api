package com.example.springboot.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = com.example.springboot.validation.NotBlankIfPresentValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface NotBlankIfPresent {
    String message() default "must not be blank if present";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
