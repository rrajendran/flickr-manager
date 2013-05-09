package org.springframework.social.flickr.connect;

import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.impl.FlickrTemplate;
import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;

public final class FlickrServiceProvider extends
		AbstractOAuth1ServiceProvider<Flickr> {
	public FlickrServiceProvider(String consumerKey, String consumerSecret) {
		super(consumerKey, consumerSecret, new OAuth1Template(consumerKey,
				consumerSecret,
				"http://www.flickr.com/services/oauth/request_token",
				"http://www.flickr.com/services/oauth/authorize",
				"http://www.flickr.com/services/oauth/access_token"));
	}

	public Flickr getApi(String accessToken, String secret) {
		return new FlickrTemplate(getConsumerKey(), getConsumerSecret(),
				accessToken, secret);
	}
}