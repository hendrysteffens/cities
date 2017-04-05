package com.senior.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senior.erp.domain.UF;

@Service
public interface UFService {

	public UF findWithMoreCities();
	
	public UF findWithLessCities();

	public List<UF> findAllUF();

}
