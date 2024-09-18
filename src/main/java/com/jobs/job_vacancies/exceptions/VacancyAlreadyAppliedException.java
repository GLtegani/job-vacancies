package com.jobs.job_vacancies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class VacancyAlreadyAppliedException extends VacancyAppException{
   @Override
   public final ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

      problemDetail.setTitle("Vacancy already applied");
      problemDetail.setDetail("You cannot apply to a vacancy you have already applied for");

      return problemDetail;
   }
}
