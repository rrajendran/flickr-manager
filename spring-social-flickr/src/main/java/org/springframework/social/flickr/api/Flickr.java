package org.springframework.social.flickr.api;


public abstract interface Flickr {
	public abstract PeopleOperations getPeopleOperations();

	public abstract GalleriesOperations getGalleriesOperations();

	public abstract PhotosetsOperations getPhotosetsOperations();

	public abstract CommentsOperations getCommentsOperations();
	
	public abstract PhotosOperations getPhotosOperations();
	
	public abstract FavoritesOperations getFavoritesOperations();
}