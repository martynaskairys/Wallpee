package com.martynaskairys.wallpee.DataTypes;

import java.util.List;

/**
 * A folder containing image urls
 */
public class Folder {

	final String title;
	final List<String> urls;

	public Folder(String title, List<String> urls) {
		this.title = title;
		this.urls = urls;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getUrls() {
		return urls;
	}
}
