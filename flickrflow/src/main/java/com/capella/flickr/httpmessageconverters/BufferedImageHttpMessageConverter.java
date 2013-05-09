package com.capella.flickr.httpmessageconverters;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

public class BufferedImageHttpMessageConverter implements HttpMessageConverter<BufferedImage> {

	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		return true;
	}

	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		return false;
	}

	public List<MediaType> getSupportedMediaTypes() {
		 return Collections.singletonList(new MediaType("image", "jpeg"));

	}

	public BufferedImage read(Class<? extends BufferedImage> clazz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		 return ImageIO.read(inputMessage.getBody());
	}

	public void write(BufferedImage t, MediaType contentType,
			HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {
		 throw new UnsupportedOperationException("Not implemented");
	}
}
