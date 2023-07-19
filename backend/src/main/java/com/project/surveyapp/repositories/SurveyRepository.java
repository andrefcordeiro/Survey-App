package com.project.surveyapp.repositories;

import com.project.surveyapp.dto.SurveyDTO;
import com.project.surveyapp.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

	@Query("""
			SELECT new com.project.surveyapp.dto.SurveyDTO(survey.id, survey.title, 
			survey.timeframe, survey.creationDate, coord.id, user.username)
			FROM Survey survey
			INNER JOIN Coordinator coord ON survey.coordinator.id = coord.id
			INNER JOIN User user ON user.id = coord.id
			WHERE coord.id = :id
			ORDER BY survey.id
				""")
    List<SurveyDTO> searchByCoordinator(Long id);
}
