package com.project.surveyapp.entities.pk;

import com.project.surveyapp.entities.Question;
import com.project.surveyapp.entities.RespondedSurvey;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RespondedQuestionPK implements Serializable {

    @ManyToOne
    @JoinColumns(
            {
                    @JoinColumn(name = "respondent_id"),
                    @JoinColumn(name = "survey_id")
            }
    )
    private RespondedSurvey respondedSurvey;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public RespondedSurvey getRespondedSurvey() {
        return respondedSurvey;
    }

    public void setRespondedSurvey(RespondedSurvey respondedSurvey) {
        this.respondedSurvey = respondedSurvey;
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
        RespondedQuestionPK that = (RespondedQuestionPK) o;
        return Objects.equals(respondedSurvey, that.respondedSurvey) && Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(respondedSurvey, question);
    }
}
