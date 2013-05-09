package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.ExifInfo;

public class ExifModel {
	private ExifInfo photo;
	private String stat;
	
	public ExifInfo getPhoto() {
		return photo;
	}

	public void setPhoto(ExifInfo photo) {
		this.photo = photo;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}
	
	
	
}
