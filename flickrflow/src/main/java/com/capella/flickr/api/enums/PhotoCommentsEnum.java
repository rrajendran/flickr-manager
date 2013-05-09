package com.capella.flickr.api.enums;

/**
 * 	flickr.photos.comments.addComment
	flickr.photos.comments.deleteComment
	flickr.photos.comments.editComment
	flickr.photos.comments.getList
	flickr.photos.comments.getRecentForContacts
 * @author rrajendran
 *
 */
public enum PhotoCommentsEnum {
	ADD_COMMENT("flickr.photos.comments.addComment"),
	DELETE_COMMENT("flickr.photos.comments.deleteComment"),
	EDIT_COMMENT("flickr.photos.comments.editComment"),
	GET_LIST("flickr.photos.comments.getList"),
	GET_RECENT_FOR_CONTACTS("flickr.photos.comments.getRecentForContacts");
	
	private String api;

	PhotoCommentsEnum(String api) {
		this.api = api;
	}

	public String getApi() {
		return api;
	}
	
}
