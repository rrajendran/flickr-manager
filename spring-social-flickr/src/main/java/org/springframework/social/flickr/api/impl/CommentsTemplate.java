package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.AbstractFlickrOperations;
import org.springframework.social.flickr.api.CommentsOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.capella.flickr.api.enums.PhotoCommentsEnum;
import com.capella.flickr.api.model.AddCommentModel;
import com.capella.flickr.api.model.PhotoCommentsModel;
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickr.api.model.PhotosetModel;

public class CommentsTemplate extends AbstractFlickrOperations implements
		CommentsOperations {
	private final RestTemplate restTemplate;

	public CommentsTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser, String consumerKey, String accessToken) {
		super(isAuthorizedForUser, consumerKey, accessToken);
		this.restTemplate = restTemplate;
	}

	public AddCommentModel addComments(String photoId, String comments) {
		try {
			requireAuthorization();
			MultiValueMap parameters = new LinkedMultiValueMap();
			parameters.set("photo_id", photoId);
			parameters.set("comment_text", comments);
			return (AddCommentModel) this.restTemplate.postForObject(
					buildUri(PhotoCommentsEnum.ADD_COMMENT.getApi()),
					parameters, AddCommentModel.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String deleteComments(String commentId) {
		try {
			requireAuthorization();
			MultiValueMap parameters = new LinkedMultiValueMap();
			parameters.set("comment_id", commentId);
			return (String) this.restTemplate.postForObject(
					buildUri(PhotoCommentsEnum.DELETE_COMMENT.getApi()),
					parameters, String.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String editComments(String commentId, String comments) {
		try {
			requireAuthorization();
			MultiValueMap parameters = new LinkedMultiValueMap();
			parameters.set("comment_id", commentId);
			parameters.set("comment_text", comments);
			return (String) this.restTemplate.postForObject(
					buildUri(PhotoCommentsEnum.EDIT_COMMENT.getApi()),
					parameters, String.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PhotoCommentsModel getList(String photoId, String minimumDate,
			String maximumDate) {
		try {
			requireAuthorization();
			MultiValueMap parameters = new LinkedMultiValueMap();
			parameters.set("photo_id", photoId);
			if (minimumDate != null)
				parameters.set("min_comment_date", minimumDate);
			if (maximumDate != null)
				parameters.set("max_comment_date", maximumDate);
			return (PhotoCommentsModel) this.restTemplate.postForObject(
					buildUri(PhotoCommentsEnum.GET_LIST.getApi()), parameters,
					PhotoCommentsModel.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PhotoCommentsModel getList(String photoId, String minimumDate) {
		return getList(photoId, minimumDate, null);
	}

	public PhotoCommentsModel getList(String photoId) {
		return getList(photoId, null, null);
	}

	public PhotosModel getRecentForContacts(String page, String perPage) {
		try {
			requireAuthorization();
			MultiValueMap parameters = new LinkedMultiValueMap();
			parameters.set("page", page);
			parameters.set("per_page ", perPage);
			return (PhotosModel) this.restTemplate
					.postForObject(
							buildUri(PhotoCommentsEnum.GET_RECENT_FOR_CONTACTS
									.getApi()), parameters, PhotosModel.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PhotosetModel getPhotos(String paramString1, String paramString2,
			String paramString3) {
		return null;
	}
}