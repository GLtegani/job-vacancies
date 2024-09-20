package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.controllers.dtos.CandidateVacancyApplyDTO;
import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.entities.registeredPerson.Candidate;
import com.jobs.job_vacancies.entities.vacancyApplication.Status;
import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import com.jobs.job_vacancies.repositories.VacancyApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VacancyApplicationService {
   @Autowired
   private VacancyApplicationRepository repository;

   public final VacancyApplication createVacancyApplication(Candidate candidate, Vacancy vacancy, Status status) {
      VacancyApplication vacancyApplication = new VacancyApplication(LocalDateTime.now(), candidate, vacancy, status);
      return this.repository.save(vacancyApplication);
   }

   public final void saveVacancyApplication(VacancyApplication vacancyApplication) {
      this.repository.save(vacancyApplication);
   }
}
