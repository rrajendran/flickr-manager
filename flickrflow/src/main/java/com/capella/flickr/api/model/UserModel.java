package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.User;


public class UserModel {
	User user;
	String stat;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	
}
