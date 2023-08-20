package com.fourth.sproject.board;

import java.math.BigDecimal;
import java.util.Date;

public class PostReply {
	private BigDecimal psr_no;
	private BigDecimal psr_ps_no;
	private String psr_writer;
	private String psr_txt;
	private Date psr_date;
	private String psr_file;
	
public PostReply() {
	// TODO Auto-generated constructor stub
}

public PostReply(BigDecimal psr_no, BigDecimal psr_ps_no, String psr_writer, String psr_txt, Date psr_date,
		String psr_file) {
	super();
	this.psr_no = psr_no;
	this.psr_ps_no = psr_ps_no;
	this.psr_writer = psr_writer;
	this.psr_txt = psr_txt;
	this.psr_date = psr_date;
	this.psr_file = psr_file;
}

public BigDecimal getPsr_no() {
	return psr_no;
}

public void setPsr_no(BigDecimal psr_no) {
	this.psr_no = psr_no;
}

public BigDecimal getPsr_ps_no() {
	return psr_ps_no;
}

public void setPsr_ps_no(BigDecimal psr_ps_no) {
	this.psr_ps_no = psr_ps_no;
}

public String getPsr_writer() {
	return psr_writer;
}

public void setPsr_writer(String psr_writer) {
	this.psr_writer = psr_writer;
}

public String getPsr_txt() {
	return psr_txt;
}

public void setPsr_txt(String psr_txt) {
	this.psr_txt = psr_txt;
}

public Date getPsr_date() {
	return psr_date;
}

public void setPsr_date(Date psr_date) {
	this.psr_date = psr_date;
}

public String getPsr_file() {
	return psr_file;
}

public void setPsr_file(String psr_file) {
	this.psr_file = psr_file;
}


}
