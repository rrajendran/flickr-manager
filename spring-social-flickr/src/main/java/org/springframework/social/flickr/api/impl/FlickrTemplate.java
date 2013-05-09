package org.springframework.social.flickr.api.impl;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.flickr.api.CommentsOperations;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.GalleriesOperations;
import org.springframework.social.flickr.api.PeopleOperations;
import org.springframework.social.flickr.api.PhotosetsOperations;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.stereotype.Service;

@Service
public class FlickrTemplate extends AbstractOAuth1ApiBinding implements Flickr {
	private PeopleOperations peopleOperations;
	private GalleriesOperations galleriesOperations;
	private PhotosetsOperations photosetsOperations;
	private CommentsOperations commentsOperations;

	public FlickrTemplate() {
	}

	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		return super.getJsonMessageConverter();
	}

	public FlickrTemplate(String consumerKey, String consumerSecret,
			String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		initOperations(consumerKey, accessToken);
	}

	private void initOperations(String consumerKey, String accessToken) {
		this.peopleOperations = new PeopleTemplate(getRestTemplate(), true,
				consumerKey, accessToken);
		this.galleriesOperations = new GalleriesTemplate(getRestTemplate(),
				true, consumerKey, accessToken);
		this.photosetsOperations = new PhotosetsTemplate(getRestTemplate(),
				true, consumerKey, accessToken);
		this.commentsOperations = new CommentsTemplate(getRestTemplate(), true,
				consumerKey, accessToken);
	}

	public PeopleOperations getPeopleOperations() {
		return this.peopleOperations;
	}

	public GalleriesOperations getGalleriesOperations() {
		return this.galleriesOperations;
	}

	public PhotosetsOperations getPhotosetsOperations() {
		return this.photosetsOperations;
	}

	public CommentsOperations getCommentsOperations() {
		return this.commentsOperations;
	}
}