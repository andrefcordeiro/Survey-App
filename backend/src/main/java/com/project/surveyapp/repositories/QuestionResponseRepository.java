package com.project.surveyapp.repositories;

import com.project.surveyapp.dto.QuestionResponseDTO;
import com.project.surveyapp.entities.QuestionResponse;
import com.project.surveyapp.entities.pk.QuestionResponsePK;
import com.project.surveyapp.projections.QuestionStatisticsProjection;
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
    Set<QuestionResponseDTO> findAllBySurveyResponse(Long respondentId, Long surveyId);

    @Query(value = """
            SELECT question_id AS questionId, listagg(TO_CHAR(option_selected)) AS options, listagg(TO_CHAR(number_of_selections)) AS optionsNumberOfSelections
            FROM (SELECT question_id, option_selected, COUNT(*) AS number_of_selections
                FROM TB_QUESTION_RESPONSE
                WHERE survey_id = :surveyId AND question_id = :questionId
                GROUP BY question_id, option_selected
                ORDER BY option_selected) AS question_responses
             GROUP BY question_id
            """, nativeQuery = true)
    QuestionStatisticsProjection getOptionSelectionCounts(Long surveyId, Long questionId);
}
