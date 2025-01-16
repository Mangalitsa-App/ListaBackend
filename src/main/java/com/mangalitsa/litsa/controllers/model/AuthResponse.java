package com.mangalitsa.litsa.controllers.model;

public record AuthResponse(
        String token,
        long expiresIn
) { }
