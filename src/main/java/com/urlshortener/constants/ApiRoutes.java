package com.urlshortener.constants;

/**
 * Constants for API routes used throughout the application
 */
public final class ApiRoutes {
    
    // Base API paths
    public static final String API_BASE = "/api";
    public static final String API_VERSION = "/v1";
    public static final String API_BASE_PATH = API_BASE + API_VERSION;
    
    // URL Shortener endpoints
    public static final String SHORTEN_URL = API_BASE_PATH + "/shorten";
    public static final String URL_INFO = API_BASE_PATH + "/url/{shortCode}";
    public static final String URL_INFO_PATH_VARIABLE = "shortCode";
    
    // Redirect endpoint
    public static final String REDIRECT_URL = "/{" + URL_INFO_PATH_VARIABLE + "}";
    
    // Private constructor to prevent instantiation
    private ApiRoutes() {
        throw new AssertionError("ApiRoutes class should not be instantiated");
    }
} 