# Backend API for User Authentication and Registration using Spring Boot and JWT Tokens

Create a backend for a login and signup REST API with security features and web tokens for authentication. We will be using the H2 database and Spring Boot framework

## Installation and Setup

```
### Prerequisites
- Java Development Kit (JDK) 8 or later
- Maven
- Postman (for testing the API)
```


### Tech Stack

- Java
- Spring Boot
- H2 Database
- Spring Security
- JWT Token

## H2 Database Configuration

The project uses the H2 in-memory database by default.

The application is configured to use the H2 database. The configuration can be found in the `application.properties` file:

```
# Server Port Configuration

server.port=9091

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:vrindaDB
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=vrinda
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console


```



### Development

The project can be imported and run using  Visual Studio code.

### Test API

You can use Postman to test the API endpoints. 
- Collection link: https://api.postman.com/collections/24976589-f6812982-0f51-42a2-b6b6-b6ab7f40bf37?access_key=PMAT-01H7R3314QRMANN3YT9FDGSK5S


### 1. Clone the Repository

```
git clone https://github.com/v-rinda/Vrinda_RestAPI.git
```

### 2. Run the Application
- For GitBash
```
./mvnw spring-boot:run

```
**The application will start running on [http://localhost:9091](http://localhost:9091)**

### **API Endpoints**

### User Signup

- Method: POST
- Path: `http://localhost:9091/signup`
- Description: Register a new user.
- Request Body: User data in the JSON format (e.g., name, email, password).

```

{
  "username": "Vrinda",
  "password": "Vrinda@131",
  "email": "vrinda13@gmail.com"
}

```

- Response:

```
{
    "userId": 5,
    "email": "vrinda13@gmail.com",
    "role": "STANDARD_USER",
    "username": "Vrinda",
    "password": "$2a$10$/JBQHqu4FTQQu8/Ei9.knO8NGqcsRHPRP3zD/ifr4VpE.b0O8Uiay"
}

```

### User Login

- Method: GET
- Path: `http://localhost:9091/loginUser`
- Description: Authenticate a user and retrieve their details.
- Authentication: Basic Authentication (Username and Password)
    - Username: [vrinda13@gmail.com]
    - Password: Vrinda@131
- Response:

```
{
    "userId": 5,
    "email": "vrinda13@gmail.com",
    "role": "STANDARD_USER",
    "username": "Vrinda",
    "password": "$2a$10$/JBQHqu4FTQQu8/Ei9.knO8NGqcsRHPRP3zD/ifr4VpE.b0O8Uiay"
}
```

### Welcome Endpoint (Requires Authentication)

- Method: GET
- Path: `http://localhost:9091/hello`
- Description: Authenticated endpoint.
- Authentication: Bearer Token
- Request Header:
    - Authorization: Bearer <token>
- Response: A welcome message.
- Example:
    - Bearer Token: eyJhbGciOiJIUzM4NCJ9.eyJpc3MiOiJWcmluZGEiLCJzdWIiOiJKV1QgVG9rZW4iLCJ1c2VybmFtZSI6InZyaW5kYTEzQGdtYWlsLmNvbSIsInJvbGUiOiJTVEFOREFSRF9VU0VSIiwiaWF0IjoxNjkxOTUxMzE2LCJleHAiOjE2OTIwMjEzMTZ9.ky-n615ruAi4kgWBlaAdT2TZPFdohU2sRCP7tky_-8m2xGbWmfithRh9fE_QkxJG
    - Response: HelloFromGreenStitch


### Validation Rules

The following validation rules are applied to the user entity:

- User Name:
    - Minimum length: 1 characters
    - Maximum length: 100 characters
- Email:
    - Valid email format    
- Password:
    - At least 8 characters
    - Contains at least one special character
    - Contains at least one lowercase letter
    - Contains at least one digit
    - Contains at least one uppercase letter
    





## **Contributors**

- **[Vrinda Mayatra](https://github.com/v-rinda)**
 
