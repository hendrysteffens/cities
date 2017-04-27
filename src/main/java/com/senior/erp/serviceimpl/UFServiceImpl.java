package com.senior.erp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.senior.erp.domain.UF;
import com.senior.erp.repository.UFRepository;
import com.senior.erp.service.UFService;

@Service
public class UFServiceImpl implements UFService{

	@Autowired
	UFRepository UFRepository;

	@Override
	@Cacheable("UF_WITH_MORE_CITIES")
	public UF findWithMoreCities() {
		return UFRepository.findWithMoreCities();
	}

	@Override
	@Cacheable("UF_WITH_LESS_CITIES")
	public UF findWithLessCities() {
		return UFRepository.findWithLessCities();
	}

	@Override
	@Cacheable("ALL_UF")
	public List<UF> findAllUF() {
		return UFRepository.findAllUF();
	}
	
}
