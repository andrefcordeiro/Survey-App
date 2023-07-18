package com.project.surveyapp.entities;

import com.project.surveyapp.entities.enums.UserRole;
import jakarta.persistence.*;


@Entity
@Table(name = "tb_coordinator")
public class Coordinator extends User {
    public Coordinator() {
    }

    public Coordinator(Long id, String name, String email, String username, String password) {
        super(id, name, email, username, password, UserRole.COORDINATOR);
    }
}
