##FROM openjdk:22-ea-28-jdk
##COPY target/*.jar quiz-service-0.0.1-SNAPSHOT.jar
##EXPOSE 5000
##ENTRYPOINT ["java","-jar","/quiz-service-0.0.1-SNAPSHOT.jar"]
#
#
### Stage 1: Build the application
##FROM maven:3.8.7-openjdk-18-slim AS build
##
### Set the working directory to the quiz-service directory
##WORKDIR /microservices/quiz-service
##
### Copy the source code into the container
##COPY . .
##
### Build the application
##RUN mvn clean package
##
### Stage 2: Create runtime image
##FROM openjdk:18-slim
##
### Define a temporary volume
##VOLUME /temp
##
### Expose the application port
##EXPOSE 8081
##
### Copy the built JAR from the build stage
##COPY --from=build /microservices/quiz-service/target/*.jar /quiz-service-0.0.1-SNAPSHOT.jar
##
### Define the entrypoint to run the application
##ENTRYPOINT ["sh", "-c", "java -jar /quiz-service-0.0.1-SNAPSHOT.jar"]
#
##optimized
## Stage 1: Build the application
#FROM maven:3.8.7-openjdk-18-slim AS build
#
## Set the working directory to the quiz-service directory
#WORKDIR /microservices/quiz-service
#
## Copy only the required files (pom.xml and src) to leverage Docker cache better
#COPY pom.xml ./
#COPY src ./src
#
## Build the application (skip tests to speed up the build)
#RUN mvn clean package -DskipTests
#
## Stage 2: Create runtime image
#FROM openjdk:18-slim
#
## Define a temporary volume for any persistent data
#VOLUME /temp
#
## Expose the application port
#EXPOSE 8081
#
## Copy the built JAR from the build stage (use a more specific file path)
#COPY --from=build /microservices/quiz-service/target/quiz-service-0.0.1-SNAPSHOT.jar /quiz-service-0.0.1-SNAPSHOT.jar
#
## Define the entrypoint to run the application
#ENTRYPOINT ["sh", "-c", "java -jar /quiz-service-0.0.1-SNAPSHOT.jar"]
#
#
