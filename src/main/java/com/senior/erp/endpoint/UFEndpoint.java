package com.senior.erp.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senior.erp.domain.UF;
import com.senior.erp.service.UFService;

@RestController
@RequestMapping("/UF")
public class UFEndpoint {
	
	@Autowired
	UFService UFService;
	
	@RequestMapping(path = "",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UF> getAllUF(){
		return UFService.findAllUF();
	}
	
	@RequestMapping(path = "/with-more-cities",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UF getUFWithMoreCities(){
		return UFService.findWithMoreCities();
	}
	
	@RequestMapping(path = "/with-less-cities",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UF getUFWithLessCities(){
		return UFService.findWithLessCities();
	}
	
}
