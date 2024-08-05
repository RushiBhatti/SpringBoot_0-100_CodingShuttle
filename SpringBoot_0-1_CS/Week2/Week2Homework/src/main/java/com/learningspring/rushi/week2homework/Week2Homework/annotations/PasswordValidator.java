package com.learningspring.rushi.week2homework.Week2Homework.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidation, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false;
        }

        boolean containsOneUppercase = password.chars().anyMatch(ch ->Character.isUpperCase(ch));
        boolean containsOneLowercase = password.chars().anyMatch(ch ->Character.isLowerCase(ch));
        boolean containsSpecialCharacter = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
        boolean minLength = (password.length() >= 10);

        return containsOneLowercase && containsOneUppercase && containsSpecialCharacter && minLength;
    }
}
