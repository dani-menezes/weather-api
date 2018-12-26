# weather-api

## Architecture
- Java 1.8
- Spring Boot
- Maven


## How to run (standalone)
```
mvn package && java -jar target/weather-api-1.0.0.jar
```
## Swagger API Documentation
```
http://localhost:8080/swagger-ui.html
```

### EndPoints examples

#### Call
```
curl "localhost:8080/data/?city=Berlin"
```
#### Response
```
{"pressureAvg":1032.74,"minAvg":6.24,"maxAvg":6.55,"city":"Berlin","days":3,"unit":"metric","errorMessage":null}
```

#### Call
```
curl "localhost:8080/data/?city=Berlin&days=5"
```
#### Response
```
{"pressureAvg":1032.74,"minAvg":6.24,"maxAvg":6.55,"city":"Berlin","days":3,"unit":"metric","errorMessage":null}
```

#### Call
```
curl "localhost:8080/data/?city=Paris&days=5"
```
#### Response
```
{"pressureAvg":1029.12,"minAvg":-4.51,"maxAvg":-3.23,"city":"Paris","days":3,"unit":"metric","errorMessage":null}
```

