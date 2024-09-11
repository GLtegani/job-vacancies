package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.controllers.dtos.VacancyDTO;
import com.jobs.job_vacancies.entities.Vacancy;
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

   public final Vacancy createVacancy(VacancyDTO vacancyDTO) {
      Optional<Vacancy> vacancy = this.repository.findByDescription(vacancyDTO.description());

      if(vacancy.isPresent()) {
         throw new VacancyAlreadyExistException();
      }

      Vacancy newVacancy = new Vacancy(vacancyDTO.name(), vacancyDTO.description(), vacancyDTO.salary());
      saveVacancy(newVacancy);
      return this.repository.save(newVacancy);
   }

   public final void saveVacancy(Vacancy vacancy) {
      this.repository.save(vacancy);
   }

   public final List<Vacancy> findAllVacancies() {
      return this.repository.findAll();
   }
}
