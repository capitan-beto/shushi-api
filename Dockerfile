FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY .mvn/ .mvn

COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

ENV db_username sushiDB_leavewind
ENV db_password 6f07a152c95c99a37368c622af3b1e5093ba8b72
ENV db_url jdbc:mysql://sushiDB_leavewind:6f07a152c95c99a37368c622af3b1e5093ba8b72@9es.h.filess.io:3307/sushiDB_leavewind
