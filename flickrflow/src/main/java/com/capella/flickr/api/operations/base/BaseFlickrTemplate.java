package com.capella.flickr.api.operations.base;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.BrandModelsModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseFlickrTemplate {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseFlickrTemplate.class);
	private static final String API_KEY = "8a13dee6ee18863a0112f99206b78b69";
	public String apiKey;
	public String restUrl;
	public String apiName;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	public BaseFlickrTemplate() {
		this.restUrl = "http://www.flickr.com/services/rest/?";
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getRestUrl() {
		return restUrl;
	}
	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String buildUrl( Map<String,Object> parameters){
		StringBuffer buffer = new StringBuffer();
		parameters.put("format", "json");
		parameters.put("nojsoncallback", "1");
		buffer.append(getRestUrl());
		buffer.append("api_key").append("=").append(API_KEY).append("&");
		Set<String> keys = parameters.keySet();
		for (String key : keys) {
			buffer.append(key).append("=").append(parameters.get(key)).append("&");
		}
		String url = buffer.toString();
		LOGGER.debug(url);
		return url;

	}
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T execute(Class<T> clazz, Map<String,Object> parameters) throws FlickrException{
		Object obj = null;
		try {
			obj = getRestTemplate().getForObject(buildUrl(parameters), clazz);
			LOGGER.trace(new ObjectMapper().writeValueAsString(obj));
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return (T) obj;
	}
	
}
