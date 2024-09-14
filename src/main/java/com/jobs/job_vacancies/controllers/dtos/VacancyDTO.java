package com.jobs.job_vacancies.controllers.dtos;

import com.jobs.job_vacancies.entities.registeredPerson.Recruiter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record VacancyDTO(
        @NotBlank String name,
        @NotBlank String description,
        @NotNull BigDecimal salary,
        @NotNull Recruiter recruiter
        ) {
}
