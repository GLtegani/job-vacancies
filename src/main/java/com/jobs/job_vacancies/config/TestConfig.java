package com.jobs.job_vacancies.config;

import com.jobs.job_vacancies.entities.registeredPerson.RegisterType;
import com.jobs.job_vacancies.repositories.RegisterTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private RegisterTypeRepository registerTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(RegisterType.Enum.values())
                .forEach(registerType -> this.registerTypeRepository.save(registerType.get())
        );
    }
}
