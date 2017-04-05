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
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public City findCityByIBGEId(Long id) {
		return cityRepository.findOne(id);
	}
	
	@Override
	public List<City> findAllCitiesByUF(String uf){
		return cityRepository.findAllCitiesByUf(uf.toUpperCase());
	}
	
	@Override
	public List<String> findAllCitiesNameByUF(String uf){
		return cityRepository.findAllCitiesByUf(uf.toUpperCase()).stream()
																 .map(city -> city.getName())  //
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
		cityRepository.delete(Long.valueOf(id));
	}

	@Override
	public List<City> moreFar() {
		return null;
	}

}
