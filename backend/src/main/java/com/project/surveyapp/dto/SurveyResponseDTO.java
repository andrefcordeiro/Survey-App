package com.project.surveyapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class SurveyResponseDTO implements Serializable {

    @NotNull(message = "respondentId should not be empty")
    private Long respondentId;

    private Long surveyId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant completionDate;

    @Valid
    @NotEmpty(message = "questionsResponses should not be empty")
    private Set<QuestionResponse> questionsResponses = new LinkedHashSet<>();

    public SurveyResponseDTO() {
    }

    public static class QuestionResponse {

        @NotNull(message = "questionId should not be empty")
        private Long questionId;

        @NotNull(message = "optionSelected should not be empty")
        @Min(value = 1, message = "optionSelected should be between 1 and 5")
        @Max(value = 5, message = "optionSelected should be between 1 and 5")
        private Integer optionSelected;

        public QuestionResponse() {
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
            QuestionResponse that = (QuestionResponse) o;
            return Objects.equals(questionId, that.questionId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(questionId);
        }
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

    public Instant getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Instant completionDate) {
        this.completionDate = completionDate;
    }

    public Set<QuestionResponse> getQuestionsResponses() {
        return questionsResponses;
    }

    public void setQuestionsResponses(Set<QuestionResponse> questionsResponses) {
        this.questionsResponses = questionsResponses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyResponseDTO that = (SurveyResponseDTO) o;
        return Objects.equals(respondentId, that.respondentId) && Objects.equals(surveyId, that.surveyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(respondentId, surveyId);
    }
}
