spring-boot-facebook
===================

# Getting Started

## Prerequisites

1. Oracle JDK 1.8 (tested on 1.8, compatible with 6)
2. Maven 3.0.x

## Running the application

Checkout the codebase and download the dependencies:

```
$ git clone ...
$ mvn clean install
```
Run the application 
```
mvn spring-boot:run
``` 

# Endpoints

# Endpoints api
Example of endpoint for connecting with data with Facebook
``
http://localhost:9000/
```

# Endpoints management
Management features out of the box give by Spring actuator
```
http://localhost:9001/health
http://localhost:9001/mappings
http://localhost:9001/metrics
```

# Features
- Use of facebook spring social


## Learnings
- The idea is good: expose and abstract about connecting to different social networks
- In a practical manner, I would not choose it. There is not direct correlation to the permissions granted by Facebook and process comes to a matter of reverse engineering. Was expecting much more advanced such as passport js for the backend side.
- Would not use it for personal or production projects. Think it takes less time to create its own code. In case of using it, i would spend time talking about the permissions granted by facebook and the ones that the code uses.



