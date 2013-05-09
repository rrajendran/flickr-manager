package com.capella.flickr.api.entity;


public class Raw {
	private String _content;
	public Raw() {
		
	}
	public Raw(String content) {
		this._content = content;
	}
	public String get_content() {
		return _content;
	}

	public void set_content(String _content) {
		this._content = _content;
	}

}
