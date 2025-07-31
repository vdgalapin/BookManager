# Use Java 17 as base image
FROM eclipse-temurin:17-jdk

# Install Maven manually
RUN apt-get update && apt-get install -y maven

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build with Maven Wrapper
RUN mvn clean package -DskipTests


# Run the app
CMD ["sh", "-c", "java -jar target/*.jar"]
