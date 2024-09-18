package com.jobs.job_vacancies.services;

import com.jobs.job_vacancies.entities.registeredPerson.RegisterType;
import com.jobs.job_vacancies.repositories.RegisterTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RegisterTypeService {
   @Autowired
   private RegisterTypeRepository repository;

   public final void createRegisterType() {
       Arrays
          .stream(RegisterType.Enum.values())
          .forEach(registerType -> this.repository.save(registerType.get()));
   }

}
