package com.capella.flickr.api.enums;

public enum OAuth {
	/**
	 * flickr.auth.oauth.checkToken
		flickr.auth.oauth.getAccessToken
	 */
	CHECK_TOKEN("flickr.auth.oauth.checkToken"),
	ACCESS_TOKEN("flickr.auth.oauth.getAccessToken");
	private String api;

	OAuth(String api) {
		this.api = api;
	}

	public String getApi() {
		return api;
	}
	
}
