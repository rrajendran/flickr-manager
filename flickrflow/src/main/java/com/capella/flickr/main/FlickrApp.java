package com.capella.flickr.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capella.flickr.api.enums.PhotosEnum;
import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickr.api.operations.photos.PhotosOperationsImpl;

public class FlickrApp {
	public static void main(String[] args) throws FlickrException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/com/capella/flickr/applicationContext.xml",FlickrApp.class);
		PhotosOperationsImpl photosOperationsImpl = applicationContext.getBean(PhotosOperationsImpl.class);
		Map<String, Object> parameters = new HashMap<String,Object>();
		parameters.put("method", PhotosEnum.SEARCH.getApi());
		parameters.put("tags", "london");
		parameters.put("per_page", "1");
		PhotosModel search = photosOperationsImpl.search(parameters);
		System.out.println(search);

		
	}
}
