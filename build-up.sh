#!/bin/bash
if [[ $1 != '-nb' && $1 != '--no-build' ]]; then
  echo $(tput setaf 2)"maven build..."$(tput sgr0)
  mvn clean package -DskipTests
fi

if [[ $1 == '-nb' || $1 == '--no-build' ]]; then
  echo $(tput setaf 2)"docker compose up..."$(tput sgr0)
  docker-compose up -d --remove-orphans
else
  echo $(tput setaf 2)"docker compose build and up..."$(tput sgr0)
  docker-compose up -d --build --remove-orphans
fi

echo $(tput setaf 2)"let's check the logs..."$(tput sgr0)
docker-compose logs -f --tail 1
