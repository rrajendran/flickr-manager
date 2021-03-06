package com.capella.flickrflow.web.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.flickr.api.CommentsOperations;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.AddCommentModel;
import com.capella.flickr.api.model.ExifModel;
import com.capella.flickr.api.model.PersonModel;
import com.capella.flickr.api.model.PhotoCommentsModel;
import com.capella.flickr.api.model.PhotoInfoModel;
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickrflow.web.command.FormSearch;

@Controller
public class PhotosController extends BaseFlickrController {
	@Autowired
	Flickr flickr;
	
/*	@Inject
	public PhotosController(ConnectionRepository connectionRepository){
		flickr = connectionRepository.getPrimaryConnection(Flickr.class).getApi();
	}*/
	
	@RequestMapping(value = "/search", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView getList(
			@RequestParam(value = "page", required = false) Integer page,
			HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("formSearch") FormSearch formSearch,
			Principal principal) throws IOException {
		ModelAndView modelAndView = new ModelAndView("photos");
		addPageObjects(modelAndView, page);
		modelAndView.addObject("principal", principal);
		try {
			String text = request.getParameter("text");
			text = text == null ? formSearch.getText() : text;
			PhotosModel photoSearch = flickr.getPhotosOperations().search(text);
			modelAndView.addObject("photos", photoSearch);
		} catch (FlickrException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/recentPhotos")
	public ModelAndView recentPhotos(
			@RequestParam(value = "page", required = false) Integer page,
			HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws IOException {
		ModelAndView modelAndView = new ModelAndView("photos");
		addPageObjects(modelAndView, page);
		modelAndView.addObject("title", "Recent photos");
		modelAndView.addObject("formSearch", formSearch);
		modelAndView.addObject("principal", principal);
		try {
			PhotosModel photoSearch = flickr.getPhotosOperations().getRecent();
			modelAndView.addObject("photos", photoSearch);
		} catch (FlickrException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/getWithGeoData")
	public ModelAndView getWithGeoData(
			@RequestParam(value = "page", required = false) Integer page,
			HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws IOException {
		ModelAndView modelAndView = new ModelAndView("photos");
		addPageObjects(modelAndView, page);
		modelAndView.addObject("title", "Geotagged photos");
		modelAndView.addObject("formSearch", formSearch);
		modelAndView.addObject("principal", principal);
		try {
			PhotosModel photoSearch = flickr.getPhotosOperations()
					.getWithGeoData();
			modelAndView.addObject("photos", photoSearch);
		} catch (FlickrException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/exif")
	public ModelAndView getExif(
			@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws IOException {
		ModelAndView model = new ModelAndView("exif");
		;
		model.addObject("formSearch", formSearch);
		model.addObject("principal", principal);
		try {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("photo_id", id);

			ExifModel photo =flickr.getPhotosOperations().getExif(id);
			model.addObject("exifWrapper", photo);

			PhotoInfoModel info = flickr.getPhotosOperations().getInfo(id);
			model.addObject("info", info);

		} catch (FlickrException e) {
			e.printStackTrace();
		}
		return model;
	}
	@RequestMapping(value="/addComments/{photoId}/{comments}",method=RequestMethod.GET)
	public @ResponseBody AddCommentModel addComments(@PathVariable("photoId")String photoId, 
			@PathVariable("comments")String comments){
		CommentsOperations commentsOperations = flickr.getCommentsOperations();
		return commentsOperations.addComments(photoId, comments);
	}
	
	@RequestMapping(value="/editComments/{photoId}/{comments}",method=RequestMethod.GET)
	public @ResponseBody String editComments(@PathVariable("photoId")String photoId, 
			@PathVariable("comments")String comments){
		CommentsOperations commentsOperations = flickr.getCommentsOperations();
		return commentsOperations.editComments(photoId, comments);
	}
	
	@RequestMapping(value="/deleteComments/{commentId}",method=RequestMethod.GET)
	public @ResponseBody String deleteComments(@PathVariable("commentId")String commentId){
		CommentsOperations commentsOperations = flickr.getCommentsOperations();
		return commentsOperations.deleteComments(commentId);
	}
	
	@RequestMapping(value="/view/addToFavourite/{photoId}",method=RequestMethod.GET)
	public @ResponseBody boolean addToFavourite(@PathVariable("photoId")String photoId){
		return flickr.getFavoritesOperations().add(photoId);
	}
	
	@RequestMapping(value="/view/removeFromFavourite/{photoId}",method=RequestMethod.GET)
	public @ResponseBody boolean removeFromFavourite(@PathVariable("photoId")String photoId){
		return flickr.getFavoritesOperations().remove(photoId);
	}
	
	@RequestMapping("/view")
	public ModelAndView viewPhoto(
			@RequestParam(value = "id", required = true) String id,
			HttpServletRequest request, HttpServletResponse response,
			Principal principal) throws IOException {
		ModelAndView model = new ModelAndView("view");
		model.addObject("formSearch", formSearch);
		model.addObject("principal", principal);
		try {
			buildViewPage(id, model);
			
		} catch (FlickrException e) {
			e.printStackTrace();
		}
		return model;
	}

	private void buildViewPage(String id, ModelAndView model)
			throws FlickrException {
		ExifModel photo = flickr.getPhotosOperations().getExif(id);
		model.addObject("exifWrapper", photo);

		PhotoInfoModel info = flickr.getPhotosOperations().getInfo(id);
		model.addObject("info", info);
		
		PhotoCommentsModel comments = flickr.getCommentsOperations().getList(id);
		model.addObject("comments", comments);
		
		String ownerId = info.getPhoto().getOwner().getNsid();
		PersonModel person = flickr.getPeopleOperations().getPersonProfile(ownerId);
		model.addObject("person", person);
	}
}
