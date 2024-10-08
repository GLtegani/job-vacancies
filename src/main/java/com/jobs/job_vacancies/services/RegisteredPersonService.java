package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.controllers.dtos.RegisteredPersonDTO;
import com.jobs.job_vacancies.entities.registeredPerson.RegisterType;
import com.jobs.job_vacancies.entities.registeredPerson.RegisteredPerson;
import com.jobs.job_vacancies.exceptions.RegisteredPersonAlreadyExistException;
import com.jobs.job_vacancies.repositories.RegisteredPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisteredPersonService {
    @Autowired
    private RegisteredPersonRepository repository;

    public final RegisteredPerson createRegisteredPerson(RegisteredPersonDTO dto) {
        boolean isRecruiter = dto.registerType().get().getDescription().equals("recruiter");
        RegisteredPerson person;
        if(isRecruiter) {
            person = dto.toRecruiter();
        } else {
            person = dto.toCandidate();
        }

        Optional<RegisteredPerson> personExist = this.repository.findByEmail(person.getEmail());

        if(personExist.isPresent()) {
            throw new RegisteredPersonAlreadyExistException();
        }

        return this.repository.save(person);
    }

    public final List<RegisteredPerson> findAllRegisteredPeople() {
        return this.repository.findAll();
    }

    public final RegisteredPerson findByRegisteredType(RegisterType registerType) {
        Optional<RegisteredPerson> optionalRegisterType = this.repository.findByRegisterType(registerType);
        return optionalRegisterType.orElse(null);
    }

    public final void saveRegisteredPerson(RegisteredPerson registeredPerson) {
        this.repository.save(registeredPerson);
    }

}
