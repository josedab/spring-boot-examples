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
- Used jpa for retrieving data
- Used jpa for storing an author (sql and repository included)

# Learnings
- Good for simple access and store of tables. Gets complicated with relationships and even when it adds lot of logic to handle this, it seems to me you have to be a well experienced hibernate to see what is going on under the hood. At that point, just better go to jdbc in my opinion as other developers may not be experienced with hibernate, but everyone can understand sql.

