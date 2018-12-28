FROM openjdk:8-jre-alpine
MAINTAINER gluhovskiy.art@gmail.com
ADD docker/service-registry-0.0.1-SNAPSHOT-exec.jar app.jar
ADD docker/init.sh init.sh
EXPOSE 8761 8787
RUN sh -c 'touch /app.jar'
RUN sh -c 'chmod +x /init.sh'
ENTRYPOINT ["sh", "-c", "./init.sh"]
