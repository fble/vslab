FROM java:8-jdk-alpine

VOLUME /tmp

EXPOSE 8088

ARG JAR_FILE=target/category-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} category-service.jar

ENTRYPOINT ["java","-jar","/category-service.jar"]  
