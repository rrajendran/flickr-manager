package com.capella.flickr.api.model;

import com.capella.flickr.api.entity.Groups;
import com.capella.flickr.api.entity.Stats;
/**
 * 
 * @author rrajendran
 */
public class GroupsModel extends Stats {
	private static final long serialVersionUID = 1L;
	Groups groups;

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}
	
}
