# the first stage of our build will use a maven image
FROM maven:3-eclipse-temurin-11-alpine AS MAVEN_BUILD
# copy the pom and src code to the container
COPY ./ ./
# package application code
RUN mvn clean package
# the second stage of build java 11
FROM eclipse-temurin:11-alpine
# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD target/Expenses-App.jar app.jar
# set the startup command to execute the jar
CMD ["java", "-jar", "app.jar"]

