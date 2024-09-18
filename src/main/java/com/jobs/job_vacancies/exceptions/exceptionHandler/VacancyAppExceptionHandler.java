package com.jobs.job_vacancies.exceptions.exceptionHandler;

import com.jobs.job_vacancies.exceptions.*;
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

   @ExceptionHandler(PersonNotFoundException.class)
   public final ProblemDetail handlePersonDoesNotExistException(PersonNotFoundException e) {
      return e.toProblemDetail();
   }

   @ExceptionHandler(VacancyAlreadyExistException.class)
   public final ProblemDetail handleVacancyAlreadyExistException(VacancyAlreadyExistException e) {
      return e.toProblemDetail();
   }

   @ExceptionHandler(VacancyAlreadyAppliedException.class)
   public final ProblemDetail handleVacancyAlreadyAppliedException(VacancyAlreadyAppliedException e) {
      return e.toProblemDetail();
   }

   @ExceptionHandler(VacancyDoesNotExistException.class)
   public final ProblemDetail handleVacancyDoesNotExistException(VacancyDoesNotExistException e) {
      return e.toProblemDetail();
   }

   @ExceptionHandler(IllegalRecruiterAccessException.class)
   public final ProblemDetail handleIllegalAccessException(IllegalRecruiterAccessException e) {
      return e.toProblemDetail();
   }
}
