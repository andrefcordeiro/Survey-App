package com.project.surveyapp.services;

import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.entities.Question;
import com.project.surveyapp.entities.Survey;
import com.project.surveyapp.entities.dto.SurveyQuestionsDTO;
import com.project.surveyapp.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public List<Survey> findAll() {
        return surveyRepository.findAll();
    }

    public void createSurvey(SurveyQuestionsDTO surveyQuestionsDTO){
        Coordinator c = new Coordinator();
        c.setId(surveyQuestionsDTO.coordinatorId());

        Survey survey = new Survey(null, surveyQuestionsDTO.title(), surveyQuestionsDTO.timeframe(), c);
        for (Question q : surveyQuestionsDTO.questions()){
            survey.addQuestion(q);
        }

        surveyRepository.save(survey);
    }
}
