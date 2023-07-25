package com.project.surveyapp.services;

import com.project.surveyapp.dto.SurveyResponseDTO;
import com.project.surveyapp.entities.*;
import com.project.surveyapp.repositories.QuestionResponseRepository;
import com.project.surveyapp.repositories.SurveyResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class SurveyResponseService {

    @Autowired
    private SurveyResponseRepository surveyResponseRepository;

    @Autowired
    private QuestionResponseRepository questionResponseRepository;

    // TODO
    private boolean isValidSurveyResponse(){
        // verificar se o respondent existe

        // verificar se a survey existe

        // verificar se todas as perguntas forma respondidas

        // verificar se as opções selecionadas são validas

        return true;
    }

    public SurveyResponseDTO submitSurvey(SurveyResponseDTO surveyResponseDTO) {
        surveyResponseDTO.setCompletionDate(Instant.now());
        Respondent r = new Respondent(surveyResponseDTO.getRespondentId());
        Survey s = new Survey(surveyResponseDTO.getSurveyId());

        SurveyResponse rs = new SurveyResponse(r, s, surveyResponseDTO.getCompletionDate());
        surveyResponseRepository.save(rs);

        for (SurveyResponseDTO.QuestionResponse qrDTO:
        surveyResponseDTO.getQuestionsResponses()) {
            Question q = new Question(qrDTO.getQuestionId());
            QuestionResponse qr = new QuestionResponse(q, rs, qrDTO.getOptionSelected());
            questionResponseRepository.save(qr);
        }

        return surveyResponseDTO;
    }
}
