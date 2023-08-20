package com.fourth.sproject.admin;

import oracle.net.nt.NTAdapter;

public class memberSelector {
	private String search;
	private int start;
	private int end;
	public memberSelector() {
		// TODO Auto-generated constructor stub
	}
	public memberSelector(String search, int start, int end) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
