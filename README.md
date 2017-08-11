![Build Status](https://travis-ci.org/iwag/java-jersey-restful-server-client-sample.svg?branch=master)](https://travis-ci.org/iwag/java-jersey-restful-server-client-sample)

# java-jersey-restful-server-client-sample
RESTful Server/Client sample with Jersey in Java8

## How to run a server

```bash
mvn test clean package
java -jar target/dependency/jetty-runner.jar target/*.war
```
