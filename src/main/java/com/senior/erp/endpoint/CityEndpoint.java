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
		return new Object(){
			public List<String> columns = cityService.getAllRowsByColumn(name);
			@SuppressWarnings("unused")
			public int totalRows = columns.size();
		};
	}

	@RequestMapping(path = "/column",// 
					params = { "name", "filter" },// 
					method = RequestMethod.GET)//
	public Object getColumns(@RequestParam String name, @RequestParam String filter) {
		return new Object() {
			public List<String> columns = cityService.getAllRowsByColumnFilterByString(name, filter);
			@SuppressWarnings("unused")
			public int totalRows = columns.size();
		};
	}

	@RequestMapping(path = "/count",// 
					method = RequestMethod.GET)//
	public long countCities() {
		return cityService.countCities();
	}

}
