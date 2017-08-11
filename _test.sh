#!/bin/sh
cd $TRAVIS_BUILD_DIR/projclient
mvn clean test
cd $TRAVIS_BUILD_DIR/projserver
mvn clean test
