package org.springframework.social.flickr.api;

import com.capella.flickr.api.model.AddCommentModel;
import com.capella.flickr.api.model.PhotoCommentsModel;
import com.capella.flickr.api.model.PhotosModel;

public abstract interface CommentsOperations {
	public abstract PhotoCommentsModel getList(String paramString1, String paramString2, String paramString3);

	public abstract PhotoCommentsModel getList(String paramString1, String paramString2);

	public abstract PhotoCommentsModel getList(String paramString);

	public abstract AddCommentModel addComments(String paramString1, String paramString2);

	public abstract String editComments(String paramString1, String paramString2);

	public abstract String deleteComments(String paramString);

	public abstract PhotosModel getRecentForContacts(String paramString1, String paramString2);
}