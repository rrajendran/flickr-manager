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
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickr.api.operations.interestingness.InterestingnessOperations;
import com.capella.flickr.api.utils.DateUtils;

@Controller
public class InterestingnessController extends BaseFlickrController{

	private static final String INTERESTINGNESS_VIEW = "interestingness";
	@Autowired
	private InterestingnessOperations interestingnessOperations;
	private static final String PAGE = "1";
	private static final String PER_PAGE = "35";

	@RequestMapping("/explore")
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
		modelAndView.addObject("title", "Interestingness on ");
		modelAndView.addObject("formSearch", formSearch);
		modelAndView.addObject("principal", principal);
		int currentPage = Integer.parseInt(page);
		int perPageInt = Integer.parseInt(perPage);
		int total = currentPage * perPageInt;

		modelAndView.addObject("currentPage", currentPage);
		if(total <=500 )
			modelAndView.addObject("nextPage", currentPage + 1);
		modelAndView.addObject("prevPage", currentPage - 1);
		try {
			Map<String, Object> parameters =  getQueryParams(request);
			parameters.put("per_page", perPage);
			parameters.put("page", page);
			parameters.put("date", date);
			PhotosModel photoSearch = interestingnessOperations.getList(PhotosModel.class, parameters);
			modelAndView.addObject("photos", photoSearch);
		} catch (FlickrException e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/explore/{date}")
	public ModelAndView exploreDate(@PathVariable("date")String date, 
			HttpServletRequest request,
			HttpServletResponse response,
			Principal principal) throws IOException{
		return explore(date, PAGE, PER_PAGE, request, response, principal);
	}
}
