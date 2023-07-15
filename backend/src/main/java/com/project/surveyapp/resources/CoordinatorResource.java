package com.project.surveyapp.resources;

import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.services.CoordinatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/coordinators")
public class CoordinatorResource {

    @Autowired
    private CoordinatorService coordinatorService;

    @PostMapping
    public ResponseEntity<Coordinator> insert(@Valid @RequestBody Coordinator obj, BindingResult result) {
        obj = coordinatorService.insert(obj);
        URI uri =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(obj.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(obj);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Coordinator> findById(@PathVariable Long id) {
        Coordinator obj = coordinatorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
