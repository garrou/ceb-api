FROM gradle:jdk18-alpine AS build

COPY . /src

WORKDIR /src

RUN gradle build --no-daemon

FROM openjdk:18-jdk-alpine

WORKDIR /app

COPY --from=build /src/build/libs/*.jar /app/ceb-api.jar

EXPOSE 8080

CMD ["java", "-jar", "ceb-api.jar"]