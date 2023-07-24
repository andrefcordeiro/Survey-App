package com.project.surveyapp.entities;

import com.project.surveyapp.entities.enums.UserRole;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_respondent")
public class Respondent extends User {

    @OneToMany(mappedBy = "id.respondent")
    private Set<SurveyResponse> surveysResponses = new HashSet<>();

    public Respondent() {
    }

    public Respondent(Long id) {
        super.setId(id);
    }

    public Respondent(Long id, String name, String email, String username, String password) {
        super(id, name, email, username, password, UserRole.RESPONDENT);
    }

    public Set<SurveyResponse> getSurveysResponses() {
        return surveysResponses;
    }
}
