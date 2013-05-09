package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.PhotoInfo;

public class PhotoInfoModel {
	PhotoInfo photo;
	String stat;
	public PhotoInfo getPhoto() {
		return photo;
	}
	public void setPhoto(PhotoInfo photo) {
		this.photo = photo;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	
}
