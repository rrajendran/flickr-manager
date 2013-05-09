package com.capella.flickr.api.entity;


/**
 * @author hemants
 *
 */
public class PhotosInfo {
	Raw firstdatetaken;
	Raw firstdate;
	Raw count;
	Raw views;
	public Raw getFirstdatetaken() {
		return firstdatetaken;
	}
	public void setFirstdatetaken(Raw firstdatetaken) {
		this.firstdatetaken = firstdatetaken;
	}
	public Raw getFirstdate() {
		return firstdate;
	}
	public void setFirstdate(Raw firstdate) {
		this.firstdate = firstdate;
	}
	public Raw getCount() {
		return count;
	}
	public void setCount(Raw count) {
		this.count = count;
	}
	public Raw getViews() {
		return views;
	}
	public void setViews(Raw views) {
		this.views = views;
	}
	
	
}
