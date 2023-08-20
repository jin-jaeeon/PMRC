package com.fourth.sproject.movie;

public class PMRCMOptions {
	private int postsPerPage;
	private int displayPageNum;
	public PMRCMOptions(int postsPerPage, int displayPageNum) {
		super();
		this.postsPerPage = postsPerPage;
		this.displayPageNum = displayPageNum;
	}
	public PMRCMOptions() {
		// TODO Auto-generated constructor stub
	}
	public int getPostsPerPage() {
		return postsPerPage;
	}
	public void setPostsPerPage(int postsPerPage) {
		this.postsPerPage = postsPerPage;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	
	
}
