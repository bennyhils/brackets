#!/bin/bash
cd ..
mvn clean install
mv target/Brackets-0.0.1-SNAPSHOT.jar distr/brackets.jar
docker build -t bot distr
docker login
docker tag bot bennyhils/brackets
docker push bennyhils/brackets
