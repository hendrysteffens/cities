package com.senior.erp.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.erp.domain.City;
import com.senior.erp.repository.CityRepository;
import com.senior.erp.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public City findCityByIBGEId(int id) {
		return cityRepository.findOne(id);
	}
	
	@Override
	public List<City> findAllCitiesByUF(String uf){
		return cityRepository.findAllCitiesByUf(uf.toUpperCase());
	}
	
	@Override
	public List<String> findAllCitiesNameByUF(String uf){
		return cityRepository.findAllCitiesByUf(uf.toUpperCase()).stream()
																 .map(City::getName)  //
																 .collect(Collectors.toList());//
	}

	@Override
	public List<City> findAll() {
		return StreamSupport.stream(cityRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public List<City> findAllCapitalsOrdenedByName() {
		return cityRepository.findAllCapitalsOrderedByName();
	}
	
	@Override
	public void createCity(City city) {
		cityRepository.save(city);
	}

	@Override
	public void removeCity(int id) {
		cityRepository.delete(id);
	}

	@Override
	public List<City> citiesMoreFar() {
		return cityRepository.findIdOfCitiesMoreFar().stream()//
							 .map(this::findCityByIBGEId)//
							 .collect(Collectors.toList());//
	}

	@Override
	public List<String> getAllRowsByColumn(String column) {
		return cityRepository.getAllRowsByColumn(column).stream()//
														.distinct()//
														.collect(Collectors.toList());//
	}

	@Override
	public List<String> getAllRowsByColumnFilterByString(String column, String filter) {
		return cityRepository.getAllRowsByColumn(column).stream()//
														.filter(c -> c.toUpperCase().contains(filter.toUpperCase()))//
														.collect(Collectors.toList());//
	}

	@Override
	public long countCities() {
		return cityRepository.count(); 
	}

}
