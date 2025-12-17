FROM openjdk:17-slim

WORKDIR /app

COPY target/backend-0.0.1-SNAPSHOT.jar /app/backend-medlife.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/backend-medlife.jar"]