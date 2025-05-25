# URL Shortener - Spring Boot Backend

A URL shortener service built with Spring Boot, demonstrating core Spring Boot concepts and best practices.

## Features

- **Shorten Long URLs**: Convert long URLs into short, unique codes
- **Redirect to Original URL**: Redirect users to the original URL when they visit the short link
- **Track Hit Count**: Keep count of how many times each short URL has been accessed
- **View URL Info**: Get details about a shortened URL including creation time and hit count
- **Validation**: Validate input URLs to ensure proper format
- **Unique Code Generation**: Generate non-colliding, unique short codes

## Technology Stack

- **Spring Boot 3.2.0**: Framework for building Java applications
- **Spring Data JPA**: For database operations
- **H2 Database**: In-memory database for development
- **Lombok**: To reduce boilerplate code
- **Maven**: Dependency management

## Project Structure

```
url-shortener/
├── src/main/java/com/urlshortener/
│   ├── UrlShortenerApplication.java    # Main application class
│   ├── controller/                      # REST controllers
│   │   ├── UrlController.java          # API endpoints
│   │   └── RedirectController.java     # Redirect handling
│   ├── dto/                            # Data Transfer Objects
│   │   ├── UrlRequest.java
│   │   ├── UrlResponse.java
│   │   └── ErrorResponse.java
│   ├── entity/                         # JPA entities
│   │   └── Url.java
│   ├── exception/                      # Custom exceptions
│   │   └── UrlNotFoundException.java
│   ├── repository/                     # Data access layer
│   │   └── UrlRepository.java
│   └── service/                        # Business logic layer
│       ├── UrlService.java
│       └── impl/UrlServiceImpl.java
├── src/main/resources/
│   └── application.properties          # Application configuration
└── pom.xml                            # Maven configuration
```

## Key Spring Boot Concepts Demonstrated

1. **Dependency Injection**: Constructor-based injection using `@RequiredArgsConstructor`
2. **REST API**: Using `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`
3. **Data Persistence**: JPA entities, repositories, and automatic CRUD operations
4. **Validation**: Input validation using Jakarta Validation annotations
5. **Exception Handling**: Global exception handling with `@RestControllerAdvice`
6. **Service Layer Pattern**: Separation of concerns with service interfaces and implementations
7. **DTOs**: Data Transfer Objects for API request/response
8. **Logging**: Using SLF4J with Lombok's `@Slf4j`

## Running the Application

1. **Prerequisites**
   - Java 17 or higher
   - Maven 3.6 or higher

2. **Clone the repository**
   ```bash
   cd url-shortener
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - API Base URL: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console
     - JDBC URL: `jdbc:h2:mem:urlshortenerdb`
     - Username: `sa`
     - Password: (leave blank)

## API Endpoints

### 1. Shorten URL
**POST** `/api/v1/shorten`

Request:
```json
{
  "url": "https://www.example.com/very/long/url/that/needs/shortening"
}
```

Response:
```json
{
  "originalUrl": "https://www.example.com/very/long/url/that/needs/shortening",
  "shortUrl": "http://localhost:8080/r/abc123",
  "shortCode": "abc123",
  "createdAt": "2024-01-15T10:30:00",
  "hitCount": 0
}
```

### 2. Get URL Information
**GET** `/api/v1/url/{shortCode}`

Response:
```json
{
  "originalUrl": "https://www.example.com/very/long/url/that/needs/shortening",
  "shortUrl": "http://localhost:8080/r/abc123",
  "shortCode": "abc123",
  "createdAt": "2024-01-15T10:30:00",
  "hitCount": 5
}
```

### 3. Redirect to Original URL
**GET** `/r/{shortCode}`

Returns: 302 Redirect to the original URL

## Testing the API

### Using cURL

1. **Shorten a URL:**
   ```bash
   curl -X POST http://localhost:8080/api/v1/shorten \
     -H "Content-Type: application/json" \
     -d '{"url": "https://www.example.com"}'
   ```

2. **Get URL info:**
   ```bash
   curl http://localhost:8080/api/v1/url/abc123
   ```

3. **Test redirect:**
   ```bash
   curl -L http://localhost:8080/r/abc123
   ```

### Using a REST Client (Postman, Insomnia, etc.)

1. Create a new POST request to `http://localhost:8080/api/v1/shorten`
2. Set the Content-Type header to `application/json`
3. Add the request body with your URL

## Database Schema

The application automatically creates the following table:

```sql
CREATE TABLE urls (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    original_url VARCHAR(2048) NOT NULL,
    short_code VARCHAR(10) UNIQUE NOT NULL,
    created_at TIMESTAMP NOT NULL,
    hit_count BIGINT NOT NULL DEFAULT 0
);
```

## Configuration

The application can be configured through `application.properties`:

- `server.port`: Server port (default: 8080)
- `spring.datasource.url`: Database URL
- `spring.jpa.hibernate.ddl-auto`: Database schema generation strategy
- `spring.h2.console.enabled`: Enable/disable H2 console

## Future Enhancements

- Add expiration dates for URLs
- Implement custom short codes
- Add user authentication and URL ownership
- Use Redis for caching frequently accessed URLs
- Add rate limiting
- Implement analytics dashboard
- Support for QR code generation

## Learning Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA Reference](https://spring.io/projects/spring-data-jpa)
- [Building REST APIs with Spring](https://spring.io/guides/tutorials/rest/)

## License

This project is created for educational purposes.
