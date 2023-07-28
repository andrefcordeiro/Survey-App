package com.project.surveyapp.resources;


import com.project.surveyapp.dto.SurveyResponseDTO;
import com.project.surveyapp.entities.User;
import com.project.surveyapp.services.SurveyResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/surveys/{id}/responses")
public class SurveyResponseResource {

    @Autowired
    private SurveyResponseService surveyResponseService;

    @PostMapping
    public ResponseEntity submitSurvey(@RequestBody @Valid SurveyResponseDTO surveyResponseDTO,
                                       @PathVariable("id") Long surveyId, Authentication auth) {
        User u = (User) auth.getPrincipal();
        surveyResponseDTO.setRespondentId(u.getId());

        surveyResponseDTO.setSurveyId(surveyId);
        SurveyResponseDTO sr = surveyResponseService.submitSurvey(surveyResponseDTO);

        URI uri =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/surveyId={surveyId}&respondentId={respondentId}")
                        .buildAndExpand(sr.getSurveyId(), sr.getRespondentId())
                        .toUri();

        return ResponseEntity.created(uri).body(sr);
    }
}
