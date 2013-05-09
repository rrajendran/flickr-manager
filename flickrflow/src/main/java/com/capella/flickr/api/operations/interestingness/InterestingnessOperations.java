package com.capella.flickr.api.operations.interestingness;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.capella.flickr.api.enums.Interestingness;
import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickr.api.operations.base.BaseFlickrTemplate;

@Component
public class InterestingnessOperations extends BaseFlickrTemplate{
	
	
	public PhotosModel getList(Class<PhotosModel> class1,
			Map<String, Object> parameters) throws FlickrException {
		if(!parameters.containsKey("per_page"))
			parameters.put("per_page", 500);
		parameters.put("method", Interestingness.GET_LIST.getApi());
		PhotosModel photosModel = super.execute(class1, parameters);
		return photosModel;
	}

	
}
