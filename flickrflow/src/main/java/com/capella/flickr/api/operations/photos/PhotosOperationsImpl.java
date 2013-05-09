package com.capella.flickr.api.operations.photos;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.capella.flickr.api.enums.PhotosEnum;
import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.PhotoInfoModel;
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickr.api.operations.base.BaseFlickrTemplate;

@Component
public class PhotosOperationsImpl extends BaseFlickrTemplate implements PhotosOperations{
	
	public PhotosModel search(Map<String, Object> parameters)
			throws FlickrException {
		parameters.put("method", PhotosEnum.SEARCH.getApi());
		return execute(PhotosModel.class, parameters);
	}

	public PhotosModel getRecent(Map<String, Object> parameters)
			throws FlickrException {
		parameters.put("method", PhotosEnum.GET_RECENT.getApi());
		return execute(PhotosModel.class, parameters);
	}
	
	public PhotoInfoModel getInfo(Map<String, Object> parameters)
			throws FlickrException {
		parameters.put("method", PhotosEnum.GET_INFO.getApi());
		PhotoInfoModel execute = execute(PhotoInfoModel.class, parameters);
		return execute;
	}

	public PhotosModel getWithGeoData(Map<String, Object> parameters) throws FlickrException {
		parameters.put("method", PhotosEnum.GET_WITH_GEO_DATA.getApi());
		return execute(PhotosModel.class, parameters);
	}

}

