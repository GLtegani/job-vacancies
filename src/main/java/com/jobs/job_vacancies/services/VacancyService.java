package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.controllers.dtos.VacancyDTO;
import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.entities.registeredPerson.Recruiter;
import com.jobs.job_vacancies.exceptions.PersonNotFoundException;
import com.jobs.job_vacancies.exceptions.VacancyAlreadyExistException;
import com.jobs.job_vacancies.repositories.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyService {
   @Autowired
   private VacancyRepository repository;

   public final Vacancy createVacancy(VacancyDTO vacancyDTO, Recruiter recruiter) {
      Vacancy newVacancy = new Vacancy(
              vacancyDTO.name(),
              vacancyDTO.description(),
              vacancyDTO.salary(),
              recruiter
      );
      return this.repository.save(newVacancy);
   }

   public final Vacancy findByDescription(String description) {
      return this.repository.findByDescription(description).orElse(null);
   }

   public final List<Vacancy> findAllVacancies() {
      return this.repository.findAll();
   }

   public final boolean vacancyIsPresent(String description) {
      Vacancy vacancy = this.findByDescription(description);
      if(vacancy == null) {
         return false;
      }

      return true;
   }

   public final void saveVacancy(Vacancy vacancy) {
      this.repository.save(vacancy);
   }
}
