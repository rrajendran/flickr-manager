package com.capella.flickr.api.entity;


public class User{
	String id ;
	String nsid;
	Raw username;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Raw getUsername() {
		return username;
	}
	public void setUsername(Raw username) {
		this.username = username;
	}
	public String getNsid() {
		return nsid;
	}
	public void setNsid(String nsid) {
		this.nsid = nsid;
	}	


}