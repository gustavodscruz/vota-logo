FROM maven:3.9.12-amazoncorretto-21-debian AS dependencies
COPY pom.xml /build/
WORKDIR /build/
RUN mvn --batch-mode dependency:go-offline dependency:resolve-plugins

FROM maven:3.9.12-amazoncorretto-21-debian as build
COPY --from=dependencies /root/.m2 /root/.m2
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn -P dockerfile --batch-mode --fail-fast package

FROM eclipse-temurin:21-jre as runtime
COPY --from=build /build/target/application.jar ./application.jar
EXPOSE 8080
CMD ["java", "-jar", "./application.jar"]