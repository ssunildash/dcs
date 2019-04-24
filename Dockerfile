FROM java:8-jdk-alpine

COPY ./target/data-caching-service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch data-caching-service-0.0.1-SNAPSHOT.jar'

EXPOSE 8080

ENTRYPOINT ["java","-jar","data-caching-service-0.0.1-SNAPSHOT.jar"]