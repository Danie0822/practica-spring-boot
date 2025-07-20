package com.example.userapi.dto;

public record UserResponseDTO(
    // Respuestas DTO para la API de usuario
    Long id,
    String email,
    String name,
    Integer age
) {}
