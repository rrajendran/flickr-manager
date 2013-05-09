package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Brands;

public class BrandsModel {
	Brands brands;
	String stat;
	public Brands getBrands() {
		return brands;
	}
	public void setBrands(Brands brands) {
		this.brands = brands;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
}
