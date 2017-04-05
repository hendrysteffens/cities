package com.senior.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senior.erp.domain.City;

@Service
public interface CityService {
	
	public City findCityByIBGEId(Long ibgeId);
	
	public List<City> findAll();

	public List<City> findAllCapitalsOrdenedByName();

	List<City> findAllCitiesByUF(String uf);

	List<String> findAllCitiesNameByUF(String uf);

	public void createCity(City city);

	public void removeCity(int id);
	
	List<City> moreFar();

	public List<String> getAllRowsByColumn(String column);

}
