package com.senior.erp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
	
	@Id
	private int ibgeId;
	
	private String uf;
	
	private String name;
	
	private boolean capital;
	
	private float lon; 
	
	private float lat;
	
	@Column(name = "no_accents")
	private String noAccents;
	
	@Column(name = "alternative_names")
	private String alternativeName;
	
	private String microregion;
	
	private String mesoregion;
	
	
	
	public City() {
	}

	public City(int ibgeId, String uf, String name, boolean capital, float lon, float lat, String noAccents,
			String alternativeName, String microregion, String mesoregion) {
		super();
		this.ibgeId = ibgeId;
		this.uf = uf;
		this.name = name;
		this.capital = capital;
		this.lon = lon;
		this.lat = lat;
		this.noAccents = noAccents;
		this.alternativeName = alternativeName;
		this.microregion = microregion;
		this.mesoregion = mesoregion;
	}

	public int getIbgeId() {
		return ibgeId;
	}

	public void setIbgeId(int ibgeId) {
		this.ibgeId = ibgeId;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCapital() {
		return capital;
	}

	public void setCapital(boolean capital) {
		this.capital = capital;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public String getNoAccents() {
		return noAccents;
	}

	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}

	public String getAlternativeName() {
		return alternativeName;
	}

	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}

	public String getMicroregion() {
		return microregion;
	}

	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}

	public String getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}
	
}
