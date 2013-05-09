package org.springframework.social.flickr.connect;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Component;

@Component("flickrConnectionSignUp")
public class FlickrConnectionSignUp implements ConnectionSignUp {
	private static final org.slf4j.Logger LOGGER = LoggerFactory
			.getLogger(FlickrConnectionSignUp.class);

	public String execute(Connection<?> connection) {
		UserProfile fetchUserProfile = connection.fetchUserProfile();

		return fetchUserProfile.getUsername();
	}

	public static List<GrantedAuthority> getGrantedAuthorities() {
		List authorities = new ArrayList();

		String[] roles = { "USER_ROLE", "ADMIN_ROLE" };
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}