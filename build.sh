#!/bin/bash

cd src/main/java
javac -d ../../../target/classes mx/uaemex/fi/ico/md/saturn/representacionMatricialDeGrafos/controller/Main.java
cd ../../..

jar --create --file target/GraphRenderingTool.jar \
    --main-class=mx.uaemex.fi.ico.md.saturn.representacionMatricialDeGrafos.controller.Main \
    -C target/classes .

java -jar target/GraphRenderingTool.jar
