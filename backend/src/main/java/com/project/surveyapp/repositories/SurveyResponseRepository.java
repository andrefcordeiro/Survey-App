package com.project.surveyapp.repositories;

import com.project.surveyapp.dto.SurveyResponseDTO;
import com.project.surveyapp.entities.SurveyResponse;
import com.project.surveyapp.entities.pk.SurveyResponsePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, SurveyResponsePK> {

    @Query("""
            SELECT new com.project.surveyapp.dto.SurveyResponseDTO(surveyResponse.id.respondent.id, 
            surveyResponse.id.survey.id, surveyResponse.completionDate)
            FROM SurveyResponse surveyResponse
            WHERE surveyResponse.id.respondent.id = :respondentId
            AND surveyResponse.id.survey.id = :surveyId
            	""")
    SurveyResponseDTO findSurveyResponseById(Long respondentId, Long surveyId);
}
