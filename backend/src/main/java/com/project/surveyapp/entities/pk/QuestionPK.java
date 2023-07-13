package com.project.surveyapp.entities.pk;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuestionPK implements Serializable {

    private Long questionId;

    private Long surveyId;

    public QuestionPK() {
    }

    public QuestionPK(Long questionId, Long surveyId) {
        this.questionId = questionId;
        this.surveyId = surveyId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionPK that = (QuestionPK) o;
        return Objects.equals(questionId, that.questionId) && Objects.equals(surveyId, that.surveyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, surveyId);
    }
}

