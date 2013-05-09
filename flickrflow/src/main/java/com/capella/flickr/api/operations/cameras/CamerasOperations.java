package com.capella.flickr.api.operations.cameras;

import java.util.Map;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.BrandModelsModel;
import com.capella.flickr.api.model.BrandsModel;

public interface CamerasOperations {
	public BrandsModel getBrands(Map<String, Object> parameters) throws FlickrException;
	public BrandModelsModel getBrandModels(Map<String, Object> parameters) throws FlickrException;
}
