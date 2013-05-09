package com.capella.flickr.httpmessageconverters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonConvertor implements HttpMessageConverter<Object>{

	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		return true;
	}

	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		return false;
	}

	public List<MediaType> getSupportedMediaTypes() {
		
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		return mediaTypes;
	}


	public Object read(Class<? extends Object> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		mapper.configure(MapperFeature.USE_ANNOTATIONS, true);
		return mapper.readValue(inputMessage.getBody(), clazz);
	}

	public void write(Object t, MediaType contentType,
			HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {
		// TODO Auto-generated method stub
		
	}
}
