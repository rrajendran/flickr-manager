package com.capella.flickr.api.operations.photos.comments;

import java.util.Map;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.PhotoCommentsModel;

public interface PhotoCommentsOperations{
	public PhotoCommentsModel getList(Map<String,Object> parameters) throws FlickrException;
	
}
