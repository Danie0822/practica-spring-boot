package com.example.userapi.dto;
import jakarta.validation.constraints.*;
public record UserRequestDTO(
    // Validaciones para los campos del DTO para asegurar que cumplen con ciertos criterios
    @Email(message = "Email no es valido") @NotBlank
    String email,
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    String password,
    @Size(min = 4, message = "El nombre debe tener al menos 4 caracteres")
    String name,
    @Min(value = 18, message = "La edad debe ser mayor a 18")
    @Max(value = 120, message = "No debe ser mayor a 120 la edad")
    Integer age
){}
