FROM openjdk:11-jre-slim
MAINTAINER hino<sinhngay3110@gmail.com>

VOLUME /tmp
COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

