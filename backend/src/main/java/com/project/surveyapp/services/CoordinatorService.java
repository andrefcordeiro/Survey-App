package com.project.surveyapp.services;

import com.project.surveyapp.entities.Coordinator;
import com.project.surveyapp.repositories.CoordinatorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoordinatorService {

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    @Transactional
    public Coordinator insert(Coordinator obj) {
        return coordinatorRepository.save(obj);
    }

    public Coordinator findById(Long id) {
        Optional<Coordinator> opt = coordinatorRepository.findById(id);
        return opt.get();
    }

}
