package com.jobs.job_vacancies.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_vacancy")
@NoArgsConstructor
@AllArgsConstructor
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
   @ManyToMany(mappedBy = "jobApplications")
   private Set<Candidate> candidates;
}
