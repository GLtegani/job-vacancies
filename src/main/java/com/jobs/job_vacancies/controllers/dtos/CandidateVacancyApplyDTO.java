package com.jobs.job_vacancies.controllers.dtos;

import jakarta.validation.constraints.NotNull;

public record CandidateVacancyApplyDTO(
   @NotNull VacancyDTO vacancyDTO,
   @NotNull RegisteredPersonDTO registeredPersonDTO
) {
}
