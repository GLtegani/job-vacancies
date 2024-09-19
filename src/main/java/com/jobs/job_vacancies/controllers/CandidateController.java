package com.jobs.job_vacancies.controllers;

import com.jobs.job_vacancies.controllers.dtos.CandidateVacancyApplyDTO;
import com.jobs.job_vacancies.entities.registeredPerson.Candidate;
import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import com.jobs.job_vacancies.services.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {
   @Autowired
   private CandidateService candidateService;

   @PatchMapping(value = "/apply")
   public final ResponseEntity<Candidate> vacancyApply(@RequestBody @Valid CandidateVacancyApplyDTO dto) {
      Candidate candidate = this.candidateService.vacancyApply(dto);
      return ResponseEntity.ok(candidate);
   }

   @GetMapping
   public final ResponseEntity<List<Candidate>> findAllCandidates() {
      List<Candidate> candidates = this.candidateService.findAllCandidates();
      return ResponseEntity.ok(candidates);
   }

}
