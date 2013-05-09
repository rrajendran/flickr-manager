package com.capella.flickr.api.entity;

import java.util.List;


public class Comments {
	String photo_id;
	String photoset_id;
	List<Comment> comment;
	public String getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	public String getPhotoset_id() {
		return photoset_id;
	}
	public void setPhotoset_id(String photoset_id) {
		this.photoset_id = photoset_id;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	
	
}
