package com.project.surveyapp.services.exceptions;

public class InvalidSurveyResponseException extends RuntimeException {
    public InvalidSurveyResponseException(String message) {
        super(message);
    }
}
