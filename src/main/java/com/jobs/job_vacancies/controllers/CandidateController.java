package com.jobs.job_vacancies.controllers;

import com.jobs.job_vacancies.controllers.dtos.CandidateVacancyApplyDTO;
import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import com.jobs.job_vacancies.services.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {
   @Autowired
   private CandidateService candidateService;

   @PatchMapping(value = "/apply")
   public final ResponseEntity<VacancyApplication> vacancyApply(@RequestBody @Valid CandidateVacancyApplyDTO dto) {
      VacancyApplication vacancyApplication = this.candidateService.vacancyApply(dto);
      return ResponseEntity.ok(vacancyApplication);
   }

}
