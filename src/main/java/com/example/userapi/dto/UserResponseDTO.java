package com.example.userapi.dto;

public record UserResponseDTO(
    Long id,
    String email,
    String name,
    Integer age
) {}
