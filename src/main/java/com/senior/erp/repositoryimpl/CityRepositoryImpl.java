package com.senior.erp.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.senior.erp.repository.CityRepositoryCustom;

public class CityRepositoryImpl implements CityRepositoryCustom{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<String> getAllRowsByColumn(String column) {
		return jdbcTemplate.queryForList(String.format(FIND_ROWS_BY_COLUMN_QUERY, column), String.class);
	}
	
	public final String FIND_ROWS_BY_COLUMN_QUERY = "SELECT %s FROM City";
	
}
