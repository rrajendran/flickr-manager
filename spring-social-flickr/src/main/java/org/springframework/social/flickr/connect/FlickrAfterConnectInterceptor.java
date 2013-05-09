package org.springframework.social.flickr.connect;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.web.ConnectInterceptor;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.WebRequest;

public class FlickrAfterConnectInterceptor implements
		ConnectInterceptor<Flickr> {
	public void postConnect(Connection<Flickr> arg0, WebRequest arg1) {
		arg0.updateStatus("I've connected with the Spring Social Showcase!");
	}

	public void preConnect(ConnectionFactory<Flickr> arg0,
			MultiValueMap<String, String> arg1, WebRequest arg2) {
	}
}