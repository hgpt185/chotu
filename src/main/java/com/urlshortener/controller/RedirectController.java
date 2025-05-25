package com.urlshortener.controller;

import com.urlshortener.constants.ApiRoutes;
import com.urlshortener.exception.UrlNotFoundException;
import com.urlshortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller specifically for handling URL redirects
 * 
 * Separated from main API controller for clarity
 * Handles the short URL redirection functionality
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class RedirectController {
    
    private final UrlService urlService;
    
    /**
     * Redirect to original URL
     * GET /r/{shortCode}
     * 
     * Returns a 302 redirect response to the original URL
     * Also increments the hit count
     */
    @GetMapping(ApiRoutes.REDIRECT_URL)
    public ResponseEntity<Void> redirect(@PathVariable(ApiRoutes.URL_INFO_PATH_VARIABLE) String shortCode) {
        log.info("Redirecting short code: {}", shortCode);
        
        try {
            // Get original URL and increment hit count
            String originalUrl = urlService.redirectUrl(shortCode);
            
            // Build redirect response
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.LOCATION, originalUrl);
            
            // Return 302 FOUND status with Location header
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
            
        } catch (UrlNotFoundException e) {
            log.error("Error redirecting short code: {}", shortCode, e);
            // Return 404 if URL not found
            return ResponseEntity.notFound().build();
        }
    }
} 