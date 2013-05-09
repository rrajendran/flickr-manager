package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Photos;
public class PhotosModel {
	Photos photos;
	String stat;
	public Photos getPhotos() {
		return photos;
	}
	public void setPhotos(Photos photos) {
		this.photos = photos;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	
}
