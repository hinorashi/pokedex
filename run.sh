#!/bin/sh
cd $(dirname $0)

mvn clean compile
ret=$?
if [ $ret -ne 0 ]; then
exit $ret
fi
rm -rf target

read -p "Press [Enter] key to exit..."
exit
