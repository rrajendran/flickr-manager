package com.capella.flickr.api.entity;

import java.util.LinkedHashMap;

public class Gallery {
   	private String count_comments;
   	private String count_photos;
   	private String count_videos;
   	private String count_views;
   	private String date_create;
   	private String date_update;
   	private Raw description;
   	private Number iconfarm;
   	private String iconserver;
   	private String id;
   	private String owner;
   	private Number primary_photo_farm;
   	private String primary_photo_id;
   	private String primary_photo_secret;
   	private String primary_photo_server;
   	private Raw title;
   	private String url;
   	private String username;
	public String getCount_comments() {
		return count_comments;
	}
	public void setCount_comments(String count_comments) {
		this.count_comments = count_comments;
	}
	public String getCount_photos() {
		return count_photos;
	}
	public void setCount_photos(String count_photos) {
		this.count_photos = count_photos;
	}
	public String getCount_videos() {
		return count_videos;
	}
	public void setCount_videos(String count_videos) {
		this.count_videos = count_videos;
	}
	public String getCount_views() {
		return count_views;
	}
	public void setCount_views(String count_views) {
		this.count_views = count_views;
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
	public Raw getDescription() {
		return description;
	}
	public void setDescription(Raw description) {
		this.description = description;
	}
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
	public Number getPrimary_photo_farm() {
		return primary_photo_farm;
	}
	public void setPrimary_photo_farm(Number primary_photo_farm) {
		this.primary_photo_farm = primary_photo_farm;
	}
	public String getPrimary_photo_id() {
		return primary_photo_id;
	}
	public void setPrimary_photo_id(String primary_photo_id) {
		this.primary_photo_id = primary_photo_id;
	}
	public String getPrimary_photo_secret() {
		return primary_photo_secret;
	}
	public void setPrimary_photo_secret(String primary_photo_secret) {
		this.primary_photo_secret = primary_photo_secret;
	}
	public String getPrimary_photo_server() {
		return primary_photo_server;
	}
	public void setPrimary_photo_server(String primary_photo_server) {
		this.primary_photo_server = primary_photo_server;
	}
	public Raw getTitle() {
		return title;
	}
	public void setTitle(Raw title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
