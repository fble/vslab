FROM java:8-jdk-alpine

VOLUME /tmp

EXPOSE 8085

ARG JAR_FILE=target/user-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} user-service.jar

ENTRYPOINT ["java","-jar","/user-service.jar"]  