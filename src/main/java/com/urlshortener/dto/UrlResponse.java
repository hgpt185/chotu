package com.urlshortener.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * DTO for URL response
 * 
 * @Builder - Lombok provides builder pattern for object creation
 * 
 * This DTO controls what information we send back to the client
 * Notice we don't expose the database ID, only necessary fields
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlResponse {
    
    private String originalUrl;
    private String shortUrl;    // Full short URL (e.g., http://localhost:8080/r/abc123)
    private String shortCode;   // Just the code (e.g., abc123)
    private LocalDateTime createdAt;
    private Long hitCount;
} 