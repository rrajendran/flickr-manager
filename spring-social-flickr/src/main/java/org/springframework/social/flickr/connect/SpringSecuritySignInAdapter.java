package org.springframework.social.flickr.connect;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.support.OAuth1Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

@Service("springSecuritySignInAdapter")
public class SpringSecuritySignInAdapter implements SignInAdapter {
	public String signIn(String localUserId, Connection<?> connection,
			NativeWebRequest request) {
		OAuth1Connection oauth = (OAuth1Connection) connection;
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken(localUserId, null,
						getGrantedAuthorities()));
		return "/explore";
	}

	public static List<GrantedAuthority> getGrantedAuthorities() {
		List authorities = new ArrayList();

		String[] roles = { "ROLE_USER" };
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}