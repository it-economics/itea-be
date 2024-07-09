# Step 1: Use a base image with Java (adopting an OpenJDK image for compatibility)
FROM openjdk:17

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the built jar file from your target directory to the container
# Replace 'your-application.jar' with the actual name of your jar file
COPY target/itea-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port your application uses, default Spring Boot port is 8080
# If your application uses a different port, replace 8080 with your port
EXPOSE 9000

# Step 5: Run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
