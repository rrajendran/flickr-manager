package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Comments;
import com.capella.flickr.api.entity.Stats;

public class PhotoCommentsModel extends Stats{
	private static final long serialVersionUID = 8829290744410832668L;
	Comments comments;

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}
}
