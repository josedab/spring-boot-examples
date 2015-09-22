spring-boot-actuator
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
Example of endpoints for a simple controller
``
http://localhost:9000/hellorest/world/string
http://localhost:9000/hellorest/world/message
```

# Endpoints management
Management features out of the box give by Spring actuator
```
http://localhost:9001/health
http://localhost:9001/mappings
http://localhost:9001/metrics
```

# Features
- Changed port for production and management
- Metrics exposure

## Metrics exposure
- Exposure of int metrics through `CounterService
- Add aspect for metrics exposure through http://localhost:9001/metrics



