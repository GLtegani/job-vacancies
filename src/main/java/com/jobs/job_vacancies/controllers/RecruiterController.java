package com.jobs.job_vacancies.controllers;

import com.jobs.job_vacancies.controllers.dtos.VacancyDTO;
import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.entities.registeredPerson.Recruiter;
import com.jobs.job_vacancies.services.RecruiterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/recruiter")
public class RecruiterController {
   @Autowired
   private RecruiterService recruiterService;

   @PostMapping(value = "/create-vacancy")
   public final ResponseEntity<Vacancy> createVacancy(@RequestBody @Valid VacancyDTO dto) {
      Vacancy vacancy = this.recruiterService.createVacancy(dto);
      URI uri = ServletUriComponentsBuilder
         .fromCurrentRequest()
         .path("/create-vacancy")
         .buildAndExpand(vacancy.getRecruiter())
         .toUri();
      return ResponseEntity.created(uri).body(vacancy);
   }

   @GetMapping
   public final ResponseEntity<List<Recruiter>> findAllRecruiters() {
      List<Recruiter> recruiters = this.recruiterService.findAllRecruiters();
      return ResponseEntity.ok(recruiters);
   }
}
