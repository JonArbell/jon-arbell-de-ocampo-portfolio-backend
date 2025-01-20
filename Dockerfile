# Use an official OpenJDK runtime as a parent image
FROM maven:3.9.9-eclipse-temurin-23 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the target directory into the container
COPY --from=build target/backend-0.0.1-SNAPSHOT.jar /app/backend-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on (default: 8080)
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]
