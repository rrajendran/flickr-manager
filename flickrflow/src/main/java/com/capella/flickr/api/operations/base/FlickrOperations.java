package com.capella.flickr.api.operations.base;

import com.capella.flickr.api.exceptions.FlickrException;

public interface FlickrOperations<T> {
	public T execute(Class<T> t) throws FlickrException;
}
