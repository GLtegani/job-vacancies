package com.jobs.job_vacancies.repositories;

import com.jobs.job_vacancies.entities.registeredPerson.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, UUID> {
    Optional<Recruiter> findByNameOrEmailOrEnterprise(String name, String email, String enterprise);
}
