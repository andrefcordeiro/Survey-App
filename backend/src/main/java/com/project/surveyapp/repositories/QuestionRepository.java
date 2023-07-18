package com.project.surveyapp.repositories;

import com.project.surveyapp.dto.QuestionDTO;
import com.project.surveyapp.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query("""
			SELECT new com.project.surveyapp.dto.QuestionDTO(question.id, question.text,
   				question.option1, question.option2, question.option3, question.option4, question.option5)
   			FROM Question question
   			WHERE question.survey.id = :surveyId
   			ORDER BY question.id
			""")
	List<QuestionDTO> searchQuestionsBySurveyId(Long surveyId);
}
