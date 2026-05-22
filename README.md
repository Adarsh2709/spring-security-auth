<div align="center">

# Spring Boot Authentication Microservice

**A robust, secure, and production-ready authentication service built with Spring Boot, Spring Security, JWT, and MySQL.**

![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=Gradle&logoColor=white)

</div>

---

## Overview

This microservice handles user authentication and authorization using the latest **Spring Security** standards. It provides secure stateless session management via **JWT (JSON Web Tokens)** and persists user data reliably in a remote **MySQL** database.

Designed with best practices in mind, this service includes robust input validation, secure password hashing, and a global exception handling architecture for graceful error responses.

## Features

- **Secure User Registration & Login**: Registration with strict email and password strength validation.
- **JWT Authentication**: Stateless architecture using JWT for secure access and refresh tokens.
- **Spring Security**: Fully customized `SecurityFilterChain`, `DaoAuthenticationProvider`, and `CorsConfigurer`.
- **MySQL Integration**: Remote MySQL database connectivity using Spring Data JPA.
- **Password Hashing**: Passwords securely hashed before database persistence.
- **Global Exception Handling**: `@ControllerAdvice` for consistent and meaningful API error responses.

---

## Tech Stack

- **Framework**: Java 21+, Spring Boot 3+
- **Security**: Spring Security, JWT (io.jsonwebtoken)
- **Database**: MySQL, Spring Data JPA / Hibernate
- **Build Tool**: Gradle
- **Utilities**: Lombok (for boilerplate reduction)

---

## Architecture & Endpoints

### Public Endpoints
No authentication required for these routes:
- **`POST /auth/v1/signup`** - Register a new user
- **`POST /auth/v1/login`** - Authenticate and receive JWT tokens
- **`POST /auth/v1/refreshToken`** - Generate a new access token using a refresh token

### Protected Endpoints
Any other request to the service requires a valid JWT in the `Authorization` header:
`Authorization: Bearer <your_jwt_token>`

---

## Getting Started

### Prerequisites
- JDK 21 or higher
- A running instance of MySQL (Local or Remote VM)

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

### 2. Configure the Database
Update your `application.yml` or `application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://<your-db-host>:3306/auth_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run
```bash
# Build the project
./gradlew build

# Run the application
./gradlew bootRun
```

---

## License

This project is [MIT](https://choosealicense.com/licenses/mit/) licensed.

</div>
