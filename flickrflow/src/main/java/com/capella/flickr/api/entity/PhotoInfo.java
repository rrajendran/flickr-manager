package com.capella.flickr.api.entity;


public class PhotoInfo extends Extras{
	String id;
	String secret;
	String server;
	String farm;
	String dateuploaded;
	boolean isfavorite;
	String safety_level;
	int rotation;
	Owner owner;
	Raw title;
	Raw description;
	Visibility visibility;
	Dates dates;
	String views;
	Editability editability;
	Publiceditability publiceditability;
	Usage usage;
	Raw comments;
	Notes notes;
	People people;
	Tags tags;
	Urls urls;
	String media;
	String originalsecret;
	String originalformat;
	Location location;
	Geoperms geoperms;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public boolean isIsfavorite() {
		return isfavorite;
	}

	public void setIsfavorite(boolean isfavorite) {
		this.isfavorite = isfavorite;
	}

	public String getDateuploaded() {
		return dateuploaded;
	}

	public void setDateuploaded(String dateuploaded) {
		this.dateuploaded = dateuploaded;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getSafety_level() {
		return safety_level;
	}

	public void setSafety_level(String safety_level) {
		this.safety_level = safety_level;
	}

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
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

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public Dates getDates() {
		return dates;
	}

	public void setDates(Dates dates) {
		this.dates = dates;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public Editability getEditability() {
		return editability;
	}

	public void setEditability(Editability editability) {
		this.editability = editability;
	}

	public Publiceditability getPubliceditability() {
		return publiceditability;
	}

	public void setPubliceditability(Publiceditability publiceditability) {
		this.publiceditability = publiceditability;
	}

	public Usage getUsage() {
		return usage;
	}

	public void setUsage(Usage usage) {
		this.usage = usage;
	}

	public Raw getComments() {
		return comments;
	}

	public void setComments(Raw comments) {
		this.comments = comments;
	}

	public Notes getNotes() {
		return notes;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}

	public Urls getUrls() {
		return urls;
	}

	public void setUrls(Urls urls) {
		this.urls = urls;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getOriginalsecret() {
		return originalsecret;
	}

	public void setOriginalsecret(String originalsecret) {
		this.originalsecret = originalsecret;
	}

	public String getOriginalformat() {
		return originalformat;
	}

	public void setOriginalformat(String originalformat) {
		this.originalformat = originalformat;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Geoperms getGeoperms() {
		return geoperms;
	}

	public void setGeoperms(Geoperms geoperms) {
		this.geoperms = geoperms;
	}
}
