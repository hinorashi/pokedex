#!/bin/sh
echo "kill port running..."
lsof -i:8080 -t | xargs -r kill

echo "run hello service"

nohup mvn spring-boot:run > nohup.out &

read -p "Press [Enter] key to exit..."  key
if [$key = '']; then
lsof -i:8080 -t | xargs -r kill
exit
fi
