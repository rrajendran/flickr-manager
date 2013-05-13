package com.capella.flickrflow.web.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.ExifModel;
import com.capella.flickr.api.model.PersonModel;
import com.capella.flickr.api.model.PhotoCommentsModel;
import com.capella.flickr.api.model.PhotoInfoModel;
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickr.api.operations.interestingness.InterestingnessOperations;
import com.capella.flickr.api.utils.DateUtils;

@Controller("/explore")
public class InterestingnessController extends BaseFlickrController{

	private static final String INTERESTINGNESS_VIEW = "interestingness";
	@Autowired
	private InterestingnessOperations interestingnessOperations;
	private static final String PAGE = "1";
	private static final String PER_PAGE = "45";

	@RequestMapping("/")
	public String getList(@RequestParam(value="page",required=false)Integer page, 
			@RequestParam(value="date",required=false)String date, 
			HttpServletRequest request,
			HttpServletResponse response,
			Principal principal) throws IOException{
		return "redirect:/explore/" + DateUtils.format(DateTime.now().minusDays(1), null) +"/" + PAGE + "/" + PER_PAGE;
	}

	@RequestMapping("/explore/{date}/{page}/{perPage}")
	public ModelAndView explore(@PathVariable("date")String date, 
			@PathVariable("page")String page,
			@PathVariable("perPage")String perPage,
			HttpServletRequest request,
			HttpServletResponse response,
			Principal principal) throws IOException{
		ModelAndView modelAndView = new ModelAndView(INTERESTINGNESS_VIEW);
		modelAndView.addObject("principal", SecurityContextHolder.getContext().getAuthentication());
		modelAndView.addObject("title", "Explored");
		modelAndView.addObject("formSearch", formSearch);
		modelAndView.addObject("principal", principal);
		
		modelAndView.addObject("date", date);
		modelAndView.addObject("page", page);
		modelAndView.addObject("perPage", perPage);
		
		int currentPage = Integer.parseInt(page);
		int perPageInt = Integer.parseInt(perPage);
		int total = currentPage * perPageInt;

		modelAndView.addObject("currentPage", currentPage);
		if(total <=500 )
			modelAndView.addObject("nextPage", currentPage + 1);
		modelAndView.addObject("prevPage", currentPage - 1);
		try {
			PhotosModel photoSearch = getInterestingnessPhotos(date, page,
					perPage, request);
			modelAndView.addObject("photos", photoSearch);
		} catch (FlickrException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	private PhotosModel getInterestingnessPhotos(String date, String page,
			String perPage, HttpServletRequest request) throws FlickrException {
		Map<String, Object> parameters =  getQueryParams(request);
		parameters.put("per_page", perPage);
		parameters.put("page", page);
		parameters.put("date", date);
		PhotosModel photoSearch = interestingnessOperations.getList(PhotosModel.class, parameters);
		return photoSearch;
	}

	@RequestMapping("/explore/{date}")
	public ModelAndView exploreDate(@PathVariable("date")String date, 
			HttpServletRequest request,
			HttpServletResponse response,
			Principal principal) throws IOException{
		return explore(date, PAGE, PER_PAGE, request, response, principal);
	}
	
	@RequestMapping("/explore/view/{date}/{page}")
	public ModelAndView viewPhoto(@PathVariable("date")String date, 
			@PathVariable("page")String page,
			HttpServletRequest request,
			HttpServletResponse response,
			Principal principal) throws IOException {
		ModelAndView model = new ModelAndView("view");
		model.addObject("formSearch", formSearch);
		model.addObject("principal", principal);
		model.addObject("date", date);
		try {
			PhotosModel interestingnessPhotos = getInterestingnessPhotos(date, page, "1", request);
			String photoId = interestingnessPhotos.getPhotos().getPhoto().get(0).getId();
			buildViewPage(photoId, model);
			model.addObject("nextPage", Integer.parseInt(page) + 1);
			
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
