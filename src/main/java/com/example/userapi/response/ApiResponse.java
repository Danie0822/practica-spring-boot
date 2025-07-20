package com.example.userapi.response;

import lombok.*;

@Data // Genera getters, setters, toString, equals, hashCode automáticamente
@AllArgsConstructor(staticName = "of") // Crea constructor estático ApiResponse.of()
@NoArgsConstructor // Constructor sin parámetros
@Builder // Patrón Builder para crear objetos
public class ApiResponse<T> {
    private int status;     // Código HTTP (200, 404, 500, etc.)
    private String message; // Mensaje descriptivo
    private T data;         // Los datos reales (puede ser cualquier tipo)

    // Método estático para crear respuestas exitosas
    public static <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.of(200, message, data);
    }

    // Método estático para crear respuestas de error
    public static <T> ApiResponse<T> error(int status, String message) {
        return ApiResponse.of(status, message, null); // Sin datos en errores
    }
}