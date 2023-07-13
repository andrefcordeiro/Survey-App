package com.project.surveyapp.entities;

import com.project.surveyapp.entities.pk.QuestionPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_question")
public class Question implements Serializable {

    @EmbeddedId
    private QuestionPK questionPK;

    @MapsId("surveyId")
    @ManyToOne
    private Survey survey;

    private String text;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;

    public Question() {
    }

    public Question(QuestionPK questionPK, String text, String option1, String option2, String option3, String option4, String option5) {
        this.questionPK = questionPK;
        this.text = text;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
    }

    public QuestionPK getQuestionPK() {
        return questionPK;
    }

    public void setQuestionPK(QuestionPK questionPK) {
        this.questionPK = questionPK;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questionPK, question.questionPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionPK);
    }
}
