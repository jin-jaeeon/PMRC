package com.fourth.sproject.board;

import java.math.BigDecimal;

public class PostDetailH {
	private BigDecimal pb_no;
	
	//join할 다른 테이블
	private String p_photo;
	
	public String getP_photo() {
		return p_photo;
	}

	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}

	public PostDetailH(BigDecimal pb_no, String p_photo) {
		super();
		this.pb_no = pb_no;
		this.p_photo = p_photo;
	}

	public PostDetailH() {
		// TODO Auto-generated constructor stub
	}

	public PostDetailH(BigDecimal pb_no) {
		super();
		this.pb_no = pb_no;
	}

	public BigDecimal getPb_no() {
		return pb_no;
	}

	public void setPb_no(BigDecimal pb_no) {
		this.pb_no = pb_no;
	}
	
	
}
