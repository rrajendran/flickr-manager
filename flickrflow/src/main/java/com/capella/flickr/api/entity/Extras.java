package com.capella.flickr.api.entity;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * description, license, date_upload, date_taken, owner_name, icon_server,
 * original_format, last_update, geo, tags, machine_tags, o_dims, views, media,
 * path_alias, url_sq, url_t, url_s, url_q, url_m, url_n, url_z, url_c, url_l,
 * url_o
 * 
 * @author rrajendran
 * 
 */
public class Extras {

	Raw description;
	String license;
	String dateupload;
	String datetaken;
	String datetakengranularity;
	String ownername;
	String iconserver;
	int iconfarm;
	String originalformat;
	String originalsecret;
	String lastupdate;
	int longitude;
	int accuracy;
	int context;
	String geo;
	Tags tags;
	String machineTags;
	String oDims;
	String views;
	String media;
	@JsonProperty(value = "path_alias")
	String pathAlias;
	String urlSq;
	String urlT;
	String urlS;
	String urlQ;
	String urlM;
	String urlN;
	String urlZ;
	String urlC;
	String urlL;
	String urlO;

	

}
