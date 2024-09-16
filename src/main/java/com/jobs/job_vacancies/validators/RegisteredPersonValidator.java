package com.jobs.job_vacancies.validators;

import com.jobs.job_vacancies.annotations.ValidRegisteredPerson;
import com.jobs.job_vacancies.controllers.dtos.RegisteredPersonDTO;
import com.jobs.job_vacancies.entities.registeredPerson.RegisterType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RegisteredPersonValidator implements ConstraintValidator<ValidRegisteredPerson, RegisteredPersonDTO> {

   @Override
   public boolean isValid(RegisteredPersonDTO dto, ConstraintValidatorContext context) {
      boolean isValid = true;

      if (dto.registerType() == RegisterType.Enum.CANDIDATE) {
         // Se for um Candidato, o curriculumPath não pode ser nulo ou vazio
         if (dto.curriculumPath() == null || dto.curriculumPath().isBlank()) {
            isValid = false;
            context.buildConstraintViolationWithTemplate("CurriculumPath is required for Candidate")
               .addPropertyNode("curriculumPath").addConstraintViolation();
         }
      } else if (dto.registerType() == RegisterType.Enum.RECRUITER) {
         // Se for um Recrutador, a enterprise não pode ser nula ou vazia
         if (dto.enterprise() == null || dto.enterprise().isBlank()) {
            isValid = false;
            context.buildConstraintViolationWithTemplate("Enterprise is required for Recruiter")
               .addPropertyNode("enterprise").addConstraintViolation();
         }
      }

      if (!isValid) {
         context.disableDefaultConstraintViolation();
      }

      return isValid;
   }
}
