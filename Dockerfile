FROM amazoncorretto:11-alpine-jdk

MAINTAINER AGUST

COPY target/portafolio-0.0.1-SNAPSHOT.jar portafolio-app.jar

ENTRYPOINT ["java", "-jar", "/portafolio-app.jar"]

EXPOSE 8080

