
package com.capella.flickr.api.entity;


public class Camera{
	private String id;
	private Raw name;
   	private Details details;
   	private Images images;
	
 	public Details getDetails(){
		return this.details;
	}
	public void setDetails(Details details){
		this.details = details;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public Images getImages(){
		return this.images;
	}
	public void setImages(Images images){
		this.images = images;
	}
	public Raw getName() {
		return name;
	}
	public void setName(Raw name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Camera [id=" + id + ", name=" + name + ", details=" + details
				+ ", images=" + images + "]";
	}
	
 	
}
