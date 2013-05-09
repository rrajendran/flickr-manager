package org.springframework.social.flickr.api;

import com.capella.flickr.api.model.GalleriesModel;
import com.capella.flickr.api.model.GalleryModel;
import com.capella.flickr.api.model.PhotosModel;

public abstract interface GalleriesOperations {
	public abstract boolean addPhoto(String paramString1, String paramString2,
			String paramString3);

	public abstract GalleriesModel create(String paramString1,
			String paramString2, String paramString3);

	public abstract boolean editMeta(String paramString1, String paramString2,
			String paramString3);

	public abstract boolean editPhoto(String paramString1, String paramString2,
			String paramString3);

	public abstract boolean editPhotos(String paramString1,
			String paramString2, String[] paramArrayOfString);

	public abstract GalleryModel getInfo(String paramString);

	public abstract GalleriesModel getList(String paramString1,
			String paramString2, String paramString3);

	public abstract GalleriesModel getListForPhoto(String paramString1,
			String paramString2, String paramString3);

	public abstract PhotosModel getPhotos(String paramString1,
			String paramString2, String paramString3, String paramString4);
}