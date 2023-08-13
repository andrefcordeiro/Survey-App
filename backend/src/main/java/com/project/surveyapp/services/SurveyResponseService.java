package com.project.surveyapp.services;

import com.project.surveyapp.dto.QuestionDTO;
import com.project.surveyapp.dto.QuestionResponseDTO;
import com.project.surveyapp.dto.SurveyResponseDTO;
import com.project.surveyapp.entities.*;
import com.project.surveyapp.entities.pk.SurveyResponsePK;
import com.project.surveyapp.repositories.QuestionRepository;
import com.project.surveyapp.repositories.QuestionResponseRepository;
import com.project.surveyapp.repositories.SurveyResponseRepository;
import com.project.surveyapp.services.exceptions.InvalidSurveyResponseException;
import com.project.surveyapp.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.*;

@Service
public class SurveyResponseService {

    @Autowired
    private SurveyResponseRepository surveyResponseRepository;

    @Autowired
    private QuestionResponseRepository questionResponseRepository;

    @Autowired
    private QuestionRepository questionRepository;

    private SurveyResponse validateSurveyResponse(SurveyResponseDTO surveyResponseDTO) {
        Respondent r = new Respondent(surveyResponseDTO.getRespondentId());
        Survey s = new Survey(surveyResponseDTO.getSurveyId());
        surveyResponseDTO.setCompletionDate(Instant.now());

        // verificando se a survey existe
        List<QuestionDTO> questions = questionRepository.searchQuestionsBySurveyId(s.getId());
        if (questions.isEmpty())
            throw new ResourceNotFoundException(s.getId());

        // verificando se o respondent já preencheu está survey
        if (surveyResponseRepository.existsById(new SurveyResponsePK(r, s)))
            throw new InvalidSurveyResponseException("Respondent with id " + r.getId() +
                    " has already submitted a response to survey with id " + s.getId() + ".");

        // verificar se todas as perguntas foram respondidas
        if (surveyResponseDTO.getQuestionsResponses().size() != questions.size())
            throw new InvalidSurveyResponseException("Wrong number of responses to questions for survey with id "
                    + s.getId() + ". It should be " + questions.size() +
                    " but got " + surveyResponseDTO.getQuestionsResponses().size() + " instead.");

        // verificar se as opções selecionadas são validas
        Iterator<QuestionDTO> questionsIt = questions.iterator();
        Iterator<QuestionResponseDTO> questionsResponsesIt =
                surveyResponseDTO.getQuestionsResponses().iterator();

        while (questionsIt.hasNext() && questionsResponsesIt.hasNext()) {
            QuestionDTO q = questionsIt.next();
            Integer optionSelected = questionsResponsesIt.next().getOptionSelected();

            // se a opção selecionada está entre as disponíveis
            if (optionSelected > q.getOptions().size()) {
                throw new InvalidSurveyResponseException("The value " + optionSelected
                        + " is not a valid option for question with id " + q.getId() + ".");
            }
        }

        return new SurveyResponse(r, s, surveyResponseDTO.getCompletionDate());
    }

    @Transactional(readOnly = true)
    public SurveyResponseDTO findByRespondentId(Long respondentId, Long surveyId) {
        SurveyResponsePK srPK = new SurveyResponsePK(new Respondent(respondentId), new Survey(surveyId));
        SurveyResponseDTO srDTO = surveyResponseRepository.findSurveyResponseById(respondentId, surveyId);

        if (srDTO == null)
            throw new ResourceNotFoundException(srPK);

        Set<QuestionResponseDTO> questionResponses = questionResponseRepository.
                findAllBySurveyResponse(respondentId, surveyId);

        srDTO.setQuestionsResponses(questionResponses);

        return srDTO;
    }

    public SurveyResponseDTO submitSurvey(SurveyResponseDTO surveyResponseDTO) {
        SurveyResponse sr = validateSurveyResponse(surveyResponseDTO);
        surveyResponseRepository.save(sr);

        for (QuestionResponseDTO qrDTO :
                surveyResponseDTO.getQuestionsResponses()) {
            Question q = new Question(qrDTO.getQuestionId());
            QuestionResponse qr = new QuestionResponse(q, sr, qrDTO.getOptionSelected());
            questionResponseRepository.save(qr);
        }

        return surveyResponseDTO;
    }
}
