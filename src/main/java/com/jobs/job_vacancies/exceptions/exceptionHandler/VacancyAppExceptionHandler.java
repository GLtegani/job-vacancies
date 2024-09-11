package com.jobs.job_vacancies.exceptions.exceptionHandler;

import com.jobs.job_vacancies.exceptions.VacancyAppException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VacancyAppExceptionHandler {
   @ExceptionHandler(VacancyAppException.class)
   public final ProblemDetail handleVacancyAppException(VacancyAppException e) {
      return e.toProblemDetail();
   }
}
