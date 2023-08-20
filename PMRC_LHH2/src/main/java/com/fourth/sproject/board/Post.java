package com.fourth.sproject.board;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Post {
	private BigDecimal pb_no;
	private String pb_writer;
	private String pb_content;
	private String pb_title;
	private BigDecimal pb_count;
	private Date pb_date;
	private String p_user;
	private String p_photo;
	
	public Post() {
		// TODO Auto-generated constructor stub
	}

	public Post(BigDecimal pb_no, String pb_writer, String pb_content, String pb_title, BigDecimal pb_count,
			Date pb_date, String p_user, String p_photo) {
		super();
		this.pb_no = pb_no;
		this.pb_writer = pb_writer;
		this.pb_content = pb_content;
		this.pb_title = pb_title;
		this.pb_count = pb_count;
		this.pb_date = pb_date;
		this.p_user = p_user;
		this.p_photo = p_photo;
	}

	public BigDecimal getPb_no() {
		return pb_no;
	}

	public void setPb_no(BigDecimal pb_no) {
		this.pb_no = pb_no;
	}

	public String getPb_writer() {
		return pb_writer;
	}

	public void setPb_writer(String pb_writer) {
		this.pb_writer = pb_writer;
	}

	public String getPb_content() {
		return pb_content;
	}

	public void setPb_content(String pb_content) {
		this.pb_content = pb_content;
	}

	public String getPb_title() {
		return pb_title;
	}

	public void setPb_title(String pb_title) {
		this.pb_title = pb_title;
	}

	public BigDecimal getPb_count() {
		return pb_count;
	}

	public void setPb_count(BigDecimal pb_count) {
		this.pb_count = pb_count;
	}

	public Date getPb_date() {
		return pb_date;
	}

	public void setPb_date(Date pb_date) {
		this.pb_date = pb_date;
	}

	public String getP_user() {
		return p_user;
	}

	public void setP_user(String p_user) {
		this.p_user = p_user;
	}

	public String getP_photo() {
		return p_photo;
	}

	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}
	
	
	
	
	
}
