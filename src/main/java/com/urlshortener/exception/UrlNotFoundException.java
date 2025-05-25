package com.urlshortener.exception;

/**
 * Custom exception thrown when a URL is not found
 * 
 * Creating custom exceptions helps in:
 * - Better error handling and messaging
 * - Specific exception handling in controllers
 * - Clean separation of different error types
 */
public class UrlNotFoundException extends RuntimeException {
    
    public UrlNotFoundException(String message) {
        super(message);
    }
    
    public UrlNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}