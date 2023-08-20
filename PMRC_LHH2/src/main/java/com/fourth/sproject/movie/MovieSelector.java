package com.fourth.sproject.movie;

public class MovieSelector {
	private String search;
	private int start;
	private int end;
	
public MovieSelector(String search, int start, int end, String pm_code) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
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
public MovieSelector() {
	// TODO Auto-generated constructor stub
}public MovieSelector(String search, int start, int end) {
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

public MovieSelector(String search) {
	super();
	this.search = search;
}	
	
}
