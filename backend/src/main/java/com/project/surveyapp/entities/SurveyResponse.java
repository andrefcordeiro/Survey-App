package com.project.surveyapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.surveyapp.entities.pk.SurveyResponsePK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_survey_response")
public class SurveyResponse implements Serializable {

    @EmbeddedId
    private SurveyResponsePK id = new SurveyResponsePK();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant completionDate;

    @OneToMany(mappedBy = "id.surveyResponse", cascade = CascadeType.ALL)
    private Set<QuestionResponse> questionsResponses = new HashSet<>();

    public SurveyResponse() {
    }

    public SurveyResponse(Respondent respondent, Survey survey, Instant completionDate) {
        this.id.setRespondent(respondent);
        this.id.setSurvey(survey);
        this.completionDate = completionDate;
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

    public Instant getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Instant completionDate) {
        this.completionDate = completionDate;
    }

    public Set<QuestionResponse> getRespondedQuestions() {
        return questionsResponses;
    }

    public void addRespondedQuestions(List<QuestionResponse> questionsResponses) {
        this.questionsResponses = new HashSet<>(questionsResponses);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyResponse that = (SurveyResponse) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
