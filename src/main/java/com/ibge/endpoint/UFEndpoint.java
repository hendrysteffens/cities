package com.ibge.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibge.domain.UF;
import com.ibge.service.UFService;

@RestController
@RequestMapping("/uf")
public class UFEndpoint {
	
	@Autowired
	UFService uUFService;
	
	@RequestMapping(path = "",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UF> getAllUF(){
		return uUFService.findAllUF();
	}
	
	@RequestMapping(path = "/with-more-cities",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UF getUFWithMoreCities(){
		return uUFService.findWithMoreCities();
	}
	
	@RequestMapping(path = "/with-less-cities",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UF getUFWithLessCities(){
		return uUFService.findWithLessCities();
	}
	
}
