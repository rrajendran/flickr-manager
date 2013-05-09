package org.springframework.social.flickr.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.oauth1.OAuthToken;

public class FlickrConnectionFactory extends OAuth1ConnectionFactory<Flickr> {
	public FlickrConnectionFactory(String clientId, String clientSecret) {
		super("flickr", new FlickrServiceProvider(clientId, clientSecret),
				new FlickrAdapter());
	}

	protected String extractProviderUserId(OAuthToken accessToken) {
		return accessToken.getSecret();
	}
}