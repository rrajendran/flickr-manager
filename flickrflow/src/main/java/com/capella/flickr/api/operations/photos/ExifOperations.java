package com.capella.flickr.api.operations.photos;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.capella.flickr.api.enums.PhotosEnum;
import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.ExifModel;
import com.capella.flickr.api.operations.base.BaseFlickrTemplate;

@Component
public class ExifOperations extends BaseFlickrTemplate{
	public ExifModel getExif(Class<ExifModel> clazz, Map<String, Object> parameters) throws FlickrException {
		parameters.put("method", PhotosEnum.GET_EXIF.getApi());
		return execute(clazz, parameters);
	}
	public ExifModel getInfo(Class<ExifModel> clazz, Map<String, Object> parameters) throws FlickrException {
		parameters.put("method", PhotosEnum.GET_INFO.getApi());
		return execute(clazz, parameters);
	}
}

