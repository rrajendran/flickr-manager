package com.capella.flickr.api.entity;

import java.util.Date;

import org.joda.time.DateTime;

public class Comment {
	private String id ;
	private String author;
	private String authorname;
	private String iconserver;
	private String iconfarm;
	private DateTime datecreate;
	private String permalink;
	private String _content;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
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

	public DateTime getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(String datecreate) {
		//this.datecreate = Date;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String get_content() {
		return _content;
	}

	public void set_content(String _content) {
		this._content = _content;
	}
	
	public static void main(String[] args) {
		Date date = new Date(Long.parseLong("1364808021"));
		System.out.println(date);
	}
	
	public String getBuddyIcon(){
		return "http://farm" + this.iconfarm +".staticflickr.com/" + this.iconserver +"/buddyicons/" + this.author +".jpg";
	}
}
