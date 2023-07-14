package com.project.surveyapp.repositories;

import com.project.surveyapp.entities.RespondedSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespondedSurveyRepository extends JpaRepository<RespondedSurvey, Long> {
}
