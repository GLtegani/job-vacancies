package com.jobs.job_vacancies.controllers.dtos;

import com.jobs.job_vacancies.annotations.ValidRegisteredPerson;
import com.jobs.job_vacancies.entities.registeredPerson.Candidate;
import com.jobs.job_vacancies.entities.registeredPerson.Recruiter;
import com.jobs.job_vacancies.entities.registeredPerson.RegisterType;
import com.jobs.job_vacancies.entities.registeredPerson.RegisteredPerson;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@ValidRegisteredPerson
public record RegisteredPersonDTO(
        @NotBlank String name,
        @NotNull  LocalDate birthDay,
        @NotNull RegisterType.Enum registerType,
        String curriculumPath,
        String enterprise
) {
    public RegisteredPerson toCandidate() {
        return new Candidate(
                this.name,
                this.birthDay,
                this.registerType.get(),
                this.curriculumPath
        );
    }

    public RegisteredPerson toRecruiter() {
        return new Recruiter(
            this.name,
            this.birthDay,
            this.registerType.get(),
            this.enterprise
        );
    }
}
