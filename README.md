# Authentication API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

This project is an API built using **Java, Java Spring, Flyway Migrations, PostgresSQL as the database, and Spring Security and JWT for authentication control.**

The API was developed to demonstrate how to configure Authentication and Authorization in Spring application using Spring Security.

## Table of Contents

- [Installation](#installation)
- [Database](#database)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
- [Contributing](#contributing)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/SrVeraCruz/auth-api.git
```

2. Install dependencies with Maven
3. Create a configuration with your runtime environment variables with your
   JWT config that are used in `application.properties`.

```yaml
api.security.token.issuer=${JWT_ISSUER:auth-api}
api.security.token.secret=${JWT_SECRET:my-jwt-secret}
```
**Config Values**

```yaml
JWT_ISSUER=VALUE;JWT_SECRET=VALUE2
```
If the values are not provided, it will use the default values as mentioned in `application.properties`.

**PostgreSql**

1. Create a DB for postgres using pgAdmin: http://localhost:5432
2. Log with admin:pass and create a database called 'auth-api'
3. Create a configuration with your runtime environment variables with your
   postgres Database Credentials that are used in `application.properties`.

```yaml
spring.datasource.url=jdbc:postgresql://localhost:5432/auth_api
spring.datasource.username=${POSTGRES_USERNAME}
spring.datasource.password=${POSTGRES_PASSWORD}
```


## Database
The project utilizes [PostgresSQL](https://www.postgresql.org/) as the database. The necessary database migrations are managed using Flyway.


## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8090


## API Endpoints
The API provides the following endpoints:

**API PRODUCT**
```markdown
POST /api/product/category/categoryId - Create a new product (ADMIN access required)
GET /api/product/{id} - Retrieve one product (all authenticated users)
GET /api/product - Retrieve all products (all authenticated users)
```

**BODY**
```json
{
  "name": "Product name",
  "description": "Product description",
  "price": 10000
}
```

**API CATEGORY**
```markdown
POST /api/category - Create a new category (ADMIN access required)
GET /api/category - Retrieve all categories (all authenticated users)
```

**BODY**
```json
{
  "name": "Category name",
  "description": "Category description"
}
```

**API AUTH**
```markdown
POST /api/auth/login - Login into the App
POST /api/auth/register - Register a new user into the App 
```

**BODY LOGIN**
```json
{
  "email": "user@gmail.com",
  "password": "user1234"
}
```

**BODY REGISTER**
```json
{
  "firstName": "user",
  "lastName": "user",
  "email": "user@gmail.com",
  "password": "user1234",
  "role": "USER"
}
```

## Authentication
The API uses Spring Security for authentication control. The following roles are available:

```
USER -> Standard user role for logged-in users.
ADMIN -> Admin role for managing partners (registering new partners).
```
To access protected endpoints as an ADMIN user, provide the appropriate authentication credentials in the request header.

```
Header:
    Authorization:
        Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhdXRoLWFwaSIsInN1YiI6InVzZXJAZ21haWwuY29tIiwiZXhwIjoxNzM4NDcwODI4fQ.TLQgyWTXlZapg-v4cSXEriH7i470_WP16JLblxgkNHE
```

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request to the repository.

When contributing to this project, please follow the existing code style, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), and submit your changes in a separate branch.



