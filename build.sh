#!/bin/sh
echo "build..."
mvn clean install -DskipTests
echo "Done!"
