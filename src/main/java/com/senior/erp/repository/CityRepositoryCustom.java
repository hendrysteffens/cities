package com.senior.erp.repository;

import java.util.List;

public interface CityRepositoryCustom {

	public List<String> getAllRowsByColumn(String column);
	
	public List<Integer> findIdOfCitiesMoreFar();
	
}
