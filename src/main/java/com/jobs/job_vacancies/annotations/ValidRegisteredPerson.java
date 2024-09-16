package com.jobs.job_vacancies.annotations;

import com.jobs.job_vacancies.validators.RegisteredPersonValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RegisteredPersonValidator.class)
public @interface ValidRegisteredPerson {
   String message() default "Invalid RegisteredPerson data";
//   Class<?>[] groups() default {};
//   Class<? extends Payload>[] payload() default {};
}
