
FROM java:8-jdk-alpine

VOLUME /tmp

EXPOSE 8089

ARG JAR_FILE=target/content-management-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} content-management.jar

ENTRYPOINT ["java","-jar","/content-management.jar"]  