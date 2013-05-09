package com.capella.flickr.api.operations.photos.comments;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.PhotoCommentsModel;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/capella/flickr/applicationContext.xml")
public class PhotoCommentsOperationsImplTest {
	@Autowired
	private PhotoCommentsOperations photoCommentsOperations;
	
	@Test
	public void testGetList() throws FlickrException {
		Map<String, Object> parameters = new HashMap<String, Object>(1);
		parameters.put("photo_id", "8631275288");
		PhotoCommentsModel list = photoCommentsOperations.getList(parameters );
		assertEquals("8631275288", list.getComments().getPhoto_id());
	}

}
