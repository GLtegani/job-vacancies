package com.jobs.job_vacancies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PersonNotFoundException extends VacancyAppException{
   @Override
   public ProblemDetail toProblemDetail() {
      ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

      problemDetail.setTitle("This person does not exist");

      return problemDetail;
   }
}
