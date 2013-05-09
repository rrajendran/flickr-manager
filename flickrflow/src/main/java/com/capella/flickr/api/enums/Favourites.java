package com.capella.flickr.api.enums;

public enum Favourites {
	/**
	 * 	flickr.favorites.add
		flickr.favorites.getContext
		flickr.favorites.getList
		flickr.favorites.getPublicList
		flickr.favorites.remove
	 */
	ADD ("flickr.favorites.add"),
	GET_CONTEXT ("flickr.favorites.getContext"),
	GET_LIST ("flickr.favorites.getList"),
	GET_PUBLIC_LIST ("flickr.favorites.getPublicList"),
	REMOVE ("flickr.favorites.remove");

	private final String api;  
	
	Favourites(String api) {
		this.api = api;
	}
	
	public String getApi() {
		return api;
	}
}
