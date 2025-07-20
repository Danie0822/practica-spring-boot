package com.example.userapi.exception;

import com.example.userapi.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

// Esta anotación hace que Spring detecte esta clase como un manejador global de excepciones
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Maneja excepciones cuando no se encuentra un recurso (ej: usuario con ID inexistente)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(ResourceNotFoundException ex) {
        // Retorna HTTP 404 con el mensaje de la excepción
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error(404, ex.getMessage()));
    }

    // Maneja errores de validación (ej: campos requeridos vacíos, formato incorrecto)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationErrors(MethodArgumentNotValidException ex) {
        // Extrae todos los errores de validación y los concatena en un string
        String errors = ex.getBindingResult().getFieldErrors()
                .stream().map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));
        // Retorna HTTP 400 con los detalles de validación
        return ResponseEntity.badRequest().body(ApiResponse.error(400, "Errores de validación: " + errors));
    }

    // Captura cualquier otra excepción no manejada específicamente
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneric(Exception ex) {
        // Retorna HTTP 500 para errores internos del servidor
        return ResponseEntity.status(500).body(ApiResponse.error(500, "Error interno: " + ex.getMessage()));
    }
}