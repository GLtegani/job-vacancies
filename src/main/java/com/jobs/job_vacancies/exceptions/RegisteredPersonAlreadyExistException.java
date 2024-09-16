package com.jobs.job_vacancies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class RegisteredPersonAlreadyExistException extends VacancyAppException{
    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Registered Person already exist");
        problemDetail.setDetail("You cannot create a Registered Person if it exist");

        return problemDetail;
    }
}
