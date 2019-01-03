FROM openjdk:8-jre-alpine
MAINTAINER gluhovskiy.art@gmail.com
ADD docker/hystrix-dashboard-0.0.1-SNAPSHOT-exec.jar app.jar
EXPOSE 8788 8787
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /app.jar" ]