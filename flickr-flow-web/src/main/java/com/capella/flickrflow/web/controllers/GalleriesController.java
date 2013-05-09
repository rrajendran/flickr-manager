package com.capella.flickrflow.web.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.GalleriesModel;
import com.capella.flickr.api.model.PersonModel;

@Controller
public class GalleriesController extends BaseFlickrController{
	@Autowired
	Flickr flickr;
	private String page = "1";
	private String perPage = "500";
	

	@RequestMapping("/galleries/{userId}")
	public ModelAndView profile(@PathVariable(value="userId")String userId, 
			HttpServletRequest request,
			HttpServletResponse response,
			Principal principal) throws  IOException, FlickrException{
		ModelAndView model = new ModelAndView("galleries");;
		model.addObject("formSearch", formSearch);
		GalleriesModel galleriesModel = flickr.getGalleriesOperations().getList(userId, page, perPage);
		model.addObject("galleriesModel", galleriesModel);
		
		PersonModel person = flickr.getPeopleOperations().getPersonProfile(userId);
		model.addObject("person", person.getPerson());
		
		model.addObject("principal", principal);
		return model;
	}
	
}
