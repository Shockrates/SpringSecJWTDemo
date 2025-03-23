# Spring Boot JWT Authentication Example

This is a Spring Boot application demonstrating authentication and authorization using JWT (JSON Web Token). The application features endpoints for user registration, login, and managing student data with authentication.

## Features

- **User Authentication**: Users can register and log in.
- **JWT Token Generation**: Secure authentication with JWT.
- **Secure API Endpoints**: Only authenticated users can create and retrieve student records.
- **MySQL Database**: The application uses MySQL as the database.

## Technologies Used

- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Spring Data JPA**
- **MySQL Database**
- **Lombok** (for reducing boilerplate code)

## Project Structure

```
/src/main/java/com/example
├── config
│   ├── JwtFilter.java
│   ├── SecurityConfig.java
│
├── controller
│   ├── HomeController.java
│   ├── StudentController.java
│   ├── UsersController.java
│
├── entity
│   ├── Student.java
│   ├── Users.java
│   ├── UserPrincipal.java
│
├── service
│   ├── JWTService.java
│   ├── MyUserDetailsService.java
│   ├── UsersService.java
│
└── repository
    ├── StudentRepository.java
    ├── UsersRepository.java
```

## Endpoints

### Public Endpoints

| Method | Endpoint             | Description                      |
| ------ | -------------------- | -------------------------------- |
| GET    | `/api/home`          | Public home endpoint             |
| POST   | `/api/auth/register` | Register a new user              |
| POST   | `/api/auth/login`    | Authenticate user and return JWT |

### Protected Endpoints (Require Authentication)

| Method | Endpoint        | Description          |
| ------ | --------------- | -------------------- |
| GET    | `/api/students` | Get all students     |
| POST   | `/api/students` | Create a new student |

## How It Works

1. **User Registration**: Users can register using `/api/auth/register`.
2. **Login**: Users log in via `/api/auth/login` and receive a JWT token.
3. **Accessing Secured Endpoints**: JWT is passed in the `Authorization` header as `Bearer <token>`.
4. **Spring Security & JWT Filter**: The `JwtFilter` extracts and validates the token.

## Running the Application

1. Clone the repository:
   ```sh
   git clone <repo_url>
   cd <project_folder>
   ```
2. Configure MySQL database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Build and run the project:
   ```sh
   mvn spring-boot:run
   ```
4. Access the API using Postman or a similar tool.

## Sample Authentication Flow

1. **Register a User**
   ```sh
   POST /api/auth/register
   {
      "username": "testuser",
      "password": "password"
   }
   ```
2. **Login and Get JWT Token**
   ```sh
   POST /api/auth/login
   {
      "username": "testuser",
      "password": "password"
   }
   ```
   **Response:**
   ```json
   {
      "token": "your_jwt_token"
   }
   ```
3. **Access Protected Endpoint**
   ```sh
   GET /api/students
   Header: Authorization: Bearer your_jwt_token
   ```

## Security Configuration

- `SecurityConfig.java` configures security settings.
- `JwtFilter.java` intercepts requests and validates JWT tokens.
- `MyUserDetailsService.java` loads user details for authentication.

## Future Improvements

- **Role-based Access Control (RBAC)**: To be implemented to restrict access based on user roles.

## License

This project is open-source and available under the [MIT License](LICENSE).
