package com.project.surveyapp.repositories;

import com.project.surveyapp.entities.SurveyResponse;
import com.project.surveyapp.entities.pk.SurveyResponsePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, SurveyResponsePK> {
}
