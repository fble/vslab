FROM java:8-jdk-alpine

VOLUME /tmp

EXPOSE 8761

ARG JAR_FILE=target/eureka-server-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} eureka-service.jar

ENTRYPOINT ["java","-jar","/eureka-service.jar"]  