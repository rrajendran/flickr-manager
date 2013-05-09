package com.capella.flickrflow.web.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.PeopleOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capella.flickr.api.entity.Person;
import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.GalleriesModel;
import com.capella.flickr.api.model.PersonModel;
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickr.api.model.PhotosetsModel;

@Controller
public class PeopleController extends BaseFlickrController{
	@Autowired
	Flickr flickr;
	
	@RequestMapping("/template")
	public ModelAndView profile(Principal principal) throws  IOException, FlickrException{
		ModelAndView modelAndView = new ModelAndView("template");
		modelAndView.addObject("formSearch", formSearch);
		modelAndView.addObject("principal", principal);
		return modelAndView;
	}

	@RequestMapping("/profile/{userId}")
	public ModelAndView profile(@PathVariable(value="userId")String userId, 
			HttpServletRequest request,
			HttpServletResponse response,
			Principal principal) throws  IOException, FlickrException{
		ModelAndView model = new ModelAndView("profile");;
		model.addObject("formSearch", formSearch);
		model.addObject("principal", principal);

		PersonModel personModel = flickr.getPeopleOperations().getPersonProfile(userId);
		model.addObject("personModel", personModel);
		
		PhotosModel photoStream = flickr.getPeopleOperations().getPublicPhotos(userId,"1", "6");
		model.addObject("photoStream", photoStream);
		
		GalleriesModel galleries = flickr.getGalleriesOperations().getList(userId, "1", "4");
		model.addObject("galleries", galleries);
		
		PhotosetsModel photoSets = flickr.getPhotosetsOperations().getList(userId , "1", "6");
		model.addObject("photoSets", photoSets);
		
		return model;
	}

	@RequestMapping("/getPublicPhotos")
	public ModelAndView getPublicPhotos(@RequestParam(value="user_id",required=true)String userId, 
			HttpServletRequest request,
			HttpServletResponse response,
			Principal principal) throws  IOException{
		ModelAndView model = new ModelAndView("photos");;
		model.addObject("formSearch", formSearch);
		model.addObject("principal", principal);

		PeopleOperations peopleOperations = flickr.getPeopleOperations();
		
		PhotosModel photoSearch = peopleOperations.getPublicPhotos(userId);
		
		PersonModel info = peopleOperations.getPersonProfile(userId);

		Person person = info.getPerson();

		model.addObject("title", person.getRealname() == null? person.getUsername().get_content() : person.getUsername().get_content());
		model.addObject("person", person);
		model.addObject("photos", photoSearch);

		return model;
	}
}
