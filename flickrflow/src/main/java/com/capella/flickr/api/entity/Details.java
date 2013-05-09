
package com.capella.flickr.api.entity;


public class Details{
   	private Raw lcd_screen_size;
   	private Raw megapixels;
   	private Raw zoom;
	private Raw memory_type;
	public Raw getLcd_screen_size() {
		return lcd_screen_size;
	}
	public void setLcd_screen_size(Raw lcd_screen_size) {
		this.lcd_screen_size = lcd_screen_size;
	}
	public Raw getMegapixels() {
		return megapixels;
	}
	public void setMegapixels(Raw megapixels) {
		this.megapixels = megapixels;
	}
	public Raw getZoom() {
		return zoom;
	}
	public void setZoom(Raw zoom) {
		this.zoom = zoom;
	}
	public Raw getMemory_type() {
		return memory_type;
	}
	public void setMemory_type(Raw memory_type) {
		this.memory_type = memory_type;
	}
	@Override
	public String toString() {
		return "Details [lcd_screen_size=" + lcd_screen_size + ", megapixels="
				+ megapixels + ", zoom=" + zoom + ", memory_type="
				+ memory_type + "]";
	}
	
	
}
