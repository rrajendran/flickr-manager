package com.capella.flickr.api.entity;


public class Exif {
	private String tagspace;
	private int tagspaceid;
	private String tag;
	private String label;
	private Raw raw;
	private Raw clean;
	
	public String getTagspace() {
		return tagspace;
	}
	public void setTagspace(String tagspace) {
		this.tagspace = tagspace;
	}
	public int getTagspaceid() {
		return tagspaceid;
	}
	public void setTagspaceid(int tagspaceid) {
		this.tagspaceid = tagspaceid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Raw getRaw() {
		return raw;
	}
	public void setRaw(Raw raw) {
		this.raw = raw;
	}
	public Raw getClean() {
		return clean;
	}
	public void setClean(Raw clean) {
		this.clean = clean;
	}
	
}
