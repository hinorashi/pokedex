#!/bin/sh
echo "run pokedex service---"
nohup mvn spring-boot:run > nohup.out &
sleep 3
echo "Done!"
