package com.capella.flickr.api.entity;

import java.util.List;

public class Galleries {
	String page;
	String pages;
	String per_page;
	String total;
	String user_id;
	List<Gallery> gallery;
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
	public String getPer_page() {
		return per_page;
	}
	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public List<Gallery> getGallery() {
		return gallery;
	}
	public void setGallery(List<Gallery> gallery) {
		this.gallery = gallery;
	}
}
