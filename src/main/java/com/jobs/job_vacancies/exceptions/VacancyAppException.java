package com.jobs.job_vacancies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class VacancyAppException extends RuntimeException{
   public ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
      problemDetail.setTitle("VacancyApp internal server error");
      return problemDetail;
   }
}
