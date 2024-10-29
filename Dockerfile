#FROM openjdk:17
FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/democrud-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_demo.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app_demo.jar"]