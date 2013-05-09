package com.capella.flickr.api.enums;
/**
 * 	flickr.test.echo
	flickr.test.login
	flickr.test.null

 * @author rrajendran
 *
 */
public enum TestEnum {
	TEST_ECHO ("flickr.test.echo"),
	TEST_NULL ("flickr.test.null"),
	TEST_LOGIN ("flickr.test.login");

	private final String api;  
	
	TestEnum(String api) {
		this.api = api;
	}
	
	public String getApi() {
		return api;
	}
}
