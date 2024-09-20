package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.controllers.dtos.VacancyDTO;
import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.entities.registeredPerson.Recruiter;
import com.jobs.job_vacancies.exceptions.PersonNotFoundException;
import com.jobs.job_vacancies.exceptions.VacancyAlreadyExistException;
import com.jobs.job_vacancies.repositories.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {
    @Autowired
    private RecruiterRepository repository;
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private RegisteredPersonService registeredPersonService;

    public final Recruiter createVacancy(VacancyDTO dto) {
        Recruiter optionalRecruiter = this.findRecruiterByEmail(dto.recruiterEmail());
        boolean recruiterExist = optionalRecruiter != null;

        if(!recruiterExist) {
            throw new PersonNotFoundException();
        }

        Vacancy vacancy = this.vacancyService.findByDescription(dto.description());
        boolean vacancyExist = vacancy != null;

        if(!vacancyExist) {
            Vacancy newVacancy = this.vacancyService.createVacancy(dto, optionalRecruiter);
            optionalRecruiter.addVacancy(newVacancy);
            this.registeredPersonService.saveRegisteredPerson(optionalRecruiter);
            return optionalRecruiter;
        } else {
            throw new VacancyAlreadyExistException();
        }
    }

    public final List<Recruiter> findAllRecruiters() {
        return this.repository.findAll();
    }

    public final Recruiter findRecruiterByEmail(String email) {
        return this.repository.findByEmail(email).orElse(null);
    }
}
