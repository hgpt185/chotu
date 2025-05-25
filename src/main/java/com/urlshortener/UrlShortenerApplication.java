package com.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application Class
 * 
 * @SpringBootApplication is a convenience annotation that combines:
 * - @Configuration: Tags the class as a source of bean definitions
 * - @EnableAutoConfiguration: Tells Spring Boot to auto-configure based on dependencies
 * - @ComponentScan: Tells Spring to scan for components in this package and sub-packages
 */
@SpringBootApplication
public class UrlShortenerApplication {

    public static void main(String[] args) {
        // SpringApplication.run() bootstraps and launches the Spring application
        SpringApplication.run(UrlShortenerApplication.class, args);
    }

} 