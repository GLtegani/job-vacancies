package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
   @Autowired
   private CandidateRepository repository;

}
