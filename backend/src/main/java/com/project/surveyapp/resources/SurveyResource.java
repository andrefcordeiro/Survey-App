package com.project.surveyapp.resources;

import com.project.surveyapp.entities.Survey;
import com.project.surveyapp.entities.dto.SurveyQuestionsDTO;
import com.project.surveyapp.services.SurveyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/surveys")
public class SurveyResource {

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public ResponseEntity<List<Survey>> findAll() {
        List<Survey> list = surveyService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity createSurvey(@RequestBody @Valid SurveyQuestionsDTO surveyQuestionsDTO) {

        surveyService.createSurvey(surveyQuestionsDTO);

        return ResponseEntity.ok().build();
    }
}
