package com.urlshortener.controller;

import com.urlshortener.dto.UrlRequest;
import com.urlshortener.dto.UrlResponse;
import com.urlshortener.entity.Url;
import com.urlshortener.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for URL shortening operations
 * 
 * @RestController = @Controller + @ResponseBody
 * - Marks this as a controller that handles HTTP requests
 * - Automatically serializes return values to JSON
 * 
 * @RequestMapping - Base path for all endpoints in this controller
 * @CrossOrigin - Allows cross-origin requests (for frontend integration)
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class UrlController {
    
    private final UrlService urlService;
    
    /**
     * Shorten a URL
     * POST /api/v1/shorten
     * 
     * @PostMapping - Handles HTTP POST requests
     * @Valid - Triggers validation on the request body
     * @RequestBody - Deserializes JSON request body to UrlRequest object
     */
    @PostMapping("/shorten")
    public ResponseEntity<UrlResponse> shortenUrl(
            @Valid @RequestBody UrlRequest request,
            HttpServletRequest httpRequest) {
        
        log.info("Received request to shorten URL: {}", request.getUrl());
        
        // Call service to shorten URL
        Url url = urlService.shortenUrl(request.getUrl());
        
        // Build response with full short URL
        String baseUrl = getBaseUrl(httpRequest);
        UrlResponse response = buildUrlResponse(url, baseUrl);
        
        // Return with 201 CREATED status
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    /**
     * Get URL information
     * GET /api/v1/url/{shortCode}
     * 
     * @GetMapping - Handles HTTP GET requests
     * @PathVariable - Extracts value from URL path
     */
    @GetMapping("/url/{shortCode}")
    public ResponseEntity<UrlResponse> getUrlInfo(@PathVariable String shortCode,
                                                  HttpServletRequest httpRequest) {
        
        log.info("Getting info for short code: {}", shortCode);
        
        Url url = urlService.getUrlInfo(shortCode);
        String baseUrl = getBaseUrl(httpRequest);
        UrlResponse response = buildUrlResponse(url, baseUrl);
        
        return ResponseEntity.ok(response);
    }
    
    /**
     * Helper method to build UrlResponse from Url entity
     */
    private UrlResponse buildUrlResponse(Url url, String baseUrl) {
        return UrlResponse.builder()
                .originalUrl(url.getOriginalUrl())
                .shortUrl(baseUrl + "/r/" + url.getShortCode())
                .shortCode(url.getShortCode())
                .createdAt(url.getCreatedAt())
                .hitCount(url.getHitCount())
                .build();
    }
    
    /**
     * Helper method to get base URL from request
     */
    private String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        
        if ((scheme.equals("http") && serverPort == 80) || 
            (scheme.equals("https") && serverPort == 443)) {
            return scheme + "://" + serverName;
        } else {
            return scheme + "://" + serverName + ":" + serverPort;
        }
    }
} 