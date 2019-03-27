#!/bin/sh
echo "kill it..."
lsof -i:8080 -t | xargs -r kill
echo "Done!"
