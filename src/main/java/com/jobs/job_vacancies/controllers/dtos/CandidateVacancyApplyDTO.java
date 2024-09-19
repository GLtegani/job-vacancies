package com.jobs.job_vacancies.controllers.dtos;

import com.jobs.job_vacancies.entities.registeredPerson.RegisterType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CandidateVacancyApplyDTO(
   @NotBlank String vacancyDescription,
   @NotNull RegisterType.Enum registerType,
   @NotBlank String candidateEmail
   ) {
}
