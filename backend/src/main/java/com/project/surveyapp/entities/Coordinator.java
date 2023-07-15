package com.project.surveyapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.surveyapp.entities.enums.UserRole;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_coordinator")
public class Coordinator extends User {

    @JsonIgnore
    @OneToMany(mappedBy = "coordinator")
    private Set<Survey> surveys = new HashSet<>();

    public Coordinator() {
    }

    public Coordinator(Long id, String name, String email, String username, String password) {
        super(id, name, email, username, password, UserRole.COORDINATOR);
    }

    public Set<Survey> getSurveys() {
        return surveys;
    }
}
