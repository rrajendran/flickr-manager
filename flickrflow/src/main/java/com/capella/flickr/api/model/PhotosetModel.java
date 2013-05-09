package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Photoset;
import com.capella.flickr.api.entity.Stats;

public class PhotosetModel extends Stats{
	private static final long serialVersionUID = 1050934518458877409L;
	Photoset photoset;
	public Photoset getPhotoset() {
		return photoset;
	}
	public void setPhotoset(Photoset photoset) {
		this.photoset = photoset;
	}

	
	
}
