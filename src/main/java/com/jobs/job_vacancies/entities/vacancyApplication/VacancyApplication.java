package com.jobs.job_vacancies.entities.vacancyApplication;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jobs.job_vacancies.entities.registeredPerson.Candidate;
import com.jobs.job_vacancies.entities.Vacancy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
   private LocalDateTime applicationDate;
   @ManyToOne
   @JoinColumn(name = "candidate_id")
   private Candidate candidate;
   @ManyToOne
   @JoinColumn(name = "vacancy_id")
   private Vacancy vacancy;
   private Status status;
}
