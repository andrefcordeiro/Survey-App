package com.project.surveyapp.dto;

import java.time.Instant;

public record AuthTokenDTO(String token, Instant expirationDate) {
}