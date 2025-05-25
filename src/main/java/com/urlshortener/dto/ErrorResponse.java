package com.urlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for error responses
 * 
 * Provides a consistent error response format across the API
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    
    private String message;
    private String error;
    private int status;
    private LocalDateTime timestamp;
    private String path;
} 