package com.capella.flickrflow.web.command;

import org.springframework.stereotype.Component;


@Component
public class FormSearch {
	String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
