package com.fourth.sproject.member;

import java.util.Date;

public class Member {
	private String p_user;
	private String p_password;
	private String p_name;
	private Date p_birthday;
	private String p_photo;
	private String p_grade;
	
	public String getP_grade() {
		return p_grade;
	}

	public void setP_grade(String p_grade) {
		this.p_grade = p_grade;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String p_user, String p_password, String p_name, Date p_birthday, String p_photo, String p_grade) {
		super();
		this.p_user = p_user;
		this.p_password = p_password;
		this.p_name = p_name;
		this.p_birthday = p_birthday;
		this.p_photo = p_photo;
		this.p_grade = p_grade;
	}

	public String getP_user() {
		return p_user;
	}

	public void setP_user(String p_user) {
		this.p_user = p_user;
	}

	public String getP_password() {
		return p_password;
	}

	public void setP_password(String p_password) {
		this.p_password = p_password;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Date getP_birthday() {
		return p_birthday;
	}

	public void setP_birthday(Date p_birthday) {
		this.p_birthday = p_birthday;
	}

	public String getP_photo() {
		return p_photo;
	}

	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}
	
}
