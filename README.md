# ERP-CHALLENGE 

> Challenge Project to erp job

# BUILD
> spring-boot application need :
```sh
./gradlew build
```
### Docker images

The Dockerfiles(Database and application also are commited on this repository)

> To run database POSTGRE: [Dockerhub image](https://hub.docker.com/r/hendrysteffens/erp-challenge-db)
execute :
```sh
docker run --name erp-postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 hendrysteffens/erp-challenge-db
```

>spring-boot app: [Dockerhub image](https://hub.docker.com/r/hendrysteffens/erp-challenge)

There is a gradle task to build e push to docker. 
```sh
./gradlew build buildDocker
```
***
### ENDPOINTS
>City object example :
```json
{
    "ibgeId": 2800308,
    "uf": "SE",
    "name": "Aracaju",
    "capital": true,
    "lon": -37.048214,
    "lat": -10.907216,
    "noAccents": "Aracaju",
    "alternativeName": null,
    "microregion": "Aracaju",
    "mesoregion": "Leste Sergipano"
}
```

>UF object example :
```json
{
  "name": "MG",
  "totalCities": 853
}
```
***
>  City :

| METHOD | URI | RETURN | DESCRIPTION | 
| ------ | ------ | ------| ----- |
| GET | [/city/capitals] | List<City> | Return all capitals ordered by name.
| GET | [/city/uf/{name}] | List<City> | Return all cities by UF's name.
| GET | [/city/uf/{name}/count] | int total  | Return the number of cities by UF's name.
| GET | [/city/{ibge_id}] | City  | Return the city by ibge id.
| GET | [/city/column?name={column name}] | int rows, List<String> columnValue | Return all values and total values without repeated value.
| GET | [/city/column?name={column name}&filter={filter value}] | int rows, List<String> columnValue  | Return all values and total values with repeated value. Filter is not case sensitive.
| GET | [/city/count] | int total  | Return total of cities.
| GET | [/city/more-far] | List<City>  | Return a list of two cities.
| PUT | [/city] | Body - application/json City  | To create new city.
| DELETE | [/city/{ibge_id}] | return 200  | To delete a city.

>UF :

| METHOD | URI | RETURN | DESCRIPTION | 
| ------ | ------ | ------| ----- |
| GET | [/uf] | List<UF> | Return all uf names and total cities of each.
| GET | [/uf/with-less-cities] | UF | Return the uf with less cities name and number of cities.
| GET | [/uf/with-more-cities] | UF | Return the uf with more cities name and number of cities.
***