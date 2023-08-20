package com.fourth.sproject.board;

public class PMRCOptions {
	private int postsPerPage;
	private int displayPageNum;
	public PMRCOptions(int postsPerPage, int displayPageNum) {
		super();
		this.postsPerPage = postsPerPage;
		this.displayPageNum = displayPageNum;
	}
	public PMRCOptions() {
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
