package com.capella.flickr.api.enums;

public enum PhotosEnum {
	SEARCH("flickr.photos.search"),
	DELETE("flickr.photos.delete"),
	GET_ALL_CONTEXT("flickr.photos.getAllContexts"),
	GET_CONTACTS_PHOTOS("flickr.photos.getContactsPhotos"),
	GET_CONTACTS_PUBLIC_PHOTOS("flickr.photos.getContactsPublicPhotos"),
	GET_CONTEXT("flickr.photos.getContext"),
	GET_COUNTS("flickr.photos.getCounts"),
	GET_EXIF("flickr.photos.getExif"),
	GET_FAVOURITES("flickr.photos.getFavorites"),
	GET_INFO("flickr.photos.getInfo"),
	GET_NOT_IN_SET("flickr.photos.getNotInSet"),
	GET_PERMS("flickr.photos.getPerms"),
	GET_RECENT("flickr.photos.getRecent"),
	GET_SIZES("flickr.photos.getSizes"),
	GET_UNTAGGED("flickr.photos.getUntagged"),
	GET_WITH_GEO_DATA("flickr.photos.getWithGeoData"),
	GET_WITHOUT_GEO_DATA("flickr.photos.getWithoutGeoData"),
	GET_RECENTLY_UPDATED("flickr.photos.recentlyUpdated"),
	REMOVE_TAG("flickr.photos.removeTag"),
	SET_CONTENT_TYPE("flickr.photos.setContentType"),
	SET_DATES("flickr.photos.setDates"),
	SET_META("flickr.photos.setMeta"),
	SET_PERMS("flickr.photos.setPerms"),
	SET_SAFETY_LEVEL("flickr.photos.setSafetyLevel"),
	SET_TAGS("flickr.photos.setTags"),
	ADD_TAGS("flickr.photos.addTags");
	private String api;

	PhotosEnum(String api){
		this.api = api;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}
}
