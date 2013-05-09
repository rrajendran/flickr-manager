package com.capella.flickrflow.web.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.web.servlet.ModelAndView;

import com.capella.flickrflow.web.command.FormSearch;

public class BaseFlickrController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BaseFlickrController.class);
	@Autowired
	protected Flickr flickr;
	
	@Autowired
	protected FormSearch formSearch;
	
	Map<String, Object> flickrModel = new HashMap<String, Object>(5);
	Integer currentPage;
	Integer previousPage;
	Integer nextPage;
	
	
	public BaseFlickrController() {
		initPage();
	}
	
	
	
	private void initPage() {
		currentPage = 1;
		previousPage = null;
		nextPage = 2;
	}

	protected static Map<String, Object> getQueryParams(HttpServletRequest request) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			String url = "?" + request.getQueryString();
			String[] urlParts = url.split("\\?");
			if (urlParts.length > 1) {
				String query = urlParts[1];
				for (String param : query.split("&")) {
					String[] pair = param.split("=");
					String key = URLDecoder.decode(pair[0], "UTF-8");
					if(key != null){
						String value = "";
						if (pair.length > 1) {
							value = URLDecoder.decode(pair[1], "UTF-8");
						}

						String prevValue = (String) params.get(key);
						if (prevValue != null) {
							value += "," + (prevValue);
						}
						params.put(key, value);
					}
				}
			}
			LOGGER.trace("Query params =" + params);
			return params;
		} catch (UnsupportedEncodingException ex) {
			throw new AssertionError(ex);
		}
	}

	protected void addPageObjects(ModelAndView modelAndView, Integer page) {
		if(page != null){
			currentPage = page;
			previousPage = currentPage - 1;
			nextPage = currentPage + 1;
		}
		modelAndView.addObject("currentPage", currentPage);
		modelAndView.addObject("previousPage", previousPage);
		modelAndView.addObject("nextPage", nextPage);
	}
}
