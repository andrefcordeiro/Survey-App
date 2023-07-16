package com.project.surveyapp.services;

import com.project.surveyapp.entities.Survey;
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

}
