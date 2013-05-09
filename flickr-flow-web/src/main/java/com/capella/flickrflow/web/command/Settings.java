package com.capella.flickrflow.web.command;


public class Settings {
	String flickrId;
	String downloadPath;
	public String getFlickrId() {
		return flickrId;
	}
	public void setFlickrId(String flickrId) {
		this.flickrId = flickrId;
	}
	public String getDownloadPath() {
		return downloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	@Override
	public String toString() {
		return "Settings [flickrId=" + flickrId + ", downloadPath="
				+ downloadPath + "]";
	}
	
}
