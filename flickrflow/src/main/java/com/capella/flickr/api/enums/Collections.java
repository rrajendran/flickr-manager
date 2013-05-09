package com.capella.flickr.api.enums;

public enum Collections {
	/**
	 flickr.collections.getInfo
	flickr.collections.getTree
	 */
	GET_INFO("flickr.collections.getInfo"),
	GET_TREE("flickr.collections.getTree");
	private String api;

	Collections(String api) {
		this.api = api;
	}

	public String getApi() {
		return api;
	}
	
}
