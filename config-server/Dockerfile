FROM openjdk:8-jre-alpine
MAINTAINER gluhovskiy.art@gmail.com
ADD docker/config-server-0.0.1-SNAPSHOT-exec.jar app.jar
ADD docker/launcher.sh launcher.sh
EXPOSE 8888
RUN sh -c 'touch /app.jar'
RUN sh -c 'chmod +x /launcher.sh'
ENTRYPOINT ["sh", "-c", "./launcher.sh"]