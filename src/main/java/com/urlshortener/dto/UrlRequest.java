package com.urlshortener.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for URL shortening request
 * 
 * DTOs (Data Transfer Objects) are used to:
 * - Separate API contract from internal entities
 * - Validate incoming data
 * - Control what fields are exposed in API
 * 
 * Validation annotations:
 * @NotBlank - Ensures field is not null, empty, or whitespace
 * @Pattern - Validates against a regex pattern
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlRequest {
    
    @NotBlank(message = "URL cannot be empty")
    @Pattern(
        regexp = "^(http|https)://.*$",
        message = "URL must start with http:// or https://"
    )
    private String url;
} 