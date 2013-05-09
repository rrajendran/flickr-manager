
package com.capella.flickr.api.entity;

import java.util.List;

public class Notes{
   	private List<Note> note;

 	public List<Note> getNote(){
		return this.note;
	}
	public void setNote(List<Note> note){
		this.note = note;
	}
}
