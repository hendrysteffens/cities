package com.senior.erp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.senior.erp.domain.UF;

@Repository
public interface UFRepository {
	
    public UF findWithMoreCities();
    
    public UF findWithLessCities();

	public List<UF> findAllUF();
    
	
}
