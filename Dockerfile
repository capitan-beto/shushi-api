FROM maven:3.6.3-jdk-8 AS build
WORKDIR /sushi
COPY pom.xml .
COPY src ./sushi
RUN mvn clean package -DskipTests



FROM openjdk:17
WORKDIR /sushi
# COPY - from=build /sushi/target/sushi-0.0.1-SNAPSHOT.jar . 
CMD ["java", "-jar", "sushi-0.0.1-SNAPSHOT.jar"]

# COPY src ./src
# ENTRYPOINT ["java", "-jar", "/app.jar"]
# COPY target/*.jar  app.jar


ENV db_username sushiDB_leavewind
ENV db_password 6f07a152c95c99a37368c622af3b1e5093ba8b72
ENV db_url jdbc:mysql://sushiDB_leavewind:6f07a152c95c99a37368c622af3b1e5093ba8b72@9es.h.filess.io:3307/sushiDB_leavewind
