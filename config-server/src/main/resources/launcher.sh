#!/usr/bin/env sh
echo "Config Server is launching..."
java -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=container -jar /app.jar
