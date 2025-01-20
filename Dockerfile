# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY . .

# Expose the port your application runs on (default: 8080)
EXPOSE 8080

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
