package com.jobs.job_vacancies.entities.registeredPerson;

import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_candidate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode("id")
public class Candidate {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
   private String name;
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
}
