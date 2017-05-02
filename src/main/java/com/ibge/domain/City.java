package com.ibge.domain;

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

	public String getColumn(String name){
		switch (name.toUpperCase()) {
		case "IBGE_ID":
			return String.valueOf(ibgeId);
		case "UF":
			return uf; 
		case "NAME":
			return name;
		case "CAPITAL":
			return String.valueOf(capital);
		case "LAT":
			return String.valueOf(lat);
		case "LON":
			return String.valueOf(lon);
		case "ALTERNATIVE_NAMES":
			return alternativeName;
		case "MICROREGION":
			return microregion;
		case "MESOREGION":
			return mesoregion;
		case "NO_ACCENTS":
			return noAccents;
		default:
			return "";
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternativeName == null) ? 0 : alternativeName.hashCode());
		result = prime * result + (capital ? 1231 : 1237);
		result = prime * result + ibgeId;
		result = prime * result + Float.floatToIntBits(lat);
		result = prime * result + Float.floatToIntBits(lon);
		result = prime * result + ((mesoregion == null) ? 0 : mesoregion.hashCode());
		result = prime * result + ((microregion == null) ? 0 : microregion.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((noAccents == null) ? 0 : noAccents.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (alternativeName == null) {
			if (other.alternativeName != null)
				return false;
		} else if (!alternativeName.equals(other.alternativeName))
			return false;
		if (capital != other.capital)
			return false;
		if (ibgeId != other.ibgeId)
			return false;
		if (Float.floatToIntBits(lat) != Float.floatToIntBits(other.lat))
			return false;
		if (Float.floatToIntBits(lon) != Float.floatToIntBits(other.lon))
			return false;
		if (mesoregion == null) {
			if (other.mesoregion != null)
				return false;
		} else if (!mesoregion.equals(other.mesoregion))
			return false;
		if (microregion == null) {
			if (other.microregion != null)
				return false;
		} else if (!microregion.equals(other.microregion))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (noAccents == null) {
			if (other.noAccents != null)
				return false;
		} else if (!noAccents.equals(other.noAccents))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "City [ibgeId=" + ibgeId + ", uf=" + uf + ", name=" + name + ", capital=" + capital + ", lon=" + lon
				+ ", lat=" + lat + ", noAccents=" + noAccents + ", alternativeName=" + alternativeName
				+ ", microregion=" + microregion + ", mesoregion=" + mesoregion + "]";
	}
	
}
