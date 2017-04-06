package com.senior.erp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.senior.erp.domain.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>, CityRepositoryCustom {

	@Query(FIND_CAPITALS_QUERY)
    public List<City> findAllCapitals();
	
	@Query(FIND_CAPITALS_QUERY_ORDERED)
    public List<City> findAllCapitalsOrderedByName();
	
	public List<City> findAllCitiesByUf(String uf);
	
	public final String FIND_CAPITALS_QUERY = "FROM City WHERE CAPITAL = TRUE";
	public final String FIND_CAPITALS_QUERY_ORDERED = "FROM City WHERE CAPITAL = TRUE ORDER BY NAME";
	
}
