# the first stage of our build will use a maven 3.6.1 parent image
FROM maven:3.6.3-openjdk-11-slim AS MAVEN_BUILD
WORKDIR application
# copy the pom and src code to the container
COPY ./ ./
# package our application code
RUN mvn clean package

FROM adoptopenjdk:11-jre-hotspot as builder
WORKDIR application
COPY --from=MAVEN_BUILD application/target/spring-boot-api-0.0.1-SNAPSHOT.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:11-jre-hotspot
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]