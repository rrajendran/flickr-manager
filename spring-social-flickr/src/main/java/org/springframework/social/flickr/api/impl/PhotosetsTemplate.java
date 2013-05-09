package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.AbstractFlickrOperations;
import org.springframework.social.flickr.api.PhotosetsOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.capella.flickr.api.enums.PhotosetsEnum;
import com.capella.flickr.api.model.PhotosetModel;
import com.capella.flickr.api.model.PhotosetsModel;

public class PhotosetsTemplate extends AbstractFlickrOperations implements
		PhotosetsOperations {
	private final RestTemplate restTemplate;

	public PhotosetsTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser, String consumerKey, String accessToken) {
		super(isAuthorizedForUser, consumerKey, accessToken);
		this.restTemplate = restTemplate;
	}

	public PhotosetsModel getList(String userId, String page, String perPage) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("user_id", userId);
		parameters.set("page", page);
		parameters.set("per_page", perPage);
		PhotosetsModel forObject = (PhotosetsModel) this.restTemplate
				.getForObject(
						buildUri(PhotosetsEnum.GET_LIST.getApi(), parameters),
						PhotosetsModel.class);
		return forObject;
	}

	public PhotosetModel getPhotos(String photosetId, String page,
			String perPage) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("photoset_id", photosetId);
		parameters.set("page", page);
		parameters.set("per_page", perPage);
		PhotosetModel forObject = (PhotosetModel) this.restTemplate
				.getForObject(
						buildUri(PhotosetsEnum.GET_PHOTOS.getApi(), parameters),
						PhotosetModel.class);
		return forObject;
	}
}