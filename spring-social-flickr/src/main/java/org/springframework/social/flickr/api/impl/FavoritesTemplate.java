package org.springframework.social.flickr.api.impl;

import org.apache.log4j.Logger;
import org.springframework.social.flickr.api.AbstractFlickrOperations;
import org.springframework.social.flickr.api.FavoritesOperations;
import org.springframework.web.client.RestTemplate;

import com.capella.flickr.api.entity.Stats;
import com.capella.flickr.api.enums.Favourites;
import com.capella.flickr.api.model.PhotosModel;

public class FavoritesTemplate extends AbstractFlickrOperations implements
		FavoritesOperations {
	private static final Logger LOGGER = Logger.getLogger(FavoritesTemplate.class);
	private final RestTemplate restTemplate;

	public FavoritesTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser, String consumerKey, String accessToken) {
		super(isAuthorizedForUser, consumerKey, accessToken);
		this.restTemplate = restTemplate;
	}

	public boolean add(String photoId) {
		requireAuthorization();
		Stats stats = this.restTemplate.getForObject(
				buildUri(Favourites.ADD.getApi(),"photo_id",photoId), Stats.class);
		return stats.getStat().equals("ok");
	}

	public PhotosModel getList(String userId, String minFaveDate,
			String maxFaveDate, String extras, String perPage, String page) {
		requireAuthorization();
		return this.restTemplate.getForObject(
				buildUri(Favourites.GET_LIST.getApi(),"userId",userId), PhotosModel.class);
	}

	public PhotosModel getPublicList(String userId, String minFaveDate,
			String maxFaveDate, String extras, String perPage, String page) {
		requireAuthorization();
		return this.restTemplate.getForObject(
				buildUri(Favourites.GET_PUBLIC_LIST.getApi(),"userId",userId), PhotosModel.class);
	}

	public boolean remove(String photoId) {
		requireAuthorization();
		Stats stats = this.restTemplate.getForObject(
				buildUri(Favourites.REMOVE.getApi(),"photo_id", photoId), Stats.class);
		return stats.getStat().equals("ok");
	}

	
	
}