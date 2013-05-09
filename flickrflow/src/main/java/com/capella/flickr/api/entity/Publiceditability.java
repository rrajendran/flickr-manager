
package com.capella.flickr.api.entity;


public class Publiceditability{
   	private boolean canaddmeta;
   	private boolean cancomment;

 	public boolean getCanaddmeta(){
		return this.canaddmeta;
	}
	public void setCanaddmeta(boolean canaddmeta){
		this.canaddmeta = canaddmeta;
	}
 	public boolean getCancomment(){
		return this.cancomment;
	}
	public void setCancomment(boolean cancomment){
		this.cancomment = cancomment;
	}
}
