package com.project.surveyapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.surveyapp.entities.Survey;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class SurveyDTO {

    private Long id;

    private String title;

    private LocalDate timeframe;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant creationDate;

    private Long coordinatorId;

    private String coordinatorUsername;

    private List<QuestionDTO> questions;

    public SurveyDTO(Long id, String title, LocalDate timeframe, Instant creationDate, Long coordinatorId, String coordinatorUsername) {
        this.id = id;
        this.title = title;
        this.timeframe = timeframe;
        this.creationDate = creationDate;
        this.coordinatorId = coordinatorId;
        this.coordinatorUsername = coordinatorUsername;
    }

    public SurveyDTO(Survey survey) {
        this.id = survey.getId();
        this.title = survey.getTitle();
        this.timeframe = survey.getTimeframe();
        this.creationDate = survey.getCreationDate();
        this.coordinatorId = survey.getCoordinator().getId();
        this.coordinatorUsername = survey.getCoordinator().getUsername();
        this.questions = survey.getQuestions().stream().map(QuestionDTO::new).toList();
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

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }


    public Long getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(Long coordinatorId) {
        this.coordinatorId = coordinatorId;
    }

    public String getCoordinatorUsername() {
        return coordinatorUsername;
    }

    public void setCoordinatorUsername(String coordinatorUsername) {
        this.coordinatorUsername = coordinatorUsername;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
