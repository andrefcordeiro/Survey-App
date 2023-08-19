package com.project.surveyapp.dto;

import com.project.surveyapp.entities.enums.UserRole;

import java.time.Instant;

public record AuthTokenDTO(String token, Instant expirationDate, Long userId, UserRole role) {
}