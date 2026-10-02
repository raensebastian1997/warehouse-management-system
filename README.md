# Warehouse Management System

A simple REST API for warehouse management built with Spring Boot.

## Prerequisites

Make sure you have installed the following software before proceeding:

- [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or later.
- [Apache Maven](https://maven.apache.org/download.cgi) (Optional, since this project already includes the Maven Wrapper).

## How to Run the Application

1. **Clone the Repository**

   ```bash
   git clone https://github.com/raensebastian1997/warehouse-management-system.git
   cd warehouse-management-system
   ```

2. **Run the Application Using the Maven Wrapper**

   Open a terminal or command prompt in the project root directory, then run the following command:

    - For Windows users:

      ```bash
      mvnw.cmd spring-boot:run
      ```

    - For Linux/macOS users:

      ```bash
      ./mvnw spring-boot:run
      ```

   The application will run on port `8080` by default.

## Accessing the Application

After the application starts successfully, you can access the following endpoints through your browser:

### 1. H2 Database Console

This application uses H2 as an *in-memory database*. You can access the H2 console to view and manage the data in the database.

- **URL**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (leave blank)

### 2. API Documentation (Swagger UI)

This project includes interactive API documentation using SpringDoc OpenAPI (Swagger UI).

- **URL**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Through Swagger UI, you can view all available endpoints and try sending requests and viewing responses directly.