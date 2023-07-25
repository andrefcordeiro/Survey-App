package com.project.surveyapp.repositories;

import com.project.surveyapp.entities.QuestionResponse;
import com.project.surveyapp.entities.pk.QuestionResponsePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionResponseRepository extends JpaRepository<QuestionResponse, QuestionResponsePK> {
}
