package com.capella.flickrflow.web.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capella.flickr.api.model.PhotosetModel;
import com.capella.flickr.api.model.PhotosetsModel;
import com.capella.flickrflow.web.command.FormSearch;

@Controller
public class PhotosetsController extends BaseFlickrController{
	@Autowired
	private Flickr  flickr;
	
	@RequestMapping(value="/photosets/sets", method={RequestMethod.GET})
	public ModelAndView getList(@RequestParam(value="page", required=false)Integer page,
			@RequestParam(value="nsid", required=true)String userId,
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("formSearch")FormSearch formSearch,
			Principal principal) throws IOException{
		ModelAndView modelAndView = new ModelAndView("photosets");
		modelAndView.addObject("principal", principal);
		addPageObjects(modelAndView,page);
		
		PhotosetsModel photosets = flickr.getPhotosetsOperations().getList(userId,"1","500");
		modelAndView.addObject("photosetsmodel", photosets);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/photosets/sets/{photoSetId}", method={RequestMethod.GET})
	public ModelAndView getPhotos(@RequestParam(value="page", required=false)Integer page,
			@PathVariable("photoSetId")String photoSetId,
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("formSearch")FormSearch formSearch,
			Principal principal) throws IOException{
		ModelAndView modelAndView = new ModelAndView("photosetsphotos");
		addPageObjects(modelAndView,page);
		modelAndView.addObject("principal", principal);

		PhotosetModel photosets = flickr.getPhotosetsOperations().getPhotos(photoSetId,"1","500");
		modelAndView.addObject("photosetmodel", photosets);
		return modelAndView;
	}

	
}
