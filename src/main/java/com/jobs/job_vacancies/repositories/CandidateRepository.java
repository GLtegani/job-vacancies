package com.jobs.job_vacancies.repositories;

import com.jobs.job_vacancies.entities.registeredPerson.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
    Optional<Candidate> findCandidateByEmail(String email);
}
