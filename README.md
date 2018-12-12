# Places API

## Test description

You are tasked with creating a microservice which allows you to search for a place by name and return the recommended or
popular venues near that location, using the Foursquare API and returning the results in JSON format.

## Build project
``` mvn package ```

## Run only unit tests
``` mvn test ```

## Run app
```java -jar target/places-1.0.0.jar```

## Considerations

- Name identify unequivocally a place resource. If that is not the case the endpoint should be /api/v1/places?name=XXX
- Place model is stored in a List, it could be a Map or a DB.

