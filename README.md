A Dropwizard microservice that searches hotels and car rentals 
in the Hoen Archipelago by city.

## How to run

cd hoen-scanner
mvn package -q
java -jar target/hoen-scanner-1.0-SNAPSHOT.jar server config.yml

## How to test

Send a POST request to http://localhost:8080/search with body:
{"city": "petalborough"}

Valid cities: petalborough, rustburg, shaleport

## Stack
- Java 19
- Dropwizard 4
- Jackson
- Maven
