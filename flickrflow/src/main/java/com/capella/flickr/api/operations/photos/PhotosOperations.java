package com.capella.flickr.api.operations.photos;

import java.util.Map;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.PhotoInfoModel;
import com.capella.flickr.api.model.PhotosModel;

public interface PhotosOperations {
	public PhotosModel search(Map<String,Object> parameters) throws FlickrException;
	public PhotosModel getRecent(Map<String,Object> parameters) throws FlickrException;
	public PhotoInfoModel getInfo(Map<String, Object> parameters) throws FlickrException;
	public PhotosModel getWithGeoData(Map<String, Object> parameters) throws FlickrException;
}
