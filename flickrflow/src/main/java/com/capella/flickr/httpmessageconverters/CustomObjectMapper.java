package com.capella.flickr.httpmessageconverters;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component("jacksonObjectMapper")
public class CustomObjectMapper extends ObjectMapper
{
	@Override
	public ObjectMapper configure(SerializationFeature f, boolean state) {
		return super.configure(f, state);
	}


}