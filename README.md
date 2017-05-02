# erp-challenge


#spring-boot aplication need :
./gradlew build

#Docker images

db postgre: https://hub.docker.com/r/hendrysteffens/erp-challenge-db
docker run --name erp-postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 hendrysteffens/erp-challenge-db

spring-boot app: https://hub.docker.com/r/hendrysteffens/erp-challenge
There is a task to build e push to docker. buildDocker.

City object example :
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
  
UF object example :
{
  "name": "MG",
  "totalCities": 853
}
  
  
#City endpoints

Method GET /city/capitals
List<City> - Return all capitals ordered by name

Method GET /city/uf/{name}
List<City> - Return all cities by UF's name.

Method GET /city/uf/{name}/count
int total - Return the number of cities by UF's name.

Method GET /city/{ibge_id}
City - Return the city by ibge id.

Method GET /city/column?name={column name}
int rows, List<String> columnValue - Return all values and total values without repeated value.

Method GET /city/column?name={column name}&filter={filter value}
int rows, List<String> columnValue - Return all values and total values with repeated value. Filter is not case sensitive.

Method GET /city/count
int total - Return total of cities

Method GET /city/more-far
List<City> Return a list of two cities.

Method PUT /city 
Body - application/json City, return 200.
To create new city.

Method Delete /city/{ibge_id}
return 200.
To delete a city.


#UF endpoints

Method GET /uf
List<String, int> - Return all uf names and total cities of each.

Method GET /uf/with-more-cities
UF - Return the uf with more cities name and number of cities.

Method GET /uf/with-less-cities
UF - Return the uf with less cities name and number of cities

