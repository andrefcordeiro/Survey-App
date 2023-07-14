package com.project.surveyapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.surveyapp.entities.pk.RespondedSurveyPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_responded_survey")
public class RespondedSurvey implements Serializable {

    @EmbeddedId
    private RespondedSurveyPK id = new RespondedSurveyPK();

    private Date completionDate;

    @OneToMany(mappedBy = "id.respondedSurvey", cascade = CascadeType.ALL)
    private Set<RespondedQuestion> respondedQuestions = new HashSet<>();

    public RespondedSurvey() {
    }

    public RespondedSurvey(Respondent respondent, Survey survey, Date completionDate, Set<RespondedQuestion> respondedQuestions) {
        this.id.setRespondent(respondent);
        this.id.setSurvey(survey);
        this.completionDate = completionDate;
        this.respondedQuestions = respondedQuestions;
    }

    @JsonIgnore
    public Respondent getRespondent() {
        return this.id.getRespondent();
    }

    public void setRespondent(Respondent respondent) {
        this.id.setRespondent(respondent);
    }

    public Survey getSurvey() {
        return this.id.getSurvey();
    }

    public void setSurvey(Survey survey) {
        this.id.setSurvey(survey);
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Set<RespondedQuestion> getRespondedQuestions() {
        return respondedQuestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespondedSurvey that = (RespondedSurvey) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
