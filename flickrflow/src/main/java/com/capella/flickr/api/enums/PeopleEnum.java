package com.capella.flickr.api.enums;
/**
 * flickr.people.findByEmail
flickr.people.findByUsername
flickr.people.getGroups
flickr.people.getInfo
flickr.people.getLimits
flickr.people.getPhotos
flickr.people.getPhotosOf
flickr.people.getPublicGroups
flickr.people.getPublicPhotos
flickr.people.getUploadStatus

 * @author rrajendran
 *
 */
public enum PeopleEnum {
	FIND_BY_EMAIL ("flickr.people.findByEmail"),
	FIND_BY_USERNAME ("flickr.people.findByUsername"),
	GET_GROUPS ("flickr.people.getGroups"),
	GET_LIMITS ("flickr.people.getLimits"),
	GET_PHOTOS ("flickr.people.getPhotos"),
	GET_PHOTOS_OF ("flickr.people.getPhotosOf"),
	GET_PUBLIC_GROUPS ("flickr.people.getPublicGroups"),
	GET_PUBLIC_PHOTOS ("flickr.people.getPublicPhotos"),
	GET_UPLOAD_STATUS ("flickr.people.getUploadStatus"),
	GET_INFO ("flickr.people.getInfo");

	private final String api;  
	
	PeopleEnum(String api) {
		this.api = api;
	}
	
	public String getApi() {
		return api;
	}
}
