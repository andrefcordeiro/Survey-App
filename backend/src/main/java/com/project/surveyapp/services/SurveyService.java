package com.project.surveyapp.services;

import com.project.surveyapp.dto.QuestionDTO;
import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.entities.Question;
import com.project.surveyapp.entities.Survey;
import com.project.surveyapp.dto.SurveyDTO;
import com.project.surveyapp.repositories.QuestionRepository;
import com.project.surveyapp.repositories.SurveyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class SurveyService {

  @Autowired private SurveyRepository surveyRepository;

  @Autowired private QuestionRepository questionRepository;

  @Transactional(readOnly = true)
  public List<SurveyDTO> findAll() {
    List<Survey> surveys = surveyRepository.findAll();
    return surveys.stream().map(SurveyDTO::new).toList();
  }

  public SurveyDTO createSurvey(SurveyDTO surveyDTO) {
    Coordinator c = new Coordinator();
    c.setId(surveyDTO.getCoordinatorId());

    Survey survey =
        new Survey(null, surveyDTO.getTitle(), surveyDTO.getTimeframe(), Instant.now(), c);

    for (QuestionDTO qDTO : surveyDTO.getQuestions()) {
      Question q =
          new Question(
              null,
              qDTO.getText(),
              qDTO.getOptions().get(0),
              qDTO.getOptions().get(1),
              qDTO.getOptions().get(2),
              qDTO.getOptions().get(3),
              qDTO.getOptions().get(4));
      survey.addQuestion(q);
    }

    return new SurveyDTO(surveyRepository.save(survey));
  }

  @Transactional(readOnly = true)
  public List<SurveyDTO> searchByCoordinator(Long id) {
    List<SurveyDTO> surveys = surveyRepository.searchByCoordinator(id);

    for (SurveyDTO s : surveys) {
      List<QuestionDTO> questions = questionRepository.searchQuestionsBySurveyId(s.getId());
      s.setQuestions(questions);
    }
    return surveys;
  }
}
