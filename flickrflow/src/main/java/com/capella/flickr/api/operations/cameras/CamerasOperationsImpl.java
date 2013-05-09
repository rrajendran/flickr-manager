package com.capella.flickr.api.operations.cameras;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.capella.flickr.api.enums.Cameras;
import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.BrandModelsModel;
import com.capella.flickr.api.model.BrandsModel;
import com.capella.flickr.api.operations.base.BaseFlickrTemplate;

@Component
public class CamerasOperationsImpl extends BaseFlickrTemplate implements CamerasOperations{
	@Autowired
	private RestTemplate restTemplate;

	public BrandsModel getBrands(Map<String, Object> parameters) throws FlickrException {
		parameters.put("method", Cameras.GET_BRANDS.getApi());
		return super.execute(BrandsModel.class, parameters);
	}

	public BrandModelsModel getBrandModels(Map<String, Object> parameters)
			throws FlickrException {
		parameters.put("method", Cameras.GET_BRAND_MODELS.getApi());
		return super.execute(BrandModelsModel.class, parameters);
	}
}
