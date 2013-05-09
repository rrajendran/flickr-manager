package com.capella.flickr.batch;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.capella.flickr.api.entity.Photo;
import com.capella.flickr.api.entity.PhotoSizeEnum;
import com.capella.flickr.api.model.PhotosModel;
import com.capella.flickr.api.operations.interestingness.InterestingnessOperations;

public class FlickrDownloadTask implements Tasklet {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlickrDownloadTask.class);
	private String location;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Autowired
	InterestingnessOperations interestingnessOperations;
	
	public RepeatStatus execute(StepContribution paramStepContribution, ChunkContext paramChunkContext) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("extras", "date_taken");
		PhotosModel list = interestingnessOperations.getList(PhotosModel.class, parameters );
		ArrayList<Photo> photos = list.getPhotos().getPhoto();
		for (Photo photo : photos) {
			String url = photo.getUrl(PhotoSizeEnum.b);
			File year = new File(location, String.valueOf(DateTime.now().getYear()));
			File month = new File(year,String.valueOf(DateTime.now().monthOfYear().getAsText()));
			File day = new File(month,String.valueOf(DateTime.now().dayOfMonth().getAsText()));
			day.mkdirs();
			
			File outputfile = new File(day,photo.getId() + ".jpg");
			if(!outputfile.exists()){
				try {
					LOGGER.debug("Downloading image = " + url);
					LOGGER.debug("Downloaded image to = " + outputfile.getAbsolutePath());
					InputStream openStream = new URL(url).openStream();
					BufferedImage read = ImageIO.read(openStream);
					ImageIO.write(read, "jpg", outputfile);
				} catch (Exception e) {
					LOGGER.error("Error : " + e.getMessage());
					continue;
				}
			}else{
				LOGGER.debug("Already downloaded" + photo.getId());
			}
		}
		return RepeatStatus.FINISHED;
	}
}