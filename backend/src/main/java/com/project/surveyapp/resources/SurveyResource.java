package com.project.surveyapp.resources;

import com.project.surveyapp.dto.SurveyDTO;
import com.project.surveyapp.entities.User;
import com.project.surveyapp.services.SurveyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity createSurvey(@RequestBody @Valid SurveyDTO surveyDTO, Authentication auth) {
        User u = (User) auth.getPrincipal();
        surveyDTO.setCoordinatorId(u.getId());

        SurveyDTO s = surveyService.createSurvey(surveyDTO);
        URI uri =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(s.getId())
                        .toUri();

        return ResponseEntity.created(uri).body(s);
    }

    @GetMapping(params = "coordinator")
    public ResponseEntity<List<SurveyDTO>> findByCoordinator(@Valid @RequestParam("coordinator") Long id) {
        List<SurveyDTO> list = surveyService.searchByCoordinator(id);
        return ResponseEntity.ok().body(list);
    }
}
