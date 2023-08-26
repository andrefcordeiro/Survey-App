package com.project.surveyapp.services;

import com.project.surveyapp.dto.QuestionDTO;
import com.project.surveyapp.dto.QuestionStatisticsDTO;
import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.entities.Question;
import com.project.surveyapp.entities.Survey;
import com.project.surveyapp.dto.SurveyDTO;
import com.project.surveyapp.projections.QuestionStatisticsProjection;
import com.project.surveyapp.repositories.QuestionRepository;
import com.project.surveyapp.repositories.QuestionResponseRepository;
import com.project.surveyapp.repositories.SurveyRepository;
import com.project.surveyapp.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionResponseRepository questionResponseRepository;

    @Transactional(readOnly = true)
    public List<SurveyDTO> findAll() {
        List<Survey> surveys = surveyRepository.findAll();
        return surveys.stream().map(SurveyDTO::new).toList();
    }

    private String getOptionByIndex(List<String> options, int index) {
        try {
            return options.get(index);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
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
                            getOptionByIndex(qDTO.getOptions(), 0),
                            getOptionByIndex(qDTO.getOptions(), 1),
                            getOptionByIndex(qDTO.getOptions(), 2),
                            getOptionByIndex(qDTO.getOptions(), 3),
                            getOptionByIndex(qDTO.getOptions(), 4));
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

    @Transactional(readOnly = true)
    public SurveyDTO getSurveyWithQuestionsStatistics(Long surveyId) {
        Optional<Survey> obj = surveyRepository.findById(surveyId);
        if (obj.isEmpty())
            throw new ResourceNotFoundException(surveyId);

        SurveyDTO srDTO = new SurveyDTO(obj.get());
        List<QuestionDTO> questions = questionRepository.searchQuestionsBySurveyId(surveyId);

        for (QuestionDTO q : questions) {
            QuestionStatisticsProjection qStatsProj = questionResponseRepository.getOptionSelectionCounts(surveyId, q.getId());
            if (qStatsProj != null) {
                QuestionStatisticsDTO qStatsDTO = new QuestionStatisticsDTO(q, qStatsProj);
                srDTO.addQuestionStatistics(qStatsDTO);
            }
        }
        return srDTO;
    }

    @Transactional(readOnly = true)
    public SurveyDTO findById(Long id) {
        Optional<Survey> obj = surveyRepository.findById(id);

        return new SurveyDTO(obj.get());
    }
}
