package com.jobs.job_vacancies.entities.registeredPerson;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_register_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RegisterType {
   private Long id;
   private String description;

   @AllArgsConstructor
   public enum Enum {
      CANDIDATE(1L, "candidate"),
      RECRUITER(2L, "recruiter");

      private final Long id;
      private final String description;

      public final RegisterType get() {
         return new RegisterType(id, description);
      }
   }
}
