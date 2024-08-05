package com.learningspring.rushi.week2homework.Week2Homework.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {PasswordValidator.class})
public @interface PasswordValidation {

    String message() default "Password must contain 1 uppercase, 1 lowercase letter, 1 special character, minimum " +
            "length is 10 character";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
