package com.capella.flickrflow.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends BaseFlickrController{
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoginController.class);
	@RequestMapping(value = { "/index", "/" })
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		model.put("formSearch", formSearch);
		//return "redirect:/explore?date=" + DateUtils.format(DateTime.now(), null);
		return "redirect:/login";
	}

	@RequestMapping(value = { "/login"})
	public String login(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		model.put("formSearch", formSearch);
		return "login";
	}
	@RequestMapping(value = { "/flatdesign"})
	public String flatDesign(){
		return "flatdesign";
	}
}