package com.jobs.job_vacancies.entities.vacancyApplication;

import com.jobs.job_vacancies.entities.Candidate;
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
   @OneToOne
   private Candidate candidate;
   @OneToOne
   private Vacancy vacancy;
   private Status status;
}
