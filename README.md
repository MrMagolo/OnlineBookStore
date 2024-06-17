# ONLINE BOOKSTORE
This repository contains  source code of online bookstore

# RUNNING THE APPLICATION
Prerequisites
    Java 17
    Maven 3.x
    Docker and Docker Compose
    MySQL

git clone https://github.com/MagoloSteve-Test/OnlineBookStore.git
# How to run the application using Docker
1. Run `mvn clean package -DskipTests` to build the applications and create the docker image locally.
2. Run `docker-compose up -d` to start the applications.

# How to run the application without Docker
1. Run `mvn clean verify -DskipTests` by going inside each folder to build the applications.
2. After that run `mvn spring-boot:run` by going inside each folder to start the applications.

# Accessing Services
    Eureka Dashboard: http://localhost:8761
    API Gateway: http://localhost:8080
    Book Service: http://localhost:8081
    Order Service: http://localhost:8082
    Customer Service: http://localhost:8083
# Documentation 
Swagger is used for API documentation. You can access the API documentation at http://localhost:8080/swagger-ui.html.




