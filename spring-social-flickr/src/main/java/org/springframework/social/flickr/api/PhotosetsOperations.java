package org.springframework.social.flickr.api;

import org.springframework.cache.annotation.Cacheable;

import com.capella.flickr.api.model.PhotosetModel;
import com.capella.flickr.api.model.PhotosetsModel;

public abstract interface PhotosetsOperations {
	@Cacheable({ "cacheStore" })
	public abstract PhotosetsModel getList(String paramString1,
			String paramString2, String paramString3);

	@Cacheable({ "cacheStore" })
	public abstract PhotosetModel getPhotos(String paramString1,
			String paramString2, String paramString3);
}