FROM openjdk:17-jdk
ARG JAR_FILE=./target/template-0.0.1-SNAPSHOT.jar
COPY target/template-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]