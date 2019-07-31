# Basic-User-REST-API 
[![Build Status](https://travis-ci.com/FontanyLegall-Brandon/Basic-REST-API.svg?branch=master)](https://travis-ci.com/FontanyLegall-Brandon/Basic-REST-API)  ![](https://img.shields.io/badge/Language-Java-yellow.svg) ![enter image description here](https://img.shields.io/badge/Framework-Spring-brightgreen.svg)

Author :  [Fontany-Legall Brandon](https://brandon.fontany-legall.xyz)

## Topic
Create 2 REST services: one that allows to register a user and the other one that displays the details of an registered user.

 - define a user (what are the fields needed). We should have mandatory and optional fields!
 - validate the input and return proper error messages/http status
 - log the input and output of each call and the processing time.
 - have a request parameter which is not mandatory and which provides a default value in case is not set-have a path variable
 - clear code and javadoc
 - unit tests-only adults ( age > 18 years)and that live in France can create an account

## Run
### docker :
```console
$ docker pull brandonfl/rest-api:latest
$ docker run -it -p <port>:<port> brandonfl/rest-api:latest {port}
```
 - Paramètres serveur
	 - `<port>` Port where docker need to publish the application
	 - `{port}` Optionnal : by default 8080

exemple :
```console
$ docker pull brandonfl/rest-api:latest
$ docker run -it -p 8080:8080 brandonfl/rest-api:latest
```

Another exemple :
```console
$ docker pull brandonfl/rest-api:latest
$ docker run -it -p 8081:8081 brandonfl/rest-api:latest 8081
```

### local testing :
```console
$ mvn install

//after install, run with basic port
$ mvn
//after install, run with special port
$ mvn -Dexec.args="8081"
```

## Documentation 
JavaDoc : /doc/javadoc/

JavaApiDoc : /doc/apidoc/

