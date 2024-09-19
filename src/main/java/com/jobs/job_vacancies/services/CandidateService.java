package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.controllers.dtos.CandidateVacancyApplyDTO;
import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.entities.registeredPerson.Candidate;
import com.jobs.job_vacancies.entities.registeredPerson.RegisterType;
import com.jobs.job_vacancies.entities.registeredPerson.RegisteredPerson;
import com.jobs.job_vacancies.entities.vacancyApplication.Status;
import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import com.jobs.job_vacancies.exceptions.IllegalRecruiterAccessException;
import com.jobs.job_vacancies.exceptions.MismatchRegisteredPersonDataException;
import com.jobs.job_vacancies.exceptions.VacancyDoesNotExistException;
import com.jobs.job_vacancies.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {
   @Autowired
   private CandidateRepository repository;
   @Autowired
   private VacancyService vacancyService;
   @Autowired
   private RegisteredPersonService registeredPersonService;
   @Autowired
   private VacancyApplicationService vacancyApplicationService;

   public final Candidate vacancyApply(CandidateVacancyApplyDTO dto) {
      this.validateApply(dto);

      Vacancy vacancy = this.vacancyService.findByDescription(dto.vacancyDescription());
      Candidate candidateApplying = this.findCandidateByEmail(dto.candidateEmail());
      VacancyApplication vacancyApplication = this.vacancyApplicationService.createVacancyApplication(candidateApplying, vacancy, Status.PENDING);
      candidateApplying.vacancyApply(vacancy, vacancyApplication);
      vacancy.receiverVacancyApply(candidateApplying, vacancyApplication);
      return candidateApplying;
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
      boolean vacancyIsPresent = this.vacancyService.vacancyIsPresent(dto.vacancyDescription());

      if(!vacancyIsPresent) {
         throw new VacancyDoesNotExistException();
      }

      RegisterType registerType = dto.registerType().get();
      if(!isCandidate(registerType)) {
         throw new IllegalRecruiterAccessException();
      }

      Candidate candidate = this.findCandidateByEmail(dto.candidateEmail());

      if(candidate == null) {
         throw new MismatchRegisteredPersonDataException();
      }
   }

   public final List<Candidate> findAllCandidates() {
      return this.repository.findAll();
   }
}
