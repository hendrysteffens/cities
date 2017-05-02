package com.ibge.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibge.domain.City;
import com.ibge.domain.EncapsuledBussinesObjectWithGenericsFields;
import com.ibge.service.CityService;

@RestController
@RequestMapping("/city")
public class CityEndpoint {

	@Autowired
	private CityService cityService;

	@RequestMapping(method = RequestMethod.GET,// 
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)//
	public List<City> getAllCities() {
		return cityService.findAll();
	}

	@RequestMapping(path = "/{id}", //
					method = RequestMethod.GET)// 
	public City getCityByIBGEId(@PathVariable int id) {
		return cityService.findCityByIBGEId(id);
	}

	@RequestMapping(path = "/capitals",// 
					method = RequestMethod.GET)// 
	public List<City> getAllCapitalsOrdenedByName() {
		return cityService.findAllCapitalsOrdenedByName();
	}

	@RequestMapping(path = "/uf/{name}",// 
					method = RequestMethod.GET)// 
	public List<City> getAllCitiesByUF(@PathVariable String name) {
		return cityService.findAllCitiesByUF(name);
	}
	
	@RequestMapping(path = "/uf/{name}/count",// 
			method = RequestMethod.GET)// 
	public int getCountCitiesByUF(@PathVariable String name) {
		return cityService.findAllCitiesByUF(name).size();
	}

	@RequestMapping(path = "/{id}",// 
					method = RequestMethod.DELETE)//
	public void removeCity(@PathVariable int id) {
		cityService.removeCity(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void createCity(@RequestBody City city) {
		cityService.createCity(city);
	}
	
	@RequestMapping(path = "/more-far",// 
					method = RequestMethod.GET)// 
	public List<City> getCitiesMoreFar() {
		return cityService.citiesMoreFar();
	}

	@RequestMapping(path = "/column",// 
					params = "name", //
					method = RequestMethod.GET)//
	public Object getColumns(@RequestParam String name) {
		List<String> columns = cityService.getAllRowsByColumn(name);
		return new EncapsuledBussinesObjectWithGenericsFields<>(columns.size(), columns);
	}

	@RequestMapping(path = "/column",// 
					params = { "name", "filter" },// 
					method = RequestMethod.GET)//
	public Object getColumns(@RequestParam String name, @RequestParam String filter) {
		List<String> columns = cityService.getAllRowsByColumnFilterByString(name, filter);
		return new EncapsuledBussinesObjectWithGenericsFields<>(columns.size(), columns);
		
	}

	@RequestMapping(path = "/count",// 
					method = RequestMethod.GET)//
	public long countCities() {
		return cityService.countCities();
	}

}
