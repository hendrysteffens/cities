package com.senior.erp;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import com.senior.erp.service.CityService;

@Profile("test")
@Configuration
@RunWith(SpringRunner.class)
@SpringBootTest
public class ErpApplicationTests {

	
	@Bean
	@Primary
	public CityService cityService() {
		CityService mockCityService =  Mockito.mock(CityService.class);
		Mockito.when(mockCityService.countCities()).thenReturn(6L);
		return mockCityService;
	}
	
	@Test
	public void contextLoads() {
		CityService mockCityService = Mockito.mock(CityService.class);
		Mockito.when(mockCityService.countCities()).thenReturn(6L);
		
		long count = mockCityService.countCities();
		
		Assertions.assertThat(count).isEqualTo(6L);
	}
}
