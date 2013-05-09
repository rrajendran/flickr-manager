package com.capella.flickr.api.enums;

public enum Activity {
	USER_COMMENTS ("flickr.activity.userComments"),
	USER_PHOTOS ("flickr.activity.userPhotos");

	private final String value;  
	
	Activity(String activity) {
		this.value = activity;
	}
	
	public String getValue() {
		return value;
	}
}
