package com.ibge.serviceimpl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ibge.domain.City;
import com.ibge.repository.CityRepository;
import com.ibge.serviceimpl.CityServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class CityServiceImplTest {
	
	@Mock
	CityRepository cityRepository;
	
	@InjectMocks
	CityServiceImpl cityService;

	private City cityOne = new City(1, "SC", "cityOne", false, 1,1,"cityOne","","South","South");
	private City cityTwo = new City(2, "SC", "cityTwo", false, 1,1,"cityTwo","","South","South");
	private City cityThree = new City(3, "SC", "cityThree", false, 1,1,"cityThree","","South","South");
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findAllCitiesNameByUF() {
		List<City> actual = new ArrayList<>();
		actual = initSomeCityValues(actual);
		List<String> expected = new ArrayList<>();
		expected = initReturnValuesOfCityNames(expected);
		when(cityRepository.findAllCitiesByUf("SC")).thenReturn(actual);
		assertEquals(cityService.findAllCitiesNameByUF("SC"), expected);
	}
	
	@Test
	public void citiesMoreFar() {
		List<Integer> actual = new ArrayList<>();
		actual = initSomeCityIDsValues(actual).subList(0, 2);
		List<City> expected = new ArrayList<>();
		expected = twoCitiesMoreFar(expected);
		when(cityRepository.findIdOfCitiesMoreFar()).thenReturn(actual);
		when(cityRepository.findOne(1)).thenReturn(cityOne);
		when(cityRepository.findOne(2)).thenReturn(cityTwo);
		assertEquals(cityService.citiesMoreFar(), expected);
	}
	
	private List<City> twoCitiesMoreFar(List<City> twoCitiesMoreFar){
		initSomeCityValues(twoCitiesMoreFar);
		return twoCitiesMoreFar.subList(0, 2);
	}
	
	@Test
	public void getAllRowsByColumn() {
		List<String> actual = new ArrayList<>();
		actual = initReturnValuesOfCityNames(actual);
		List<String> expected = new ArrayList<>();
		expected = initReturnValuesOfCityNames(expected).subList(0, 3);//Without repeated value
		when(cityRepository.getAllRowsByColumn("name")).thenReturn(actual);
		assertEquals(cityService.getAllRowsByColumn("name"),expected);
	}
	
	@Test
	public void getAllRowsByColumnAndFilter() {
		List<String> actual = new ArrayList<>();
		actual = initReturnValuesOfCityNames(actual);
		List<String> expected = new ArrayList<>();
		expected = initReturnValuesOfCityNames(expected).subList(2, 4);//only "Three"
		when(cityRepository.getAllRowsByColumn("name")).thenReturn(actual);
		assertEquals(cityService.getAllRowsByColumnFilterByString("name", "Three"),expected);
	}
	
	@Test
	public void removeCity(){
		City city = cityOne;
		cityService.removeCity(city.getIbgeId());
        verify(cityRepository, times(1)).delete(city.getIbgeId());
	}
	
	@Test
	public void createCity(){
		City city = cityOne;
		cityService.createCity(city);
        verify(cityRepository, times(1)).save(city);
	}
	
	private List<Integer> initSomeCityIDsValues(List<Integer> listOfCityIDs){
		listOfCityIDs.add(cityOne.getIbgeId());
		listOfCityIDs.add(cityTwo.getIbgeId());
		listOfCityIDs.add(cityThree.getIbgeId());
		listOfCityIDs.add(cityThree.getIbgeId());
		return listOfCityIDs;
	}
	
	private List<String> initReturnValuesOfCityNames(List<String> listOfCityName) {
		listOfCityName.add(cityOne.getName());
		listOfCityName.add(cityTwo.getName());
		listOfCityName.add(cityThree.getName());
		listOfCityName.add(cityThree.getName());
		return listOfCityName;
	}
	private List<City> initSomeCityValues(List<City> listOfCity) {
		listOfCity.add(cityOne);
		listOfCity.add(cityTwo);
		listOfCity.add(cityThree);
		listOfCity.add(cityThree);
		return listOfCity;
	}
	
}
