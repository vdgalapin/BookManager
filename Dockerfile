# Use Java 17 as base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build with Maven Wrapper
RUN mvn clean package -DskipTests


# Run the app
CMD ["java", "-jar", "target/*.jar"]