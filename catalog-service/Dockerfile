FROM openjdk:8-jre-alpine
MAINTAINER gluhovskiy.art@gmail.com
ADD docker/catalog-service-0.0.1-SNAPSHOT-exec.jar app.jar
ADD docker/init.sh init.sh
EXPOSE 8081 8091
RUN sh -c 'touch /app.jar'
RUN sh -c 'chmod +x /init.sh'
ENTRYPOINT ["sh", "-c", "./init.sh"]