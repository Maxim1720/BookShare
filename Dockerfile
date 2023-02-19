FROM openjdk:11-jre

RUN mkdir /app
WORKDIR /app
COPY target/BookGo-1.0.jar /app

ENTRYPOINT ["java","-jar","BookGo-1.0.jar"]