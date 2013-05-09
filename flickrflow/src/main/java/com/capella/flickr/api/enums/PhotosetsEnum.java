package com.capella.flickr.api.enums;
/**
 * 	flickr.photosets.addPhoto
	flickr.photosets.create
	flickr.photosets.delete
	flickr.photosets.editMeta
	flickr.photosets.editPhotos
	flickr.photosets.getContext
	flickr.photosets.getInfo
	flickr.photosets.getList
	flickr.photosets.getPhotos
	flickr.photosets.orderSets
	flickr.photosets.removePhoto
	flickr.photosets.removePhotos
	flickr.photosets.reorderPhotos
	flickr.photosets.setPrimaryPhoto
 * @author rrajendran
 *
 */
public enum PhotosetsEnum {
	
	ADD_PHOTO("flickr.photosets.addPhoto"),
	CREATE("flickr.photosets.create"),
	DELETE("flickr.photosets.delete"),
	EDIT_META("flickr.photosets.editMeta"),
	EDIT_PHOTO("flickr.photosets.editPhotos"),
	GET_CONTEXT("flickr.photosets.getContext"),
	GET_INFO("flickr.photosets.getInfo"),
	GET_LIST("flickr.photosets.getList"),
	GET_PHOTOS("flickr.photosets.getPhotos"),
	ORDER_SETS("flickr.photosets.orderSets"),
	REMOVE_PHOTO("flickr.photosets.removePhoto"),
	REORDER_PHOTOS("flickr.photosets.reorderPhotos"),
	SET_PRIMARY_PHOTO("flickr.photosets.setPrimaryPhoto");
	
	private String api;

	PhotosetsEnum(String api){
		this.api = api;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}
}
