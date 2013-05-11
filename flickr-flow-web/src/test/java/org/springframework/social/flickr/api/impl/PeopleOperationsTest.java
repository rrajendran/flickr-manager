package org.springframework.social.flickr.api.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capella.flickr.api.exceptions.FlickrException;
import com.capella.flickr.api.model.PersonModel;
import com.capella.flickr.api.model.PhotosModel;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testApplicationContext.xml")
@ActiveProfiles("localhost")
@Ignore
public class PeopleOperationsTest {
	private static final String NSID = "48149369@N04";
	
	@Autowired
	private Flickr flickr;
	
	@Test
	public void testGetPersonProfile() throws FlickrException {
		PersonModel publicPhotos = flickr.getPeopleOperations().getPersonProfile(NSID);
		assertEquals("ok",publicPhotos.getStat());
		assertEquals(NSID,publicPhotos.getPerson().getNsid());
	}
	
	
	@Test
	public void getPublicPhotos() throws FlickrException {
		PhotosModel publicPhotos = flickr.getPeopleOperations().getPublicPhotos(NSID);
		assertEquals("ok",publicPhotos.getStat());
		assertEquals(true , Integer.parseInt(publicPhotos.getPhotos().getTotal()) > 0);
	}


}
