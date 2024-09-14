package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.controllers.dtos.RegisteredPersonDTO;
import com.jobs.job_vacancies.entities.registeredPerson.Candidate;
import com.jobs.job_vacancies.entities.registeredPerson.Recruiter;
import com.jobs.job_vacancies.entities.registeredPerson.RegisteredPerson;
import com.jobs.job_vacancies.repositories.RegisteredPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisteredPersonService {
    @Autowired
    private RegisteredPersonRepository repository;

    public final RegisteredPerson createRegisteredPerson(RegisteredPersonDTO dto) {
        return this.repository.save(dto.toRecruiter());
    }
}
