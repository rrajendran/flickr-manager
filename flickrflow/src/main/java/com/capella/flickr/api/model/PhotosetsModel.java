package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Photosets;
import com.capella.flickr.api.entity.Stats;

public class PhotosetsModel extends Stats{
	private static final long serialVersionUID = 1050934518458877409L;
	Photosets photosets;

	public Photosets getPhotosets() {
		return photosets;
	}

	public void setPhotosets(Photosets photosets) {
		this.photosets = photosets;
	}
	
}
