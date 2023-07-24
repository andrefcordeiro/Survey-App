package com.project.surveyapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.surveyapp.entities.pk.QuestionResponsePK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_question_response")
public class QuestionResponse implements Serializable {

    @EmbeddedId
    private QuestionResponsePK id = new QuestionResponsePK();

    private Integer optionSelected;

    public QuestionResponse() {
    }

    public QuestionResponse(Question question, SurveyResponse surveyResponse, Integer optionSelected) {
        this.id.setQuestion(question);
        this.id.setSurveyResponse(surveyResponse);
        this.optionSelected = optionSelected;
    }

    @JsonIgnore
    public SurveyResponse getSurveyResponse() {
        return this.id.getSurveyResponse();
    }

    public void setSurveyResponse(SurveyResponse surveyResponse) {
        this.id.setSurveyResponse(surveyResponse);
    }

    public Question getQuestion() {
        return this.id.getQuestion();
    }

    public void setQuestion(Question question) {
        this.id.setQuestion(question);
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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
