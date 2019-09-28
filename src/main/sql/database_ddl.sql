CREATE SCHEMA XF

CREATE TABLE Country(
CountryId INT PRIMARY KEY,
Name VARCHAR,
);

CREATE TABLE City(
CityId INT PRIMARY KEY,
CountryId INT NOT NULL ,
Name VARCHAR,
Population INT,
FOREIGN KEY (CountryId) REFERENCES Country (CountryId),
);

CREATE TABLE Building(
BuildingId INT PRIMARY KEY,
CityId INT NOT NULL ,
Name VARCHAR,
Floors INT,
FOREIGN KEY (CityId) REFERENCES City (CityId),
);

SELECT country.Name
FROM Country AS country
WHERE country.CountryID IN (
  SELECT city.CountryId
  FROM City AS city
  LEFT JOIN Building AS building
  ON city.CityId = building.CityId
  WHERE building.CityId IS NULL
)

SELECT country.*, (SELECT SUM(city.Population) city.Population FROM City AS city WHERE city.CountryId = country.CoutryId) AS population
FROM Country AS country,
WHERE population > 400
