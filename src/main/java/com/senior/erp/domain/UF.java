package com.senior.erp.domain;

public class UF {
	
	private String name;
	
	private int totalCities;
	
	public UF() {
	}

	public UF(String name, int totalCities) {
		super();
		this.name = name;
		this.totalCities = totalCities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalCities() {
		return totalCities;
	}

	public void setTotalCities(int totalCities) {
		this.totalCities = totalCities;
	}

	

}
