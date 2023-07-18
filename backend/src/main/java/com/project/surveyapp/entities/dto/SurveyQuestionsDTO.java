package com.project.surveyapp.entities.dto;

import com.project.surveyapp.entities.Question;

import java.time.LocalDate;
import java.util.List;

public record SurveyQuestionsDTO(String title, LocalDate timeframe, Long coordinatorId, String coordinatorUsername, List<Question> questions) {
}
