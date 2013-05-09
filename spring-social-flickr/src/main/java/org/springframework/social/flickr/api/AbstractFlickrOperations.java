package org.springframework.social.flickr.api;

import java.net.URI;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class AbstractFlickrOperations {
	private final boolean isAuthorized;
	private final String consumerKey;
	private String accessToken;
	private static final String API_URL_BASE = "http://api.flickr.com/services/rest/";
	private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap();

	public AbstractFlickrOperations(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
		this.consumerKey = null;
	}

	public AbstractFlickrOperations(boolean isAuthorized, String consumerKey,
			String accessToken) {
		this.isAuthorized = isAuthorized;
		this.consumerKey = consumerKey;
		this.accessToken = accessToken;
	}

	protected void requireAuthorization() {
		if (!this.isAuthorized)
			throw new MissingAuthorizationException();
	}

	protected URI buildUri(String methodName) {
		return buildUri(methodName, EMPTY_PARAMETERS);
	}

	protected URI buildUri(String methodName, String parameterName,
			String parameterValue) {
		MultiValueMap parameters = new LinkedMultiValueMap();
		parameters.set(parameterName, parameterValue);
		return buildUri(methodName, parameters);
	}

	protected URI buildUri(String methodName,
			MultiValueMap<String, String> parameters) {
		parameters.set("method", methodName);
		parameters.set("format", "json");
		parameters.set("nojsoncallback", "1");
		parameters.set("api_key", this.consumerKey);

		URI uri = URIBuilder.fromUri("http://api.flickr.com/services/rest/")
				.queryParams(parameters).build();
		return uri;
	}
}