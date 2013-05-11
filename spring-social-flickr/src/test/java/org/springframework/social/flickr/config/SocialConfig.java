package org.springframework.social.flickr.config;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.flickr.api.Flickr;

@Configuration
public class SocialConfig {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SocialConfig.class);
	@Autowired
	ConnectionRepository connectionRepository;
	
	@Bean
    @Inject
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public Flickr flickr(HttpServletRequest request) {
		LOGGER.debug("Creating flickr bean");
	    return connectionRepository.getPrimaryConnection(Flickr.class).getApi();
	}
}
