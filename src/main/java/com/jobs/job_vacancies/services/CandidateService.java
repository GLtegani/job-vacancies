package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.controllers.dtos.CandidateVacancyApplyDTO;
import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.entities.registeredPerson.Candidate;
import com.jobs.job_vacancies.entities.registeredPerson.RegisterType;
import com.jobs.job_vacancies.entities.registeredPerson.RegisteredPerson;
import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import com.jobs.job_vacancies.exceptions.IllegalRecruiterAccessException;
import com.jobs.job_vacancies.exceptions.VacancyDoesNotExistException;
import com.jobs.job_vacancies.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateService {
   @Autowired
   private CandidateRepository repository;
   @Autowired
   private VacancyService vacancyService;
   @Autowired
   private RegisteredPersonService registeredPersonService;

   public final VacancyApplication vacancyApply(CandidateVacancyApplyDTO dto) {
      this.validateApply(dto);

      String vacancyDescription = dto.vacancyDTO().description();
      Vacancy vacancy = this.vacancyService.findByDescription(vacancyDescription);
      Candidate candidateApplying = this.findCandidateByEmail(dto.registeredPersonDTO().email());
      VacancyApplication vacancyApplication = candidateApplying.vacancyApply(vacancy);
      vacancy.receiverVacancyApply(candidateApplying, vacancyApplication);
      return vacancyApplication;
   }

   public final boolean isCandidate(RegisterType registerType) {
      RegisteredPerson candidate = this.registeredPersonService.findByRegisteredType(registerType);
      boolean personIsCandidate = candidate.getRegisterType().getDescription().equals("candidate");
      if(personIsCandidate) {
         return true;
      }
      return false;
   }

   public final Candidate findCandidateByEmail(String email) {
      Optional<Candidate> optionalCandidate = this.repository.findCandidateByEmail(email);
      return optionalCandidate.orElse(null);
   }

   private void validateApply(CandidateVacancyApplyDTO dto) {
      boolean vacancyIsPresent = this.vacancyService.vacancyIsPresent(dto.vacancyDTO());

      if(!vacancyIsPresent) {
         throw new VacancyDoesNotExistException();
      }

      RegisterType registerType = dto.registeredPersonDTO().registerType().get();
      if(!isCandidate(registerType)) {
         throw new IllegalRecruiterAccessException();
      }
   }
}
