FROM frolvlad/alpine-oraclejdk8:slim

ADD target/order-process-service.jar /

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /order-process-service.jar" ]