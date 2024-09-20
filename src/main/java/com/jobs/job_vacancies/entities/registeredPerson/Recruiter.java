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
@EqualsAndHashCode(callSuper = true)
public class Recruiter extends RegisteredPerson{
    private String enterprise;
    @OneToMany(mappedBy = "recruiter")
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private final Set<Vacancy> vacancies = new HashSet<>();

    public Recruiter(String name, LocalDate birthDay, String email, RegisterType registerType, String enterprise) {
        super(name, birthDay, email, registerType);
        this.enterprise = enterprise;
    }

    public final void addVacancy(Vacancy vacancy) {
        this.vacancies.add(vacancy);
    }
}
