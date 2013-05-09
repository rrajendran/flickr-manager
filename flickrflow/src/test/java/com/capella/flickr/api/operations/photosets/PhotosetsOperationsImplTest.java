package com.capella.flickr.api.operations.photosets;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/capella/flickr/applicationContext.xml")
@Ignore
public class PhotosetsOperationsImplTest {
	/*@Autowired
	PhotosetsOperations photosetsOperations;

	@Test
	public void testGetList() throws FlickrException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_id", "48149369@N04");
		parameters.put("extras", "views");
		PhotosetsModel list = photosetsOperations.getList(parameters );
		assertEquals("ok", list.getStat());
	}

	@Test
	public void testGetPhotos()
			throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("user_id", "48149369@N04");
		PhotosetsModel list = photosetsOperations.getList(parameters );
		assertEquals("ok", list.getStat());

		parameters = new HashMap<String, Object>();
		parameters.put("photoset_id",list.getPhotosets().getPhotoset().get(0).getId());
		PhotosetModel photos = photosetsOperations.getPhotos(parameters);
		assertEquals("ok", photos.getStat());
		
	}*/

}
