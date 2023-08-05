package com.project.surveyapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class QuestionResponseDTO {

    @JsonIgnore
    private Long respondentId;

    @JsonIgnore
    private Long surveyId;

    @NotNull(message = "questionId should not be empty")
    private Long questionId;

    @NotNull(message = "optionSelected should not be empty")
    @Min(value = 1, message = "optionSelected should be between 1 and 5")
    @Max(value = 5, message = "optionSelected should be between 1 and 5")
    private Integer optionSelected;

    public QuestionResponseDTO() {
    }

    public QuestionResponseDTO(Long questionId, Integer optionSelected) {
        this.questionId = questionId;
        this.optionSelected = optionSelected;
    }

    public Long getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(Long respondentId) {
        this.respondentId = respondentId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getOptionSelected() {
        return optionSelected;
    }

    public void setOptionSelected(Integer optionSelected) {
        this.optionSelected = optionSelected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionResponseDTO that = (QuestionResponseDTO) o;
        return Objects.equals(respondentId, that.respondentId) && Objects.equals(surveyId, that.surveyId) && Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(respondentId, surveyId, questionId);
    }
}
