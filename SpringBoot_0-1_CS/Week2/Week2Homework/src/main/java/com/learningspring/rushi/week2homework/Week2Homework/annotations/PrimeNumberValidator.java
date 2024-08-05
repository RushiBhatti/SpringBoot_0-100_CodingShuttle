package com.learningspring.rushi.week2homework.Week2Homework.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation, Integer> {

    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext context) {
        if(number == null){
            return false;
        }
        if(number == 2){
            return true;
        }
        for(int i=2; i<number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
