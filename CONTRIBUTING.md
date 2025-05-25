# Contributing to URL Shortener

First off, thank you for considering contributing to this educational Spring Boot project! 🎉

## Code of Conduct

This project and everyone participating in it is governed by our Code of Conduct. By participating, you are expected to uphold this code.

## How Can I Contribute?

### Reporting Bugs

Before creating bug reports, please check existing issues as you might find that you don't need to create one. When you are creating a bug report, please include as many details as possible:

* **Use a clear and descriptive title**
* **Describe the exact steps to reproduce the problem**
* **Provide specific examples to demonstrate the steps**
* **Describe the behavior you observed after following the steps**
* **Explain which behavior you expected to see instead and why**
* **Include logs and stack traces if applicable**

### Suggesting Enhancements

Enhancement suggestions are tracked as GitHub issues. When creating an enhancement suggestion, please include:

* **Use a clear and descriptive title**
* **Provide a detailed description of the suggested enhancement**
* **Provide specific examples to demonstrate the steps**
* **Describe the current behavior and explain which behavior you expected to see instead**
* **Explain why this enhancement would be useful**

### Pull Requests

* Fill in the required template
* Do not include issue numbers in the PR title
* Follow the Java style guide
* Include appropriate test cases
* Update documentation accordingly
* End all files with a newline

## Development Process

1. Fork the repo and create your branch from `main`
2. Make your changes and ensure the application still runs
3. Add tests if applicable
4. Ensure your code follows the existing style
5. Issue that pull request!

## Java Style Guide

* Use 4 spaces for indentation (not tabs)
* Keep lines under 120 characters
* Use descriptive variable and method names
* Add JavaDoc comments for all public methods
* Follow standard Java naming conventions

## Testing

```bash
# Run all tests
mvn test

# Run with coverage
mvn test jacoco:report
```

## Project Structure Guidelines

When adding new features:

* Controllers go in `com.urlshortener.controller`
* Services go in `com.urlshortener.service`
* Entities go in `com.urlshortener.entity`
* DTOs go in `com.urlshortener.dto`
* Exceptions go in `com.urlshortener.exception`
* Keep the separation of concerns clear

## Commit Messages

* Use the present tense ("Add feature" not "Added feature")
* Use the imperative mood ("Move cursor to..." not "Moves cursor to...")
* Limit the first line to 72 characters or less
* Reference issues and pull requests liberally after the first line

Example:
```
Add custom short code feature

- Allow users to specify custom short codes
- Validate custom codes for uniqueness
- Add appropriate error handling

Fixes #123
```

## Additional Notes

### Learning Resources

If you're new to Spring Boot, check out these resources:
* [Spring Boot Tutorial](https://spring.io/guides/gs/spring-boot/)
* [Building REST services](https://spring.io/guides/tutorials/rest/)
* [Spring Data JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Questions?

Feel free to open an issue with your question or reach out to the maintainers.

Thank you for contributing! 🚀 