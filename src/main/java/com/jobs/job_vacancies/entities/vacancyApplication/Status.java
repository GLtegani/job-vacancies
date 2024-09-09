package com.jobs.job_vacancies.entities.vacancyApplication;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
   HIRED(1L, "hired"),
   PENDING(2L, "pending"),
   DENIED(3L, "denied");

   private final Long code;
   private final String description;
}
