package com.ibge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibge.domain.UF;

@Service
public interface UFService {

	public UF findWithMoreCities();
	
	public UF findWithLessCities();

	public List<UF> findAllUF();

}
