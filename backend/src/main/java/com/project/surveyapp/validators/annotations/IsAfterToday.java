package com.project.surveyapp.validators.annotations;

import com.project.surveyapp.validators.DateIsAfterTodayValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateIsAfterTodayValidator.class)
@Documented
public @interface IsAfterToday {

    String message() default "{message.key}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
