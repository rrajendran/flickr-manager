package com.capella.flickr.api.enums;

public enum Commons {
	/**
	 flickr.commons.getInstitutions
	 */
	GET_INSTITUTIONS("flickr.commons.getInstitutions");
	private String api;

	Commons(String api) {
		this.api = api;
	}

	public String getApi() {
		return api;
	}
	
}
