FROM openjdk:8-jdk-alpine
LABEL maintainer="daniel.afmenezes@gmail.com"
EXPOSE 8080
ARG JAR_FILE=target/weather-api-1.0.0.jar
ADD ${JAR_FILE} weather-api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","weather-api.jar"]