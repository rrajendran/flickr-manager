package com.capella.flickr.api.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class ActivityTest {

	@Test
	public void testGetValue() {
		Activity[] values = Activity.values();
		assertEquals(2, values.length);
		assertEquals("flickr.activity.userComments", Activity.USER_COMMENTS.getValue());
		assertEquals("flickr.activity.userPhotos", Activity.USER_PHOTOS.getValue());
	}

}
