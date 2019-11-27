
FROM ubuntu:18.04

RUN apt-get update \
    && apt-get install default-jre -y

ADD ./document-generator-1.0-SNAPSHOT.jar /opt/api.jar
ADD ./application.properties /opt/application.properties

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/api.jar", "-Djava.net.preferIPv4Stack=true", "--spring.config.location=/opt/application.properties"]
