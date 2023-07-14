package com.project.surveyapp.repositories;

import com.project.surveyapp.entities.Respondent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespondentRepository extends JpaRepository<Respondent, Long> {
}
