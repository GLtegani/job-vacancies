package com.jobs.job_vacancies.repositories;

import com.jobs.job_vacancies.entities.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, UUID> {
   Optional<Vacancy> findByDescription(String description);
}
