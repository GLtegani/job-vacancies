package com.jobs.job_vacancies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class VacancyAlreadyExistException extends VacancyAppException{
   @Override
   public final ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
      problemDetail.setTitle("Vacancy already exist");
      problemDetail.setDetail("You cannot create a vacancy if it already exist");
      return problemDetail;
   }
}
