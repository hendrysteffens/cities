package com.ibge.domain;

public class EncapsuledBussinesObjectWithGenericsFields<T> {
	
	int rows;
	
	T bussinesObject;
	
	public EncapsuledBussinesObjectWithGenericsFields(int rows, T bussinesObject) {
		this.rows = rows;
		this.bussinesObject = bussinesObject;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public T getBussinesObject() {
		return bussinesObject;
	}

	public void setBussinesObject(T bussinesObject) {
		this.bussinesObject = bussinesObject;
	}

	@Override
	public String toString() {
		return "EncapsuledBussinesObjectWithGenericsFields [rows=" + rows + ", bussinesObject=" + bussinesObject
				+ ", getRows()=" + getRows() + ", getBussinesObject()=" + getBussinesObject() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
