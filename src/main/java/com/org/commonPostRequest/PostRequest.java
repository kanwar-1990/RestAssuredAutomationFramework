package com.org.commonPostRequest;

public class PostRequest {

	private String id;
	private String title;
	private String author;

	public PostRequest createCommonData(String id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;

		return this;
	}

}
