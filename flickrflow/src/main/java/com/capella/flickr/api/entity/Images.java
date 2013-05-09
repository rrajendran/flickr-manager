
package com.capella.flickr.api.entity;


public class Images{
   	private Raw large;
   	private Raw small;
	public Raw getLarge() {
		return large;
	}
	public void setLarge(Raw large) {
		this.large = large;
	}
	public Raw getSmall() {
		return small;
	}
	public void setSmall(Raw small) {
		this.small = small;
	}
	@Override
	public String toString() {
		return "Images [large=" + large + ", small=" + small + "]";
	}

 	
}
