#!/bin/bash
echo $(tput setaf 2)"tear them down..."$(tput sgr0)
docker-compose down --remove-orphans
echo $(tput setaf 2)"Done!"$(tput sgr0)
