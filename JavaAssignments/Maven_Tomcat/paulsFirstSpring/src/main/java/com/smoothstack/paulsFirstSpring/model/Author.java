package com.smoothstack.paulsFirstSpring.model;

public class Author {

	String authorName;
	int authorId;
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	@Override
	public String toString() {
		return "Author [authorName=" + authorName + ", authorId=" + authorId + "]";
	}
	
}
