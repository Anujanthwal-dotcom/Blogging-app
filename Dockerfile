FROM maven:3.9.9-eclipse-temurin-21 AS build

COPY . .
RUN mvn clean package  -DskipTests
FROM openjdk:21-jdk-slim
COPY --from=build /target/app-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","demo.jar" ]

