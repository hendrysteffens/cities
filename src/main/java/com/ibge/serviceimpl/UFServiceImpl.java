package com.ibge.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ibge.domain.UF;
import com.ibge.repository.UFRepository;
import com.ibge.service.UFService;

@Service
public class UFServiceImpl implements UFService{

	@Autowired
	UFRepository uUFRepository;

	@Override
	@Cacheable("UF_WITH_MORE_CITIES")
	public UF findWithMoreCities() {
		return uUFRepository.findWithMoreCities();
	}

	@Override
	@Cacheable("UF_WITH_LESS_CITIES")
	public UF findWithLessCities() {
		return uUFRepository.findWithLessCities();
	}

	@Override
	@Cacheable("ALL_UF")
	public List<UF> findAllUF() {
		return uUFRepository.findAllUF();
	}
	
}
