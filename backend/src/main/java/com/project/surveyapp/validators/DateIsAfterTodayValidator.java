package com.project.surveyapp.validators;

import com.project.surveyapp.validators.annotations.IsAfterToday;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DateIsAfterTodayValidator implements ConstraintValidator<IsAfterToday, LocalDate> {

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate today = LocalDate.now();
        return date.isAfter(today);
    }
}