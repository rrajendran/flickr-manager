package com.capella.flickrflow.web.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capella.flickr.api.operations.interestingness.InterestingnessOperations;
import com.capella.flickrflow.web.command.Settings;

@Controller
public class SettingsController extends BaseFlickrController{
	@Autowired
	private InterestingnessOperations interestingnessOperations;

	@RequestMapping(value="/settings", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView getList(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("settings")Settings settings, BindingResult bindingResult,
			Principal principal) throws IOException{
		ModelAndView modelAndView = new ModelAndView("settings");
		modelAndView.addObject("title", "Settings");
		modelAndView.addObject("formSearch", formSearch);
		modelAndView.addObject("principal", principal);
		return modelAndView;
	}
	@RequestMapping(value="/saveSettings", method={RequestMethod.POST})
	public ModelAndView saveSettings(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("settings")Settings settings, BindingResult bindingResult,
			Principal principal) throws IOException{
		System.out.println(settings);
		ModelAndView modelAndView = new ModelAndView("settings");
		modelAndView.addObject("title", "Settings");
		modelAndView.addObject("formSearch", formSearch);
		modelAndView.addObject("principal", principal);
		return modelAndView;
	}
}
