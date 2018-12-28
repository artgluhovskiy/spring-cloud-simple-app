#!/usr/bin/env sh
echo "Service Registry is launching..."
while ! (nc -z ${CONFIG_SERVER_HOST} ${CONFIG_SERVER_PORT}); do
    echo "Trying to connect to Config Server at ${CONFIG_SERVER_HOST}:${CONFIG_SERVER_PORT}..."
    sleep 10
done
echo ">> connected to Config Server! <<"
java -Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8787 -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /app.jar
