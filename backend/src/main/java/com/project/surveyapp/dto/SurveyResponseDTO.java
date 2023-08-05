package com.project.surveyapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class SurveyResponseDTO implements Serializable {

    private Long respondentId;

    private Long surveyId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant completionDate;

    @Valid
    @NotEmpty(message = "questionsResponses should not be empty")
    private Set<QuestionResponseDTO> questionsResponses = new LinkedHashSet<>();

    public SurveyResponseDTO() {
    }

    public SurveyResponseDTO(Long respondentId, Long surveyId, Instant completionDate) {
        this.respondentId = respondentId;
        this.surveyId = surveyId;
        this.completionDate = completionDate;
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

    public Set<QuestionResponseDTO> getQuestionsResponses() {
        return questionsResponses;
    }

    public void setQuestionsResponses(Set<QuestionResponseDTO> questionsResponses) {
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
