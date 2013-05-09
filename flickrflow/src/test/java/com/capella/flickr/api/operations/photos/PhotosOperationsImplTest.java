package com.capella.flickr.api.operations.photos;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.PhotoInfoModel;
import com.capella.flickr.api.model.PhotosModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/capella/flickr/applicationContext.xml")
public class PhotosOperationsImplTest {
	@Autowired
	PhotosOperations photosOperations;
	@Test
	public void testSearch() throws FlickrException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tags", "london");
		PhotosModel search = photosOperations.search(parameters );
		assertEquals("ok", search.getStat());
	}

	@Test
	public void testGetRecent() throws FlickrException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		PhotosModel search = photosOperations.getRecent(parameters );
		assertEquals("ok", search.getStat());
	}
	
	@Test
	public void testGetInfo() throws FlickrException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("photo_id", "8608344581");
		PhotoInfoModel search = photosOperations.getInfo(parameters );
		assertEquals("ok", search.getStat());
	}

}
