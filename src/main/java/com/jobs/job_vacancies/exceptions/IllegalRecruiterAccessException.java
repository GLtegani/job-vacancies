package com.jobs.job_vacancies.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class IllegalRecruiterAccessException extends VacancyAppException{
    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Illegal recruiter access");
        problemDetail.setDetail("Recruiter's cannot apply to vacancy");

        return problemDetail;
    }
}
