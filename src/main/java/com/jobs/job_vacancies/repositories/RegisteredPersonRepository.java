package com.jobs.job_vacancies.repositories;

import com.jobs.job_vacancies.entities.registeredPerson.RegisteredPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegisteredPersonRepository extends JpaRepository<RegisteredPerson, UUID> {
}
