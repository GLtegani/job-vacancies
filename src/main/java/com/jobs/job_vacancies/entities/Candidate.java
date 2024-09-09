package com.jobs.job_vacancies.entities;

import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_candidate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
   private String name;
   private Integer age;
   private String curriculumPath;
   @ManyToMany
   @JoinTable(
           name = "tb_vacancy_id_candidate_id",
           joinColumns = @JoinColumn(name = "candidate_id"),
           inverseJoinColumns = @JoinColumn(name = "vacancy_id")
   )
   private final Set<Vacancy> appliedVacancies = new HashSet<>();
   private VacancyApplication vacancyApplication = new VacancyApplication();

   public void teste() {
      getVacancyApplication().
   }
}
