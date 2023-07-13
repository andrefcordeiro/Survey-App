package com.project.surveyapp.repositories;

import com.project.surveyapp.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
