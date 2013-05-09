package com.capella.flickr.api.operations.photos.comments;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.capella.flickr.api.enums.PhotoCommentsEnum;
import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.PhotoCommentsModel;
import com.capella.flickr.api.operations.base.BaseFlickrTemplate;
@Component
public class PhotoCommentsOperationsImpl extends BaseFlickrTemplate implements PhotoCommentsOperations {

	public PhotoCommentsModel getList(Map<String, Object> parameters)
			throws FlickrException {
		parameters.put("method", PhotoCommentsEnum.GET_LIST.getApi());
		if(!parameters.containsKey("photo_id") && parameters.get("photo_id") == null)
			throw new FlickrException("Required parameter 'photo_id' is missing");
		return super.execute(PhotoCommentsModel.class, parameters );
	}

}
