package com.jobs.job_vacancies.entities.registeredPerson;

import com.jobs.job_vacancies.entities.Vacancy;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_recruiter")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Recruiter extends RegisteredPerson{
    private String enterprise;
    @OneToMany(mappedBy = "recruiter")
    @Setter(AccessLevel.NONE)
    private final Set<Vacancy> vacancies = new HashSet<>();

    public Recruiter(String name, LocalDate birthDay, RegisterType registerType, String enterprise) {
        super(name, birthDay, registerType);
        this.enterprise = enterprise;
    }
}
