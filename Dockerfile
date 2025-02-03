# Base Image
FROM openjdk:21-jdk-slim

# Working Directory
WORKDIR /app

# Copy JAR File
COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
