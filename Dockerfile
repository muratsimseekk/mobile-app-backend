FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install -y openjdk-17-jdk maven
COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

EXPOSE 8090

COPY --from=build build/target/demo-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
