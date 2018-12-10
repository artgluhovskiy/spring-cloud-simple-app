#!/usr/bin/env bash
while ! exec 6<>/dev/tcp/${DATABASE_HOST}/${DATABASE_PORT}; do
    echo "Trying to connect to MySQL at ${DATABASE_HOST}:${DATABASE_PORT}..."
    sleep 10
done
echo ">> connected to MySQL database! <<"
java -Xdebug -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8091 -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /app.jar
