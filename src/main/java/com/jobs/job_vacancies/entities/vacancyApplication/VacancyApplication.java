package com.jobs.job_vacancies.entities.vacancyApplication;

import com.jobs.job_vacancies.entities.registeredPerson.Candidate;
import com.jobs.job_vacancies.entities.Vacancy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_vacancyApplication")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VacancyApplication {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
   private LocalDate applicationDate;
   @ManyToOne
   @JoinColumn(name = "candidate_id")
   private Candidate candidate;
   @ManyToOne
   @JoinColumn(name = "vacancy_id")
   private Vacancy vacancy;
   private Status status;
}
