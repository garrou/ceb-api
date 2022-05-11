FROM openjdk:18-jdk-alpine

WORKDIR /app

COPY ./build/libs/*.jar ./ceb-api.jar

EXPOSE 8080

CMD ["java", "-jar", "ceb-api.jar"]