package com.jobs.job_vacancies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class VacancyDoesNotExistException extends VacancyAppException{
   @Override
   public final ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

      problemDetail.setTitle("Vacancy does not exist");
      problemDetail.setDetail("You cannot apply to a vacancy that does not exist");

      return problemDetail;
   }
}
