package com.jobs.job_vacancies.controllers;

import com.jobs.job_vacancies.controllers.dtos.VacancyDTO;
import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.services.VacancyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vacancies")
public class VacancyController {
   @Autowired
   private VacancyService vacancyService;

   @PostMapping
   public final ResponseEntity<Vacancy> createVacancy(@RequestBody @Valid VacancyDTO vacancyDTO) {
      Vacancy vacancy = this.vacancyService.createVacancy(vacancyDTO);
      return ResponseEntity.ok(vacancy);
   }

   @GetMapping
   public final ResponseEntity<List<Vacancy>> findAllVacancies() {
      List<Vacancy> vacancies = this.vacancyService.findAllVacancies();
      return ResponseEntity.ok(vacancies);
   }
}
