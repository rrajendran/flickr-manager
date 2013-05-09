
package com.capella.flickr.api.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Cameras{
   	private String brand;
   	private List<Camera> camera;
   	private Raw Name;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public List<Camera> getCamera() {
		return camera;
	}
	public void setCamera(List<Camera> camera) {
		this.camera = camera;
	}
	public Raw getName() {
		return Name;
	}
	public void setName(Raw name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Cameras [brand=" + brand + ", camera=" + camera + ", Name="
				+ Name + "]";
	}
	
 	
}
