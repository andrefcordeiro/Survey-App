package com.project.surveyapp.repositories;

import com.project.surveyapp.entities.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatorRepository extends JpaRepository<Coordinator, Long> {
}
