# weather-api

## Architecture

* [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java SE Development Kit 8
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/projects/spring-boot) - Application Server

## How to install
```sh
git clone git@github.com:daniel2github/weather-api.git
cd weather-api
mvn package
```
## How to run
```sh
java -jar target/weather-api-1.0.0.jar
```
## Swagger API Documentation
```
http://localhost:8080/swagger-ui.html
```

## EndPoints examples

#### Call
```sh
curl "localhost:8080/data/?city=Berlin"
```
#### Response
```js
{"pressureAvg":1032.74,"minAvg":6.24,"maxAvg":6.55,"city":"Berlin","days":3,"unit":"metric","errorMessage":null}
```

#### Call
```sh
curl "localhost:8080/data/?city=Berlin&days=5"
```
#### Response
```js
{"pressureAvg":1032.74,"minAvg":6.24,"maxAvg":6.55,"city":"Berlin","days":3,"unit":"metric","errorMessage":null}
```

#### Call
```sh
curl "localhost:8080/data/?city=Paris&days=5"
```
#### Response
```js
{"pressureAvg":1029.12,"minAvg":-4.51,"maxAvg":-3.23,"city":"Paris","days":3,"unit":"metric","errorMessage":null}
```

