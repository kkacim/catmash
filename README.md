[![Build Status](https://travis-ci.org/kkacim/catmash.svg?branch=master)](https://travis-ci.org/kkacim/catmash)

CatMash
---
The purpose of the application is to find the cutest cat.\
To rate the cats, the Elo rating system is used. 
Every cat has an initial rating of 1500, this rating change when the cat face others cats on a 1v1 battle.

For more information about this rating system, visit this [page](https://en.wikipedia.org/wiki/Elo_rating_system).

#####The application is deployed on Heroku: [Click here](https://kk-cat-mash.herokuapp.com)

## 1. Run with Docker
Run command:
```
docker-compose up -d
```

## 2. Run with Java
### 2.1 Compile
#### Maven
Run command :
```
mvn package
```

### 2.2 Execute
#### Java
The compile command build an executable fat jar.
Run the jar with the command :
```
java -jar catmash**.jar
```