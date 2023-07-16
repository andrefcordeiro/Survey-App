package com.project.surveyapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tb_survey")
public class Survey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate timeframe;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private Coordinator coordinator;

    @JsonIgnore
    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.survey")
    private Set<RespondedSurvey> respondents = new HashSet<>();

    public Survey() {
    }

    public Survey(Long id, String title, LocalDate timeframe, Coordinator coordinator) {
        this.id = id;
        this.title = title;
        this.timeframe = timeframe;
        this.coordinator = coordinator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(LocalDate timeframe) {
        this.timeframe = timeframe;
    }

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void addQuestions(List<Question> questions) {
        this.questions.addAll(questions);
    }

    public Set<RespondedSurvey> getRespondents() {
        return respondents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        return Objects.equals(id, survey.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
