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

    public final Recruiter createVacancy(VacancyDTO dto) {
        Optional<Recruiter> optionalRecruiter = this.repository.findByEmail(dto.recruiterEmail());
        Vacancy vacancy = this.vacancyService.findByDescription(dto.description());
        boolean vacancyExist = vacancy != null;
        boolean recruiterExist = optionalRecruiter.isPresent();

        if(!recruiterExist) {
            throw new PersonNotFoundException();
        }

        optionalRecruiter.get().addVacancy(vacancy);

        if(vacancyExist) {
            throw new VacancyAlreadyExistException();
        }

        return optionalRecruiter.get();
    }

    public final List<Recruiter> findAllRecruiters() {
        return this.repository.findAll();
    }

}
