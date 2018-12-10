FROM openjdk:8-jre-alpine
MAINTAINER gluhovskiy.art@gmail.com
COPY docker/catalog-service-0.0.1-SNAPSHOT-exec.jar /app.jar
COPY docker/wrapper.sh /wrapper.sh
EXPOSE 8081 8091
RUN bash -c 'touch /app.jar'
RUN bash -c 'chmod +x /wrapper.sh'
ENTRYPOINT ["/bin/bash", "/wrapper.sh"]