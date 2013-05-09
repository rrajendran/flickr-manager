package org.springframework.social.flickr.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.web.client.HttpClientErrorException;

import com.capella.flickr.api.model.PersonModel;

public class FlickrAdapter implements ApiAdapter<Flickr> {
	public boolean test(Flickr flickr) {
		try {
			String profileId = flickr.getPeopleOperations().getProfileId();
			if (profileId != null)
				return true;
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public UserProfile fetchUserProfile(Flickr api) {
		PersonModel flickrProfile = api.getPeopleOperations()
				.getPersonProfile();
		System.out.println("****************" + flickrProfile);
		UserProfileBuilder userProfileBuilder = new UserProfileBuilder();
		userProfileBuilder.setFirstName(flickrProfile.getPerson().getRealname()
				.get_content());
		userProfileBuilder.setUsername(flickrProfile.getPerson().getNsid());
		return userProfileBuilder.build();
	}

	public void setConnectionValues(Flickr flickr, ConnectionValues values) {
		PersonModel personModel = flickr.getPeopleOperations()
				.getPersonProfile();
		values.setProviderUserId(personModel.getPerson().getNsid());
		values.setDisplayName(personModel.getPerson().getRealname()
				.get_content());
		values.setProfileUrl(personModel.getPerson().getProfileurl()
				.get_content());
		values.setImageUrl(personModel.getPerson().getBuddyIcon());
	}

	public void updateStatus(Flickr flickr, String message) {
		throw new UnsupportedOperationException();
	}
}