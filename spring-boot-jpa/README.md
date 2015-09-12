spring-boot-jpa
===================

# Endpoints

# Endpoints api
GET http://localhost:9000/authors 
GET http://localhost:9000/author/save?name=S (not pure rest, just for not having to use a http rest client)
GET http://localhost:9000/author/find?name=S (find on db using jpa, similar to the where clause)
POST http://localhost:9000/author (need to use http rest client)

# Endpoints management
http://localhost:9001/health
http://localhost:9001/mappings
http://localhost:9001/metrics

# Features
- Used jpa for storing an author (sql and repository included)



