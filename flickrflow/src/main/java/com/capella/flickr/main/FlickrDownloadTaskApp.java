package com.capella.flickr.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capella.flickr.api.exceptions.FlickrException;

public class FlickrDownloadTaskApp {
	public static void main(String[] args) throws FlickrException {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("/com/capella/flickr/jobConfig.xml",FlickrDownloadTaskApp.class);
		applicationContext.registerShutdownHook();
	}
}
