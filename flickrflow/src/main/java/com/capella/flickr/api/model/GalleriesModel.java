package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Galleries;
import com.capella.flickr.api.entity.Stats;


public class GalleriesModel extends Stats{
	private static final long serialVersionUID = 2985163664542917446L;
	Galleries galleries;

	public Galleries getGalleries() {
		return galleries;
	}

	public void setGalleries(Galleries galleries) {
		this.galleries = galleries;
	}
}
