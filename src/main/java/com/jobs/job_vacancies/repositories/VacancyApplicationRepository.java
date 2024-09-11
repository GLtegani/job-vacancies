package com.jobs.job_vacancies.repositories;

import com.jobs.job_vacancies.entities.vacancyApplication.VacancyApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VacancyApplicationRepository extends JpaRepository<VacancyApplication, UUID> {
}
