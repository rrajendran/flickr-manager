package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Cameras;
import com.capella.flickr.api.entity.Stats;

public class BrandModelsModel extends Stats{
	private static final long serialVersionUID = -7378153999087407889L;
	Cameras cameras;
	public Cameras getCameras() {
		return cameras;
	}
	public void setCameras(Cameras cameras) {
		this.cameras = cameras;
	}
	
	
}
