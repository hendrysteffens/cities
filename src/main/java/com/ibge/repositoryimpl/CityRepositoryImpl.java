package com.ibge.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ibge.repository.CityRepositoryCustom;

public class CityRepositoryImpl implements CityRepositoryCustom{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<String> getAllRowsByColumn(String column) {
		return jdbcTemplate.queryForList(String.format(FIND_ROWS_BY_COLUMN_QUERY, column), String.class);
	}
	
	@Override
	public List<Integer> findIdOfCitiesMoreFar() {
		return jdbcTemplate.queryForList(String.format(FIND_ID_OF_CITIES_FURTHER_AWAY), Integer.class);
	}
	
	public static final String FIND_ROWS_BY_COLUMN_QUERY = "SELECT %s FROM City";
	
	public static final String FIND_ID_OF_CITIES_FURTHER_AWAY = ""
			+ "select unnest(array[ibge_id,another_ibge_id]) from "
			+ "( SELECT "
			+ "    city.ibge_id, "
			+ "    anotherCity.ibge_id as another_ibge_id, "
			+ "    ST_Distance(city.geom, anotherCity.geom) as distance "
			+ "FROM "
			+ "    City as city, "
			+ "    City as anotherCity "
			+ "where "
			+ "    city.ibge_id != anotherCity.ibge_id "
			+ "    order by distance DESC "
			+ "    FETCH FIRST 1 ROW ONLY "
			+ ") as cities";

	
}
