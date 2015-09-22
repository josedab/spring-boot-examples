spring-boot-hateoas
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

# Features
- Use of hipermedia links for a rest api. Use of explicit link generation
- Future: hide the link generation under an aspect so controller is not contaminated?
