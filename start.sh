#!/bin/sh
echo "run hello service"
nohup mvn spring-boot:run > nohup.out &
sleep 3
echo "Done!"
