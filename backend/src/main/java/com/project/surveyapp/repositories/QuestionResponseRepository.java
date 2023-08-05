package com.project.surveyapp.repositories;

import com.project.surveyapp.dto.QuestionResponseDTO;
import com.project.surveyapp.entities.QuestionResponse;
import com.project.surveyapp.entities.pk.QuestionResponsePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface QuestionResponseRepository extends JpaRepository<QuestionResponse, QuestionResponsePK> {

    @Query("""
            SELECT new com.project.surveyapp.dto.QuestionResponseDTO(questionResponse.id.question.id, 
                questionResponse.optionSelected)
            FROM QuestionResponse questionResponse
            WHERE questionResponse.id.surveyResponse.id.respondent.id = :respondentId
            AND questionResponse.id.surveyResponse.id.survey.id = :surveyId
            	""")
    public Set<QuestionResponseDTO> findAllBySurveyResponse(Long respondentId, Long surveyId);
}
