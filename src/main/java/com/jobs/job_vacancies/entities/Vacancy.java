package com.jobs.job_vacancies.entities;

import com.jobs.job_vacancies.entities.registeredPerson.Candidate;
import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_vacancy")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Vacancy {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
   private String name;
   private String description;
   private BigDecimal salary;
   @ManyToMany(mappedBy = "appliedVacancies")
   @Setter(AccessLevel.NONE)
   private Set<Candidate> candidates = new HashSet<>();
   @OneToMany(mappedBy = "vacancy")
   @Setter(AccessLevel.NONE)
   private Set<VacancyApplication> vacancyApplications = new HashSet<>();

   public Vacancy(String name, String description, BigDecimal salary) {
      this.name = name;
      this.description = description;
      this.salary = salary;
   }
}
