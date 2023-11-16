# ITEA 09 - Blue Grade: Hexagonal Architecture with Spring Boot

### Introduction

In this Coding Dojo session, we'll be diving into hexagonal architecture within a Spring Boot environment. This hands-on challenge will help us internalize the principles of clean code's blue belt, specifically focusing on the separation of design and implementation and ensuring the implementation reflects the design.

### Hexagonal Architecture in Spring Boot

Hexagonal architecture encourages us to separate the core logic of our application (the business rules) from the way it interacts with the outside world (databases, web interfaces, etc.). In a Spring Boot application, this translates to defining clear 'ports' for our core domain logic to interact with external 'adapters', which are the implementation details. The framework's dependency injection and aspect-oriented programming capabilities align well with hexagonal architecture, allowing us to maintain this clean separation.

### Rules

- Apply the principles of hexagonal architecture within the context of Spring Boot.
- Adhere to clean coding practices and blue belt principles.
- Focus on creating clear, maintainable code structures.

## Task 1 - Discussing Hexagonal Architecture Principles

Before jumping into code, let's align our understanding of how hexagonal architecture manifests in a Spring Boot application.

### a) **Design and Implementation don’t overlap**<br/>

Discuss how the separation of concerns is achieved in hexagonal architecture and the benefits of keeping design and implementation separate in a Spring Boot application.

### b) **Implementation reflects Design**<br/>

Explore how the implementation in a Spring Boot application can and should reflect the underlying design, ensuring that the codebase is intuitive and maintainable.

## Task 2 - Coding Challenge: Spring Boot Inventory Management System

We will be using a simplified version of the project from Jivimberg's blog post as our starting point. The project is a basic inventory management system implemented in Spring Boot, utilizing hexagonal architecture.

### Provided Starter Project

- Project structure and class definitions, following the blog's example.
- Domain entities and their implementations.

### Your Task

- Define the necessary ports that your application's core logic requires to interact with external services (e.g., persistence, web interfaces).
- Implement the adapters that will interact with the Spring Boot framework, fulfilling the contracts defined by your ports.
- Ensure that the adapters are correctly wired into the application using Spring Boot's dependency injection.
- Discuss pros and cons of current implementation of BankAccount class. If you see any advantage of changing the structure, then you are encouraged to refactor it.

### Focus Points

- Maintain a clear separation between the application's core logic and the adapters.
- Use Spring Boot's features to keep your adapters decoupled from the core logic.
- Keep the business rules within the application's domain services, free from external concerns.
