# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jre-slim

# Set the working directory
WORKDIR /app

# Copy the service's jar file to the container
COPY target/book-service-0.0.1-SNAPSHOT.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
