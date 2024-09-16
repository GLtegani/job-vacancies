package com.jobs.job_vacancies.exceptions.exceptionHandler;

import com.jobs.job_vacancies.exceptions.MismatchRegisteredPersonDataException;
import com.jobs.job_vacancies.exceptions.RegisteredPersonAlreadyExistException;
import com.jobs.job_vacancies.exceptions.VacancyAppException;
import jakarta.validation.ConstraintDefinitionException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VacancyAppExceptionHandler {
   @ExceptionHandler(VacancyAppException.class)
   public final ProblemDetail handleVacancyAppException(VacancyAppException e) {
      return e.toProblemDetail();
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public final ProblemDetail handleConstraintDefinitionException(MethodArgumentNotValidException e) {
      return new MismatchRegisteredPersonDataException().toProblemDetail();
   }

   @ExceptionHandler(RegisteredPersonAlreadyExistException.class)
   public final ProblemDetail handleRegisteredPersonAlreadyExistException(RegisteredPersonAlreadyExistException e) {
      return e.toProblemDetail();
   }
}
