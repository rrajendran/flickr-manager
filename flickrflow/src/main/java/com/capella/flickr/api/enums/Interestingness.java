package com.capella.flickr.api.enums;

public enum Interestingness {
	/**
	flickr.interestingness.getList
	 */
	GET_LIST("flickr.interestingness.getList");
	private String api;

	Interestingness(String api) {
		this.api = api;
	}

	public String getApi() {
		return api;
	}
	
}
