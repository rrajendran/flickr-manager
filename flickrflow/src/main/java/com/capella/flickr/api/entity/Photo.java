package com.capella.flickr.api.entity;

import java.util.ArrayList;

import org.codehaus.jackson.map.annotate.JsonRootName;
@JsonRootName("photo")
public class Photo extends Extras{
	String id;
	String owner;
	String primary;
	String ownername;
	String username;
	String secret;
	String server;
	String farm;
	String title;
	boolean ispublic;
	boolean isfriend;
	boolean isfamily;
	boolean isfaved;
	String isprimary;
	String thumb;
	String media;
	String url;
	String page;
	String pages;
	String perpage;
	String total;
	String date_faved;
	Location location;
	ArrayList<Person2> person2;
	ArrayList<Exif> exif;
	String camera;
	String dateuploaded;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getFarm() {
		return farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isIspublic() {
		return ispublic;
	}

	public void setIspublic(boolean ispublic) {
		this.ispublic = ispublic;
	}

	public boolean isIsfriend() {
		return isfriend;
	}

	public void setIsfriend(boolean isfriend) {
		this.isfriend = isfriend;
	}

	public boolean isIsfamily() {
		return isfamily;
	}

	public void setIsfamily(boolean isfamily) {
		this.isfamily = isfamily;
	}

	public boolean isIsfaved() {
		return isfaved;
	}

	public void setIsfaved(boolean isfaved) {
		this.isfaved = isfaved;
	}

	public String getIsprimary() {
		return isprimary;
	}

	public void setIsprimary(String isprimary) {
		this.isprimary = isprimary;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getPerpage() {
		return perpage;
	}

	public void setPerpage(String perpage) {
		this.perpage = perpage;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDate_faved() {
		return date_faved;
	}

	public void setDate_faved(String date_faved) {
		this.date_faved = date_faved;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ArrayList<Person2> getPerson2() {
		return person2;
	}

	public void setPerson2(ArrayList<Person2> person2) {
		this.person2 = person2;
	}

	public ArrayList<Exif> getExif() {
		return exif;
	}

	public void setExif(ArrayList<Exif> exif) {
		this.exif = exif;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDateuploaded() {
		return dateuploaded;
	}

	public void setDateuploaded(String dateuploaded) {
		this.dateuploaded = dateuploaded;
	}

	public String getUrl() {
		String tempUrl = "http://farm"+getFarm()+".staticflickr.com/"+getServer()+"/"+getId()+"_"+getSecret()+".jpg";
		url = tempUrl;
		return url;
	}

	public String getUrl(PhotoSizeEnum size) {
		String tempUrl = "http://farm"+getFarm()+".staticflickr.com/"+getServer()+"/"+getId()+"_";
		if(size.compareTo(PhotoSizeEnum.o) == 0)
		{
			//String tempUrl += geto()+"_"+size+".jpg";
		}else{
			
			tempUrl += getSecret()+"_"+size+".jpg";
		}
		url = tempUrl;
		return url;
	}

	

}
