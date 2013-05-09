package com.capella.flickr.api.entity;

import java.util.List;


public class Photoset {
	String id;
	String owner;
	String ownername;
	String primary;
	String server;
	String secret;
	Integer farm;
	String photos;
	Integer videos;
	Raw title;
	Raw description;
	Integer needs_interstitial;
	Integer visibility_can_see_set;
	Integer count_views;
	Integer count_comments;
	Integer countPhotos;
	Integer countVideos;
	Boolean can_comment;
	String date_create;
	String date_update;
	List<Photo> photo;
	
	Integer page;
	Integer per_page;
	Integer perpage;
	Integer pages; 
	Integer total;
		
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
	
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
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
	public Integer getFarm() {
		return farm;
	}
	public void setFarm(Integer farm) {
		this.farm = farm;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public Integer getVideos() {
		return videos;
	}
	public void setVideos(Integer videos) {
		this.videos = videos;
	}
	public Raw getTitle() {
		return title;
	}
	public void setTitle(Raw title) {
		this.title = title;
	}
	public Raw getDescription() {
		return description;
	}
	public void setDescription(Raw description) {
		this.description = description;
	}
	public Integer getNeeds_interstitial() {
		return needs_interstitial;
	}
	public void setNeeds_interstitial(Integer needs_interstitial) {
		this.needs_interstitial = needs_interstitial;
	}
	public Integer getVisibility_can_see_set() {
		return visibility_can_see_set;
	}
	public void setVisibility_can_see_set(Integer visibility_can_see_set) {
		this.visibility_can_see_set = visibility_can_see_set;
	}
	public Integer getCount_views() {
		return count_views;
	}
	public void setCount_views(Integer count_views) {
		this.count_views = count_views;
	}
	public Integer getCount_comments() {
		return count_comments;
	}
	public void setCount_comments(Integer count_comments) {
		this.count_comments = count_comments;
	}
	public Integer getCountPhotos() {
		return countPhotos;
	}
	public void setCountPhotos(Integer countPhotos) {
		this.countPhotos = countPhotos;
	}
	public Integer getCountVideos() {
		return countVideos;
	}
	public void setCountVideos(Integer countVideos) {
		this.countVideos = countVideos;
	}
	public Boolean getCan_comment() {
		return can_comment;
	}
	public void setCan_comment(Boolean can_comment) {
		this.can_comment = can_comment;
	}
	public String getDate_create() {
		return date_create;
	}
	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}
	public String getDate_update() {
		return date_update;
	}
	public void setDate_update(String date_update) {
		this.date_update = date_update;
	}
	
	public List<Photo> getPhoto() {
		return photo;
	}
	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPer_page() {
		return per_page;
	}
	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}
	public Integer getPerpage() {
		return perpage;
	}
	public void setPerpage(Integer perpage) {
		this.perpage = perpage;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getImageUrl(){
		return "http://farm" +this.farm+".staticflickr.com/" + this.server +"/" + this.primary +"_" + this.secret + "_q.jpg";
	}
	
}
