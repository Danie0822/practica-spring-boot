package com.example.userapi.response;

import lombok.*;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(String message, T data) {
        return ApiResponse.of(200, message, data);
    }

    public static <T> ApiResponse<T> error(int status, String message) {
        return ApiResponse.of(status, message, null);
    }
}
