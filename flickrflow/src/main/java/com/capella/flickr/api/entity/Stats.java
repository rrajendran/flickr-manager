package com.capella.flickr.api.entity;

import java.io.Serializable;
/**
 * 
 * @author rrajendran
 */
public class Stats implements Serializable{
	private static final long serialVersionUID = 5670681919202218479L;
	String stat;
	String code;
	String message;
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
