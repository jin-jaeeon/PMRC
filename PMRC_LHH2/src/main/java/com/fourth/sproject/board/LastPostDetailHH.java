package com.fourth.sproject.board;


public class LastPostDetailHH {
	private String pb_writer;
	
	//join할 다른 테이블
	private String p_photo;
	
public String getP_photo() {
		return p_photo;
	}


	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}


public LastPostDetailHH(String pb_writer, String p_photo) {
		super();
		this.pb_writer = pb_writer;
		this.p_photo = p_photo;
	}


public LastPostDetailHH() {
	// TODO Auto-generated constructor stub
}


public LastPostDetailHH(String pb_writer) {
	super();
	this.pb_writer = pb_writer;
}


public String getPb_writer() {
	return pb_writer;
}


public void setPb_writer(String pb_writer) {
	this.pb_writer = pb_writer;
}


}
