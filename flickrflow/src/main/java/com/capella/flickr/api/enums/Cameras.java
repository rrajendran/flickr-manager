package com.capella.flickr.api.enums;

public enum Cameras {
	GET_BRAND_MODELS ("flickr.cameras.getBrandModels"),
	GET_BRANDS ("flickr.cameras.getBrands");

	private final String api;  
	
	Cameras(String api) {
		this.api = api;
	}
	
	public String getApi() {
		return api;
	}
}
