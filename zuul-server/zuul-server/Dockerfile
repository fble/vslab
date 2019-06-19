FROM java:8-jdk-alpine

VOLUME /tmp

EXPOSE 8086

ARG JAR_FILE=target/zuul-server-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} zuul-service.jar

ENTRYPOINT ["java","-jar","/zuul-service.jar"]  