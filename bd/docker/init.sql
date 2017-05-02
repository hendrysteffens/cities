CREATE TABLE city(
   ibge_id int,
   uf char(2),
   name varchar,
   capital bool,
   lon float,
   lat float,
   no_accents varchar,
   alternative_names varchar,
   microregion varchar,
   mesoregion varchar
);

COPY City FROM '/docker-entrypoint-initdb.d/cidades.csv' DELIMITER ',' CSV;


UPDATE City SET capital = false WHERE capital is null;

CREATE EXTENSION postgis;

SELECT AddGeometryColumn ('city','geom',0,'POINT',2);


UPDATE city SET geom = ST_MakePoint(lon, lat);


CREATE INDEX city_index ON city USING GIST (geom);

