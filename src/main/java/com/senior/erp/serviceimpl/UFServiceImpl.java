package com.senior.erp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senior.erp.domain.UF;
import com.senior.erp.repository.UFRepository;
import com.senior.erp.service.UFService;

@Service
public class UFServiceImpl implements UFService{

	@Autowired
	UFRepository UFRepository;

	@Override
	public UF findWithMoreCities() {
		return UFRepository.findWithMoreCities();
	}

	@Override
	public UF findWithLessCities() {
		return UFRepository.findWithLessCities();
	}

	@Override
	public List<UF> findAllUF() {
		return UFRepository.findAllUF();
	}
	
}
