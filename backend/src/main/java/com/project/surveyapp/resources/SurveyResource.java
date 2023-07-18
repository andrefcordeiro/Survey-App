package com.project.surveyapp.resources;

import com.project.surveyapp.dto.SurveyDTO;
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
    public ResponseEntity<List<SurveyDTO>> findAll() {
        List<SurveyDTO> list = surveyService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity createSurvey(@RequestBody @Valid SurveyDTO surveyDTO) {
        surveyService.createSurvey(surveyDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping(params = "coordinator")
    public ResponseEntity<List<SurveyDTO>> findByCoordinator(@Valid @RequestParam("coordinator") Long id) {
        List<SurveyDTO> list = surveyService.searchByCoordinator(id);
        return ResponseEntity.ok().body(list);
    }
}
