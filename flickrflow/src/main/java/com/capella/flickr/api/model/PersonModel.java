package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Person;

public class PersonModel {
	Person person;
	String stat;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	
}
