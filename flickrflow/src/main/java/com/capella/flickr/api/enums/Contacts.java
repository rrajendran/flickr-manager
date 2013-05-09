package com.capella.flickr.api.enums;

public enum Contacts {
	/**
	 * 	flickr.contacts.getList
		flickr.contacts.getListRecentlyUploaded
		flickr.contacts.getPublicList
		flickr.contacts.getTaggingSuggestions
	 */
	GET_LIST ("flickr.contacts.getList"),
	GET_LIST_RECENTLY_UPLOADED ("flickr.contacts.getListRecentlyUploaded"),
	GET_PUBLIC_LIST ("flickr.contacts.getPublicList"),
	GET_TAGGING_SUGGESTIONS ("flickr.contacts.getTaggingSuggestions");

	private final String api;  
	
	Contacts(String api) {
		this.api = api;
	}
	
	public String getApi() {
		return api;
	}
}
