package com.urlshortener.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entity class representing a URL in our database
 * 
 * JPA Annotations explained:
 * @Entity - Marks this class as a JPA entity (database table)
 * @Table - Specifies the table name in the database
 * @Id - Marks the primary key field
 * @GeneratedValue - Tells JPA to auto-generate the ID value
 * @Column - Customizes column properties
 * 
 * Lombok Annotations:
 * @Data - Generates getters, setters, toString, equals, hashCode
 * @NoArgsConstructor - Generates no-argument constructor
 * @AllArgsConstructor - Generates constructor with all fields
 */
@Entity
@Table(name = "urls")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Url {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // The original long URL
    @Column(name = "original_url", nullable = false, length = 2048)
    private String originalUrl;
    
    // The short code (e.g., "abc123")
    @Column(name = "short_code", unique = true, nullable = false, length = 10)
    private String shortCode;
    
    // Timestamp when the URL was created
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    // Number of times this short URL has been accessed
    @Column(name = "hit_count", nullable = false)
    private Long hitCount = 0L;
    
    // Automatically set creation timestamp before persisting
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
} 