package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.AbstractFlickrOperations;
import org.springframework.social.flickr.api.PeopleOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.capella.flickr.api.enums.PeopleEnum;
import com.capella.flickr.api.enums.TestEnum;
import com.capella.flickr.api.model.GroupsModel;
import com.capella.flickr.api.model.PersonModel;
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickr.api.model.UserModel;

public class PeopleTemplate extends AbstractFlickrOperations implements
		PeopleOperations {
	private final RestTemplate restTemplate;

	public PeopleTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser, String consumerKey, String accessToken) {
		super(isAuthorizedForUser, consumerKey, accessToken);
		this.restTemplate = restTemplate;
	}

	public String getProfileId() {
		requireAuthorization();
		UserModel userModel = (UserModel) this.restTemplate.getForObject(
				buildUri(TestEnum.TEST_LOGIN.getApi()), UserModel.class);
		if (userModel != null) {
			return userModel.getUser().getId();
		}
		return null;
	}

	public PersonModel getPersonProfile() {
		try {
			requireAuthorization();
			MultiValueMap parameters = new LinkedMultiValueMap();
			parameters.set("user_id", getProfileId());
			return (PersonModel) this.restTemplate.getForObject(
					buildUri(PeopleEnum.GET_INFO.getApi(), parameters),
					PersonModel.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PersonModel getPersonProfile(String userId) {
		try {
			requireAuthorization();
			return (PersonModel) this.restTemplate.getForObject(
					buildUri(PeopleEnum.GET_INFO.getApi(), "user_id", userId),
					PersonModel.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserModel findByEmail(String emailId) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("find_email", emailId);
		UserModel forObject = (UserModel) this.restTemplate.getForObject(
				buildUri(PeopleEnum.GET_INFO.getApi(), parameters),
				UserModel.class);
		return forObject;
	}

	public PhotosModel getPublicPhotos(String userId) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("user_id", userId);
		PhotosModel forObject = (PhotosModel) this.restTemplate.getForObject(
				buildUri(PeopleEnum.GET_PUBLIC_PHOTOS.getApi(), parameters),
				PhotosModel.class);
		return forObject;
	}

	public UserModel getUserByUserName(String userName) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("username", userName);
		UserModel forObject = (UserModel) this.restTemplate.getForObject(
				buildUri(PeopleEnum.FIND_BY_USERNAME.getApi(), parameters),
				UserModel.class);
		return forObject;
	}

	public GroupsModel getGroups(String userId) {
		requireAuthorization();
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("user_id", userId);
		GroupsModel forObject = (GroupsModel) this.restTemplate.getForObject(
				buildUri(PeopleEnum.GET_GROUPS.getApi(), parameters),
				GroupsModel.class);
		return forObject;
	}

	public GroupsModel getPublicGroups(String userId) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("user_id", userId);
		GroupsModel forObject = (GroupsModel) this.restTemplate.getForObject(
				buildUri(PeopleEnum.GET_GROUPS.getApi(), parameters),
				GroupsModel.class);
		return forObject;
	}

	public PhotosModel getPhotos(String userId) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("user_id", userId);
		PhotosModel forObject = (PhotosModel) this.restTemplate.getForObject(
				buildUri(PeopleEnum.GET_PHOTOS.getApi(), parameters),
				PhotosModel.class);
		return forObject;
	}

	public PhotosModel getPhotosOf(String userId) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("user_id", userId);
		PhotosModel forObject = (PhotosModel) this.restTemplate.getForObject(
				buildUri(PeopleEnum.GET_PHOTOS_OF.getApi(), parameters),
				PhotosModel.class);
		return forObject;
	}

	public PhotosModel getPublicPhotos(String userId, String page,
			String perPage) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set("user_id", userId);
		parameters.set("page", page);
		parameters.set("per_page", perPage);
		PhotosModel forObject = (PhotosModel) this.restTemplate.getForObject(
				buildUri(PeopleEnum.GET_PUBLIC_PHOTOS.getApi(), parameters),
				PhotosModel.class);
		return forObject;
	}
}