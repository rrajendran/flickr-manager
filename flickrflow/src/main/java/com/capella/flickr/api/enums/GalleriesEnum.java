package com.capella.flickr.api.enums;

public enum GalleriesEnum {
	/**
	 * 	flickr.galleries.addPhoto
		flickr.galleries.create
		flickr.galleries.editMeta
		flickr.galleries.editPhoto
		flickr.galleries.editPhotos
		flickr.galleries.getInfo
		flickr.galleries.getList
		flickr.galleries.getListForPhoto
		flickr.galleries.getPhotos
	 */
	ADD_PHOTO ("flickr.galleries.addPhoto"),
	CREATE ("flickr.galleries.create"),
	EDIT_META ("flickr.galleries.editMeta"),
	EDIT_PHOTO ("flickr.galleries.editPhoto"),
	EDIT_PHOTOS ("flickr.galleries.editPhotos"),
	GET_INFO ("flickr.galleries.getInfo"),
	GET_LIST ("flickr.galleries.getList"),
	GET_LIST_FOR_PHOTO ("flickr.galleries.getListForPhoto"),
	GET_PHOTOS ("flickr.galleries.getPhotos");

	private final String api;  
	
	GalleriesEnum(String api) {
		this.api = api;
	}
	
	public String getApi() {
		return api;
	}
}
