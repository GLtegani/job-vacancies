package com.jobs.job_vacancies.entities.registeredPerson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.entities.vacancyApplication.Status;
import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import com.jobs.job_vacancies.exceptions.VacancyAlreadyAppliedException;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_candidate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Candidate extends RegisteredPerson {
   private String curriculumPath;
   @ManyToMany
   @JoinTable(
           name = "tb_vacancy_id_candidate_id",
           joinColumns = @JoinColumn(name = "candidate_id"),
           inverseJoinColumns = @JoinColumn(name = "vacancy_id")
   )
   @Setter(AccessLevel.NONE)
   @JsonIgnore
   @EqualsAndHashCode.Exclude
   private final Set<Vacancy> appliedVacancies = new HashSet<>();
   @Setter(AccessLevel.NONE)
   @OneToMany(mappedBy = "candidate")
   @JsonIgnore
   private final Set<VacancyApplication> vacancyApplication = new HashSet<>();

   public Candidate(String name, LocalDate birthDay, String email, RegisterType registerType, String curriculumPath) {
      super(name, birthDay, email, registerType);
      this.curriculumPath = curriculumPath;
   }

   public final void vacancyApply(Vacancy vacancy, VacancyApplication application) {
      if(this.getAppliedVacancies().contains(vacancy)) {
         throw new VacancyAlreadyAppliedException();
      }

      this.getAppliedVacancies().add(vacancy);
      this.getVacancyApplication().add(application);
   }
}
