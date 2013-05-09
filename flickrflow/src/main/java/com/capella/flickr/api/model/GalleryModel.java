package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Gallery;
import com.capella.flickr.api.entity.Stats;


public class GalleryModel extends Stats{
	private static final long serialVersionUID = 2985163664542917446L;
	Gallery gallery;
	public Gallery getGallery() {
		return gallery;
	}
	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

}
