package com.fourth.sproject.movie;

import java.math.BigDecimal;
import java.util.Date;

public class MovieReply {
	
	private String pmr_code;
	private String pmr_pm_code;
	private String pmr_writer;
	private BigDecimal pmr_grade;
	private Date pmr_date;
	private String pmr_txt;
	
	
	public MovieReply() {
		// TODO Auto-generated constructor stub
	}


	public String getPmr_pm_code() {
		return pmr_pm_code;
	}


	public void setPmr_pm_code(String pmr_pm_code) {
		this.pmr_pm_code = pmr_pm_code;
	}


	public MovieReply(String pmr_code, String pmr_pm_code, String pmr_writer, BigDecimal pmr_grade, Date pmr_date,
			String pmr_txt) {
		super();
		this.pmr_code = pmr_code;
		this.pmr_pm_code = pmr_pm_code;
		this.pmr_writer = pmr_writer;
		this.pmr_grade = pmr_grade;
		this.pmr_date = pmr_date;
		this.pmr_txt = pmr_txt;
	}


	public MovieReply(String pmr_code, String pmr_writer, BigDecimal pmr_grade, Date pmr_date, String pmr_txt) {
		super();
		this.pmr_code = pmr_code;
		this.pmr_writer = pmr_writer;
		this.pmr_grade = pmr_grade;
		this.pmr_date = pmr_date;
		this.pmr_txt = pmr_txt;
	}


	public String getPmr_code() {
		return pmr_code;
	}


	public void setPmr_code(String pmr_code) {
		this.pmr_code = pmr_code;
	}


	public String getPmr_writer() {
		return pmr_writer;
	}


	public void setPmr_writer(String pmr_writer) {
		this.pmr_writer = pmr_writer;
	}


	public BigDecimal getPmr_grade() {
		return pmr_grade;
	}


	public void setPmr_grade(BigDecimal pmr_grade) {
		this.pmr_grade = pmr_grade;
	}


	public Date getPmr_date() {
		return pmr_date;
	}


	public void setPmr_date(Date pmr_date) {
		this.pmr_date = pmr_date;
	}


	public String getPmr_txt() {
		return pmr_txt;
	}


	public void setPmr_txt(String pmr_txt) {
		this.pmr_txt = pmr_txt;
	}
	
	
}
