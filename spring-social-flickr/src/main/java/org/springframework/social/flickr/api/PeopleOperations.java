package org.springframework.social.flickr.api;

import com.capella.flickr.api.model.GroupsModel;
import com.capella.flickr.api.model.PersonModel;
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickr.api.model.UserModel;

public abstract interface PeopleOperations {
	public abstract String getProfileId();

	public abstract PersonModel getPersonProfile();

	public abstract PersonModel getPersonProfile(String paramString);

	public abstract UserModel findByEmail(String paramString);

	public abstract PhotosModel getPublicPhotos(String paramString);

	public abstract PhotosModel getPublicPhotos(String paramString1,
			String paramString2, String paramString3);

	public abstract UserModel getUserByUserName(String paramString);

	public abstract GroupsModel getGroups(String paramString);

	public abstract GroupsModel getPublicGroups(String paramString);

	public abstract PhotosModel getPhotos(String paramString);

	public abstract PhotosModel getPhotosOf(String paramString);
}