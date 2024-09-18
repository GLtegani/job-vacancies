package com.jobs.job_vacancies.config;

import com.jobs.job_vacancies.entities.registeredPerson.RegisterType;
import com.jobs.job_vacancies.repositories.RegisterTypeRepository;
import com.jobs.job_vacancies.services.RegisterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private RegisterTypeService registerTypeService;

    @Override
    public void run(String... args) throws Exception {
        this.registerTypeService.createRegisterType();
    }
}
