
package com.capella.flickr.api.entity;



public class Owner{
   	private Number iconfarm;
   	private String iconserver;
   	private String location;
   	private String nsid;
   	private String realname;
   	private String username;
   	private String path_alias;
	public Number getIconfarm() {
		return iconfarm;
	}
	public void setIconfarm(Number iconfarm) {
		this.iconfarm = iconfarm;
	}
	public String getIconserver() {
		return iconserver;
	}
	public void setIconserver(String iconserver) {
		this.iconserver = iconserver;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getNsid() {
		return nsid;
	}
	public void setNsid(String nsid) {
		this.nsid = nsid;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPath_alias() {
		return path_alias;
	}
	public void setPath_alias(String path_alias) {
		this.path_alias = path_alias;
	}
	
	public String getBuddyIcon(){
		return "http://farm" + this.iconfarm +".staticflickr.com/" + this.iconserver +"/buddyicons/" + this.nsid +".jpg";
	}
}
