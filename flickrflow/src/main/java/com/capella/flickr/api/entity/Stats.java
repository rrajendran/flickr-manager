package com.capella.flickr.api.entity;

import java.io.Serializable;
/**
 * 
 * @author rrajendran
 */
public class Stats implements Serializable{
	private static final long serialVersionUID = 5670681919202218479L;
	String stat;
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	
}
