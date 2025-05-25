package com.urlshortener.repository;

import com.urlshortener.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Repository interface for URL database operations
 * 
 * @Repository - Marks this as a Spring repository component
 * 
 * By extending JpaRepository<Url, Long>, we automatically get:
 * - save(), findById(), findAll(), delete(), count(), etc.
 * 
 * We can also define custom query methods:
 * - Spring generates the implementation based on method names
 * - Or we can use @Query for custom queries
 */
@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    
    /**
     * Find a URL by its short code
     * Spring automatically generates: SELECT * FROM urls WHERE short_code = ?
     */
    Optional<Url> findByShortCode(String shortCode);
    
    /**
     * Check if a short code already exists
     * Spring automatically generates: SELECT COUNT(*) > 0 FROM urls WHERE short_code = ?
     */
    boolean existsByShortCode(String shortCode);
    
    /**
     * Increment hit count for a URL
     * @Query allows us to write custom JPQL queries
     * @Modifying marks this as an update/delete query
     * @Transactional ensures this runs in a transaction
     */
    @Modifying
    @Transactional
    @Query("UPDATE Url u SET u.hitCount = u.hitCount + 1 WHERE u.shortCode = :shortCode")
    void incrementHitCount(String shortCode);
} 