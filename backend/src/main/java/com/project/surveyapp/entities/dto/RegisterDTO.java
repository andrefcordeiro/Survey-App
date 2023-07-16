package com.project.surveyapp.entities.dto;

import com.project.surveyapp.entities.enums.UserRole;

public record RegisterDTO (String name, String email, String username, String password, UserRole role){
}
