package com.jobs.job_vacancies.entities.registeredPerson;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_registered_person")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(of = "id")
public class RegisteredPerson {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;
   private String name;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   private LocalDate birthDay;
   @ManyToOne
   @JoinColumn(name = "register_type_id")
   private RegisterType registerType;

   public RegisteredPerson(String name, LocalDate birthDay, RegisterType registerType) {
      this.name = name;
      this.birthDay = birthDay;
      this.registerType = registerType;
   }
}
