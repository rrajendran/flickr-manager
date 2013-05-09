package com.capella.flickr.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Person {
	
	String id;
	String nsid;
	int ispro;
	String iconserver;
	String iconfarm;
	String path_alias;
	Raw username;
	Raw realname;
	Raw mbox_sha1sum;
	Raw location;
	TimeZone timezone;
	Raw description;
	Raw photosurl;
	Raw profileurl;
	Raw mobileurl;
	String datecreate;
	PhotosInfo photos;
	String gender;
	String ignored;
	boolean contact;
	boolean friend;
	boolean family;
	boolean revcontact;
	boolean revfriend;
	boolean revfamily;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNsid() {
		return nsid;
	}
	public void setNsid(String nsid) {
		this.nsid = nsid;
	}
	public int getIspro() {
		return ispro;
	}
	public void setIspro(int ispro) {
		this.ispro = ispro;
	}
	public String getIconserver() {
		return iconserver;
	}
	public void setIconserver(String iconserver) {
		this.iconserver = iconserver;
	}
	public String getIconfarm() {
		return iconfarm;
	}
	public void setIconfarm(String iconfarm) {
		this.iconfarm = iconfarm;
	}
	public String getPath_alias() {
		return path_alias;
	}
	public void setPath_alias(String path_alias) {
		this.path_alias = path_alias;
	}
	public Raw getUsername() {
		return username;
	}
	public void setUsername(Raw username) {
		this.username = username;
	}
	public Raw getRealname() {
		return realname;
	}
	public void setRealname(Raw realname) {
		this.realname = realname;
	}
	public Raw getMbox_sha1sum() {
		return mbox_sha1sum;
	}
	public void setMbox_sha1sum(Raw mbox_sha1sum) {
		this.mbox_sha1sum = mbox_sha1sum;
	}
	public Raw getLocation() {
		return location;
	}
	public void setLocation(Raw location) {
		this.location = location;
	}
	public TimeZone getTimezone() {
		return timezone;
	}
	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}
	public Raw getDescription() {
		return description;
	}
	public void setDescription(Raw description) {
		this.description = description;
	}
	public Raw getPhotosurl() {
		return photosurl;
	}
	public void setPhotosurl(Raw photosurl) {
		this.photosurl = photosurl;
	}
	public Raw getProfileurl() {
		return profileurl;
	}
	public void setProfileurl(Raw profileurl) {
		this.profileurl = profileurl;
	}
	public Raw getMobileurl() {
		return mobileurl;
	}
	public void setMobileurl(Raw mobileurl) {
		this.mobileurl = mobileurl;
	}
	public String getDatecreate() {
		return datecreate;
	}
	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}
	public PhotosInfo getPhotos() {
		return photos;
	}
	public void setPhotos(PhotosInfo photos) {
		this.photos = photos;
	}
	public String getBuddyIcon(){
		return "http://farm" + this.iconfarm +".staticflickr.com/" + this.iconserver +"/buddyicons/" + this.nsid +".jpg";
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIgnored() {
		return ignored;
	}
	public void setIgnored(String ignored) {
		this.ignored = ignored;
	}
	public boolean isContact() {
		return contact;
	}
	public void setContact(boolean contact) {
		this.contact = contact;
	}
	public boolean isFriend() {
		return friend;
	}
	public void setFriend(String friend) {
		
		this.friend = friend.equals("0") ? false: true ;
	}
	public boolean isFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family.equals("0") ? false: true ;
	}
	public boolean isRevcontact() {
		return revcontact;
	}
	public void setRevcontact(boolean revcontact) {
		this.revcontact = revcontact;
	}
	public boolean isRevfriend() {
		return revfriend;
	}
	public void setRevfriend(boolean revfriend) {
		this.revfriend = revfriend;
	}
	public boolean isRevfamily() {
		return revfamily;
	}
	public void setRevfamily(boolean revfamily) {
		this.revfamily = revfamily;
	}
	
}
