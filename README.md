# erp-challenge

##spring-boot aplication need :
./gradlew build

#Docker images

db postgre: https://hub.docker.com/r/hendrysteffens/erp-challenge-bd
    docker run --name erp-postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 erp-challenge-bd

spring-boot app: https://hub.docker.com/r/hendrysteffens/erp-challenge
