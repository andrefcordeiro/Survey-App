package com.project.surveyapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.surveyapp.entities.pk.RespondedQuestionPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_responded_question")
public class RespondedQuestion implements Serializable {

    @EmbeddedId
    private RespondedQuestionPK id = new RespondedQuestionPK();

    private Integer optionSelected;

    public RespondedQuestion() {
    }

    public RespondedQuestion(Question question, Integer optionSelected) {
        this.id.setQuestion(question);
        this.optionSelected = optionSelected;
    }

    @JsonIgnore
    public RespondedSurvey getRespondedSurvey() {
        return this.id.getRespondedSurvey();
    }

    public void setRespondedSurvey(RespondedSurvey respondedSurvey) {
        this.id.setRespondedSurvey(respondedSurvey);
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
        RespondedQuestion that = (RespondedQuestion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
