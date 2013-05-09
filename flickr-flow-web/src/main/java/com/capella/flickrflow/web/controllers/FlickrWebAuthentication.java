package com.capella.flickrflow.web.controllers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.codec.Hex;

public class FlickrWebAuthentication {
	private  final static String SECRET = "8466da127b94832b";
	private  final static String API_KEY = "8a13dee6ee18863a0112f99206b78b69";
	private final static String AUTH_URL = "http://flickr.com/services/auth/";
	
	public String buildUrl(String url, Map<String,String> params){
		StringBuffer buffer = new StringBuffer();
		buffer.append(url).append("?");
		for (String key : params.keySet()) {
			String value = params.get(key);
			buffer.append(key).append("=").append(value).append("&");
		}
		return buffer.toString();
	}
	
	public String getApiSign(String api, String perms, String secret) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		// secret + 'api_key' + [api_key] + 'perms' + [perms]
		StringBuffer buffer = new StringBuffer();
		buffer.append(secret);
		buffer.append("api_key").append(api);
		buffer.append("perms").append(perms);
		System.out.println(buffer.toString());
		byte[] bytesOfMessage = buffer.toString().getBytes("UTF-8");

		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		final String result = new String(Hex.encode(thedigest));
		return result;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		FlickrWebAuthentication flickrWebAuthentication = new FlickrWebAuthentication();
		Map<String, String> params = new HashMap<String,String>();
		params.put("api_key", API_KEY);
		params.put("perms", "write");
		params.put("api_sig",flickrWebAuthentication.getApiSign(API_KEY,"write",SECRET));
		String buildUrl = flickrWebAuthentication.buildUrl(FlickrWebAuthentication.AUTH_URL,params );
		System.out.println(buildUrl);
	}
}
