package com.capella.flickr.api.entity;


/**
 * @author hemant
 *
 */
public class Locality {
	private String place_id ;
	private String _content ;
	private String woeid ;
	private String latitude ;
	private String longitude ;
	private String place_url ;
	public String get_content() {
		return _content;
	}
	public void set_content(String _content) {
		this._content = _content;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getWoeid() {
		return woeid;
	}
	public void setWoeid(String woeid) {
		this.woeid = woeid;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getPlace_url() {
		return place_url;
	}
	public void setPlace_url(String place_url) {
		this.place_url = place_url;
	}
	@Override
	public String toString() {
		return "Locality [_content=" + _content + ", place_id=" + place_id
				+ ", woeid=" + woeid + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", place_url=" + place_url
				+ "]";
	}
}
