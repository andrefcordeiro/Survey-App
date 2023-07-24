package com.project.surveyapp.entities.pk;

import com.project.surveyapp.entities.Question;
import com.project.surveyapp.entities.SurveyResponse;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuestionResponsePK implements Serializable {

    @ManyToOne
    @JoinColumns(
            {
                    @JoinColumn(name = "respondent_id"),
                    @JoinColumn(name = "survey_id")
            }
    )
    private SurveyResponse surveyResponse;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public SurveyResponse getSurveyResponse() {
        return surveyResponse;
    }

    public void setSurveyResponse(SurveyResponse surveyResponse) {
        this.surveyResponse = surveyResponse;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionResponsePK that = (QuestionResponsePK) o;
        return Objects.equals(surveyResponse, that.surveyResponse) && Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surveyResponse, question);
    }
}
