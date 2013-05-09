package com.capella.flickr.api.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentsMixin {
	@JsonProperty("photo_id") String photoId;
}
