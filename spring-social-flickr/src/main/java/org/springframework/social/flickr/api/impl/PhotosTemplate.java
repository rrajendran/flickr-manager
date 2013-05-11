package org.springframework.social.flickr.api.impl;

import org.apache.log4j.Logger;
import org.springframework.social.flickr.api.AbstractFlickrOperations;
import org.springframework.social.flickr.api.PhotosOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.capella.flickr.api.entity.Stats;
import com.capella.flickr.api.enums.Favourites;
import com.capella.flickr.api.enums.PhotosEnum;
import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.ExifModel;
import com.capella.flickr.api.model.PhotoInfoModel;
import com.capella.flickr.api.model.PhotosModel;

public class PhotosTemplate extends AbstractFlickrOperations implements
		PhotosOperations {
	private static final Logger LOGGER = Logger.getLogger(PhotosTemplate.class);
	private final RestTemplate restTemplate;

	public PhotosTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser, String consumerKey, String accessToken) {
		super(isAuthorizedForUser, consumerKey, accessToken);
		this.restTemplate = restTemplate;
	}

	public PhotosModel search(String tags)
			throws FlickrException {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("tags", tags);
		PhotosModel photosModel = this.restTemplate.getForObject(
				buildUri(PhotosEnum.SEARCH.getApi(),parameters), PhotosModel.class);
		
		return photosModel;
	}

	public PhotosModel getRecent()
			throws FlickrException {
		return this.restTemplate.getForObject(
				buildUri(PhotosEnum.GET_RECENT.getApi()), PhotosModel.class);
	}

	public PhotoInfoModel getInfo(String photoId)
			throws FlickrException {
		requireAuthorization();
		
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("photo_id", photoId);
		
		return this.restTemplate.getForObject(
				buildUri(PhotosEnum.GET_INFO.getApi(), parameters), PhotoInfoModel.class);
	}

	public PhotosModel getWithGeoData()
			throws FlickrException {
		requireAuthorization();
		return this.restTemplate.getForObject(
				buildUri(PhotosEnum.GET_WITH_GEO_DATA.getApi()), PhotosModel.class);
	}

	public ExifModel getExif(String photoId) throws FlickrException {
		requireAuthorization();
		try {
			return this.restTemplate
					.getForObject(
							buildUri(PhotosEnum.GET_EXIF.getApi(), "photo_id",
									photoId), ExifModel.class);
		} catch (Exception e) {
			LOGGER.error("Permission denied to view exif");
		}
		return new ExifModel();
	}
	
}