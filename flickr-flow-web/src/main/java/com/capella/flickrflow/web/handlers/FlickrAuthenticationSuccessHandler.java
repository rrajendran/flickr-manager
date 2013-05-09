package com.capella.flickrflow.web.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;


public class FlickrAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(FlickrAuthenticationSuccessHandler.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
					throws ServletException, IOException {
		User principal = (User) authentication.getPrincipal();
		LOGGER.info("Principal :" +principal);
		response.addCookie(createCookie("username", principal.getUsername()));
		response.addCookie(createCookie("roles", getRoles(authentication.getAuthorities())));
		response.addCookie(createCookie("token", RandomStringUtils.randomAlphanumeric(128)));
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	/**
	 * User roles
	 * @param collection
	 * @return
	 */
	private String getRoles(Collection<? extends GrantedAuthority> collection) {
		
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority grantedAuthority : collection) {
			roles.add(grantedAuthority.getAuthority());
		}
		
		return StringUtils.join(roles, ",");
	}

	/**
	 * Create cookie
	 * @param request
	 * @param paramName
	 * @return
	 */
	private javax.servlet.http.Cookie createCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(-1);
		return cookie;
	}
}
