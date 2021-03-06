package com.capella.flickr.api.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExifInfo{
	String id;
	String secret;
	String server;
	String farm;
	String dateuploaded;
	String isfavorite;
	String license;
	String safety_level;
	String camera;
	List<Exif> exif;
	Map<String,String> map;
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
	public String getDateuploaded() {
		return dateuploaded;
	}
	public void setDateuploaded(String dateuploaded) {
		this.dateuploaded = dateuploaded;
	}
	public String getIsfavorite() {
		return isfavorite;
	}
	public void setIsfavorite(String isfavorite) {
		this.isfavorite = isfavorite;
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
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public List<Exif> getExif() {
		return exif;
	}
	public void setExif(List<Exif> exif) {
		this.exif = exif;
		for (int i = 0; i < exif.size(); i++) {
			if(map == null)
				map = new HashMap<String, String>(exif.size());
			map.put(exif.get(i).getLabel(), exif.get(i).getRaw().get_content());
		}
	}
	
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
}
