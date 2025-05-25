package com.urlshortener.service.impl;

import com.urlshortener.entity.Url;
import com.urlshortener.exception.UrlNotFoundException;
import com.urlshortener.repository.UrlRepository;
import com.urlshortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;

/**
 * Implementation of UrlService with business logic
 * 
 * @Service - Marks this as a Spring service component
 * @RequiredArgsConstructor - Lombok generates constructor for final fields
 * @Slf4j - Lombok provides a logger instance
 * @Transactional - Ensures database operations run in transactions
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UrlServiceImpl implements UrlService {
    
    // Dependency injection through constructor (thanks to @RequiredArgsConstructor)
    private final UrlRepository urlRepository;
    
    // Characters for generating short codes
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_CODE_LENGTH = 6;
    private static final SecureRandom RANDOM = new SecureRandom();
    
    @Override
    public Url shortenUrl(String originalUrl) {
        log.debug("Shortening URL: {}", originalUrl);
        
        // Generate unique short code
        String shortCode = generateUniqueShortCode();
        
        // Create new URL entity
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(shortCode);
        url.setHitCount(0L);
        
        // Save to database
        Url savedUrl = urlRepository.save(url);
        log.info("URL shortened successfully. Short code: {}", shortCode);
        
        return savedUrl;
    }
    
    @Override
    public Url getUrlByShortCode(String shortCode) {
        log.debug("Getting URL for short code: {}", shortCode);
        
        return urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> {
                    log.error("URL not found for short code: {}", shortCode);
                    return new UrlNotFoundException("URL not found for short code: " + shortCode);
                });
    }
    
    @Override
    public Url getUrlInfo(String shortCode) {
        // Same as getUrlByShortCode but doesn't increment hit count
        return getUrlByShortCode(shortCode);
    }
    
    @Override
    public String redirectUrl(String shortCode) {
        log.debug("Redirecting for short code: {}", shortCode);
        
        // Get URL
        Url url = getUrlByShortCode(shortCode);
        
        // Increment hit count
        urlRepository.incrementHitCount(shortCode);
        log.info("Hit count incremented for short code: {}", shortCode);
        
        return url.getOriginalUrl();
    }
    
    /**
     * Generate a unique short code
     * Uses SecureRandom for better randomness
     * Checks for collisions and regenerates if needed
     */
    private String generateUniqueShortCode() {
        String shortCode;
        int attempts = 0;
        
        do {
            shortCode = generateRandomString();
            attempts++;
            
            // Prevent infinite loop in case of too many collisions
            if (attempts > 10) {
                throw new RuntimeException("Unable to generate unique short code");
            }
        } while (urlRepository.existsByShortCode(shortCode));
        
        log.debug("Generated unique short code: {} (attempts: {})", shortCode, attempts);
        return shortCode;
    }
    
    /**
     * Generate a random string of specified length
     */
    private String generateRandomString() {
        StringBuilder sb = new StringBuilder(SHORT_CODE_LENGTH);
        
        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }
        
        return sb.toString();
    }
} 