package com.urlshortener.service;

import com.urlshortener.entity.Url;

/**
 * Service interface defining business operations for URL shortening
 * 
 * In Spring Boot, it's a good practice to:
 * 1. Define an interface for your service
 * 2. Create an implementation class
 * 
 * This allows for:
 * - Easy testing (mock implementations)
 * - Multiple implementations if needed
 * - Clean separation of concerns
 */
public interface UrlService {
    
    /**
     * Shorten a long URL
     * @param originalUrl The original URL to shorten
     * @return The created URL entity with short code
     */
    Url shortenUrl(String originalUrl);
    
    /**
     * Get the original URL from a short code
     * @param shortCode The short code
     * @return The URL entity if found
     */
    Url getUrlByShortCode(String shortCode);
    
    /**
     * Get URL information without incrementing hit count
     * @param shortCode The short code
     * @return The URL entity if found
     */
    Url getUrlInfo(String shortCode);
    
    /**
     * Redirect to original URL and increment hit count
     * @param shortCode The short code
     * @return The original URL for redirection
     */
    String redirectUrl(String shortCode);
} 