package org.springframework.social.flickr.api;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.ExifModel;
import com.capella.flickr.api.model.PhotoInfoModel;
import com.capella.flickr.api.model.PhotosModel;

public interface PhotosOperations {
	public PhotosModel search(String tags) throws FlickrException;
	public PhotosModel getRecent() throws FlickrException;
	public PhotoInfoModel getInfo(String photoId) throws FlickrException;
	public PhotosModel getWithGeoData() throws FlickrException;
	public ExifModel getExif(String photoId) throws FlickrException;
}
