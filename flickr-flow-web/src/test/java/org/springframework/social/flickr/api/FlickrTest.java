package org.springframework.social.flickr.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testApplicationContext.xml")
@ActiveProfiles("localhost")
public class FlickrTest {
	@Autowired
	Flickr flickr;
	@Test
	public void test(){
		Assert.assertNotNull(flickr.getCommentsOperations());
		//flickr.getCommentsOperations().addComments(photoId, comments);
	}
}
