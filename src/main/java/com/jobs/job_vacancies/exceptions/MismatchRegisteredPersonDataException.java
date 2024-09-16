package com.jobs.job_vacancies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class MismatchRegisteredPersonDataException extends VacancyAppException{
    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Mismatch arguments");
        return problemDetail;
    }
}
