package com.capella.flickr.api.operations.cameras;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.capella.flickr.api.enums.Cameras;
import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.BrandModelsModel;
import com.capella.flickr.api.model.BrandsModel;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/capella/flickr/applicationContext.xml")
public class CamerasOperationsImplTest {
	@Autowired
	CamerasOperations camerasOperations;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	public void testGetBrands() throws FlickrException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		BrandsModel brands = camerasOperations.getBrands(parameters );
		assertEquals("ok", brands.getStat());
	}

	@Test
	@Ignore
	public void testGetBrandModels() throws FlickrException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("brand", "canon");
		
		ResponseEntity<BrandModelsModel> forEntity = restTemplate.getForEntity("http://www.flickr.com/services/rest/" +
				"?api_key=8a13dee6ee18863a0112f99206b78b69&nojsoncallback=1" +
				"&brand=canon&method=flickr.cameras.getBrandModels&format=json&"
				, BrandModelsModel.class);
		//BrandModelsModel brands = camerasOperations.getBrandModels(parameters );
		System.out.println(forEntity.getBody());
	}

}
