FROM maven:3.9.7 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package



FROM openjdk:19
COPY --from=build app/target/*.jar app.jar
COPY --from=build app/target /app/target
WORKDIR /app
CMD ["java", "-jar", "/app.jar"]

ENV db_username sushiDB_leavewind
ENV db_password 6f07a152c95c99a37368c622af3b1e5093ba8b72
ENV db_url jdbc:mysql://sushiDB_leavewind:6f07a152c95c99a37368c622af3b1e5093ba8b72@9es.h.filess.io:3307/sushiDB_leavewind
