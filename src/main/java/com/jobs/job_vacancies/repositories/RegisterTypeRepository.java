package com.jobs.job_vacancies.repositories;

import com.jobs.job_vacancies.entities.registeredPerson.RegisterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterTypeRepository extends JpaRepository<RegisterType, Long> {
}
