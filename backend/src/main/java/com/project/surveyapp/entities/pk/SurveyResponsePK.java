package com.project.surveyapp.entities.pk;

import com.project.surveyapp.entities.Respondent;
import com.project.surveyapp.entities.Survey;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SurveyResponsePK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "respondent_id")
    private Respondent respondent;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    public SurveyResponsePK() {
    }

    public SurveyResponsePK(Respondent respondent, Survey survey) {
        this.respondent = respondent;
        this.survey = survey;
    }

    public Respondent getRespondent() {
        return respondent;
    }

    public void setRespondent(Respondent respondent) {
        this.respondent = respondent;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyResponsePK that = (SurveyResponsePK) o;
        return Objects.equals(respondent, that.respondent) && Objects.equals(survey, that.survey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(respondent, survey);
    }
}
