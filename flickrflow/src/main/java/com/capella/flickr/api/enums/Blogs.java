package com.capella.flickr.api.enums;

public enum Blogs {
	/**
	 * 	flickr.blogs.getList
		flickr.blogs.getServices
		flickr.blogs.postPhoto
	 */
	GET_LIST ("flickr.blogs.getList"),
	POST_PHOTO ("flickr.blogs.postPhoto"),
	GET_SERVICES ("flickr.blogs.getServices");

	private final String api;  
	
	Blogs(String api) {
		this.api = api;
	}
	
	public String getApi() {
		return api;
	}
}
