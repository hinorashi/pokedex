#!/bin/bash
echo "maven build..."
mvn clean package -DskipTests

echo "docker compose up..."
docker-compose up -d --build --remove-orphans

echo "let's check the logs..."
docker-compose logs -f --tail 1
