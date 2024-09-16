package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.controllers.dtos.VacancyDTO;
import com.jobs.job_vacancies.entities.Vacancy;
import com.jobs.job_vacancies.entities.registeredPerson.Recruiter;
import com.jobs.job_vacancies.repositories.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService {
    @Autowired
    private RecruiterRepository repository;

    @Autowired
    private VacancyService vacancyService;

    public final Vacancy createVacancy(VacancyDTO dto) {
        this.repository.findByNameOrEmailOrEnterprise(dto.recruiter().getEmail())
    }

    public final Recruiter
}
