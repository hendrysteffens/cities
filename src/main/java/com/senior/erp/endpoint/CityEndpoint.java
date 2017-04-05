package com.senior.erp.endpoint;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senior.erp.domain.City;
import com.senior.erp.service.CityService;

@RestController
@RequestMapping("/city")
public class CityEndpoint {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(path = "/{id}", 
					method = RequestMethod.POST, 
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public City getCityByIBGEId(@PathVariable Long id){
		return cityService.findCityByIBGEId(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<City> getAllCities(){
		return cityService.findAll();
	}
	
	@RequestMapping(path = "/capitals",
					method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<City> getAllCapitalsOrdenedByName(){
		return cityService.findAllCapitalsOrdenedByName();
	}
	
	@RequestMapping(path = "/uf/{name}",
					method = RequestMethod.GET, 
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<City> getAllCitiesByUF(@PathVariable String name){
		return cityService.findAllCitiesByUF(name);
	}
	
	@RequestMapping(path = "/{id}",
					method = RequestMethod.DELETE)
	public void removeCity(@PathVariable int id){
		cityService.removeCity(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void createCity(@RequestBody City city){
		cityService.createCity(city);
	}
	
	@RequestMapping(path = "/column",
			params = "name",
			method = RequestMethod.GET)
	public List<String> getColumn(@RequestParam String column){
		return cityService.getAllRowsByColumn(column);
	}
	
}
