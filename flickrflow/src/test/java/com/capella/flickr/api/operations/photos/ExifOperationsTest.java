package com.capella.flickr.api.operations.photos;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capella.flickr.api.enums.PhotosEnum;
import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.ExifModel;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/capella/flickr/applicationContext.xml")
public class ExifOperationsTest {
	
	@Autowired
	private ExifOperations exifOperations;
	@Test
	public void testGetExif() throws FlickrException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("method", PhotosEnum.GET_EXIF.getApi());
		parameters.put("photo_id", "8609774035");
		ExifModel photo = exifOperations.getExif(ExifModel.class, parameters );
		assertEquals("ok",photo.getStat());
	}
	
	
}
