package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Comment;
import com.capella.flickr.api.entity.Comments;
import com.capella.flickr.api.entity.Stats;

public class AddCommentModel extends Stats{
	private static final long serialVersionUID = 8829290744410832668L;
	Comment comment;
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
