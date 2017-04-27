package com.senior.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senior.erp.domain.City;

@Service
public interface CityService {
	
	public City findCityByIBGEId(int ibgeId);
	
	public List<City> findAll();

	public List<City> findAllCapitalsOrdenedByName();

	public List<City> findAllCitiesByUF(String uf);

	public List<String> findAllCitiesNameByUF(String uf);

	public void createCity(City city);

	public void removeCity(int id);
	
	public List<City> citiesMoreFar();

	public List<String> getAllRowsByColumn(String column);

	public List<String> getAllRowsByColumnFilterByString(String name, String filter);
	
	public long countCities();

}
