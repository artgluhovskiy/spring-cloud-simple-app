FROM openjdk:8-jre-alpine
MAINTAINER gluhovskiy.art@gmail.com
ENV JAVA_OPTS="-Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8092"
COPY target/inventory-service-0.0.1-SNAPSHOT-exec.jar /app.jar
EXPOSE 8082 8092
ENTRYPOINT ["sh", "-c"]
CMD ["java ${JAVA_OPTS} -Dspring.profiles.active=docker -jar /app.jar"]