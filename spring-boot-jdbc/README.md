spring-boot-jpa
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
``` 
GET http://localhost:9000/authors 
GET http://localhost:9000/author/save?name=S (not pure rest, just for not having to use a http rest client)
GET http://localhost:9000/author/find?name=S (find on db using jpa, similar to the where clause)
POST http://localhost:9000/author (need to use http rest client)
``` 

# Endpoints management
``` 
http://localhost:9001/health
http://localhost:9001/mappings
http://localhost:9001/metrics
``` 

# Features
- Used jdbc to retrieve data
- Used jdbc for storing an author (sql and repository included)

# Learnings
- I would choose jdbc for custom data access. It lets you control more about how to retrieve or store the data
- An inconvenient is that lot of boilerplate and sense of duplicated code appears when writing normal repositories. In that case, JPA is a clear winner.


