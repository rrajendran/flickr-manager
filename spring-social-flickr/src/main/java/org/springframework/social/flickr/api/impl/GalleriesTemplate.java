package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.AbstractFlickrOperations;
import org.springframework.social.flickr.api.GalleriesOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.capella.flickr.api.enums.GalleriesEnum;
import com.capella.flickr.api.model.GalleriesModel;
import com.capella.flickr.api.model.GalleryModel;
import com.capella.flickr.api.model.PhotosModel;

public class GalleriesTemplate extends AbstractFlickrOperations implements
		GalleriesOperations {
	private final RestTemplate restTemplate;

	public GalleriesTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser, String consumerKey, String accessToken) {
		super(isAuthorizedForUser, consumerKey, accessToken);
		this.restTemplate = restTemplate;
	}

	public boolean addPhoto(String galleryId, String photoId, String comment) {
		return false;
	}

	public GalleriesModel create(String title, String description,
			String primaryPhotoId) {
		return null;
	}

	public boolean editMeta(String galleryId, String title, String description) {
		return false;
	}

	public boolean editPhoto(String galleryId, String photoId, String comment) {
		return false;
	}

	public boolean editPhotos(String galleryId, String primaryPhotoId,
			String[] photoIds) {
		return false;
	}

	public GalleryModel getInfo(String galleryId) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("gallery_id", galleryId);
		GalleryModel forObject = (GalleryModel) this.restTemplate.getForObject(
				buildUri(GalleriesEnum.GET_INFO.getApi(), parameters),
				GalleryModel.class);
		return forObject;
	}

	public GalleriesModel getList(String userId, String page, String perPage) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("user_id", userId);
		parameters.set("page", page);
		parameters.set("per_page", perPage);
		GalleriesModel forObject = (GalleriesModel) this.restTemplate
				.getForObject(
						buildUri(GalleriesEnum.GET_LIST.getApi(), parameters),
						GalleriesModel.class);
		return forObject;
	}

	public GalleriesModel getListForPhoto(String photoId, String perPage,
			String page) {
		return null;
	}

	public PhotosModel getPhotos(String galleryId, String extras,
			String perPage, String page) {
		return null;
	}
}