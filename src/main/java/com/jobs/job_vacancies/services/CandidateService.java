package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.controllers.dtos.CandidateVacancyApplyDTO;
import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import com.jobs.job_vacancies.exceptions.VacancyDoesNotExistException;
import com.jobs.job_vacancies.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
   @Autowired
   private CandidateRepository repository;
   @Autowired
   private VacancyService vacancyService;

   public final VacancyApplication vacancyApply(CandidateVacancyApplyDTO dto) {
      boolean vacancyIsPresent = this.vacancyService.vacancyIsPresent(dto.vacancyDTO());

      if(!vacancyIsPresent) {
         throw new VacancyDoesNotExistException();
      }

      if
   }
}
