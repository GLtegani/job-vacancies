package com.jobs.job_vacancies.entities.registeredPerson;

import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
   private final Set<Vacancy> appliedVacancies = new HashSet<>();
   @Setter(AccessLevel.NONE)
   @OneToMany(mappedBy = "candidate")
   private final Set<VacancyApplication> vacancyApplication = new HashSet<>();

   public Candidate(String name, LocalDate birthDay, String email, RegisterType registerType, String curriculumPath) {
      super(name, birthDay, email, registerType);
      this.curriculumPath = curriculumPath;
   }
}
