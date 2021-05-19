#!/bin/bash

cd "$1" || exit

javac ./*.java || exit

java "$2" "$3"
