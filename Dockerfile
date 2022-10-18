FROM gradle:jdk18-alpine AS build

COPY . /src

WORKDIR /src

RUN gradle build

FROM openjdk:18-jdk-alpine

WORKDIR /app

COPY --from=build /src/build/libs/ceb-api-1.0.0.jar /app/ceb-api.jar

EXPOSE 8080

CMD ["java", "-jar", "ceb-api.jar"]