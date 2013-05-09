package com.capella.flickr.api.enums;

public enum Auth {
	/**
	 * flickr.auth.checkToken
 	
	 */
	AUTH_CHECK_TOKEN("flickr.auth.checkToken"),
	AUTH_GET_FROB("flickr.auth.getFrob"),
	AUTH_GET_FULL_TOKEN("flickr.auth.getFullToken"),
	AUTH_GET_TOKEN("flickr.auth.getToken");
	private String api;

	Auth(String api) {
		this.api = api;
	}

	public String getApi() {
		return api;
	}
	
}
