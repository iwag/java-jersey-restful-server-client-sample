#!/bin/sh
cd $TRAVIS_BUILD_DIR/projclient && mvn clean test && cd ../projserver && mvn clean test
