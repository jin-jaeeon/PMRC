package com.fourth.sproject.movie;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
	private String pm_code;
	private String pm_name;
	private String pm_pyear;
	private String pm_genre;
	private String pm_director;
	private BigDecimal pm_acc;
	private String pm_url;
	

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String pm_code, String pm_name, String pm_pyear, String pm_genre, String pm_director,
			BigDecimal pm_acc, String pm_url) {
		super();
		this.pm_code = pm_code;
		this.pm_name = pm_name;
		this.pm_pyear = pm_pyear;
		this.pm_genre = pm_genre;
		this.pm_director = pm_director;
		this.pm_acc = pm_acc;
		this.pm_url = pm_url;
	}

	public String getPm_code() {
		return pm_code;
	}

	public void setPm_code(String pm_code) {
		this.pm_code = pm_code;
	}

	public String getPm_name() {
		return pm_name;
	}

	public void setPm_name(String pm_name) {
		this.pm_name = pm_name;
	}

	public String getPm_pyear() {
		return pm_pyear;
	}

	public void setPm_pyear(String pm_pyear) {
		this.pm_pyear = pm_pyear;
	}

	public String getPm_genre() {
		return pm_genre;
	}
	
	@XmlElement
	public void setPm_genre(String pm_genre) {
		this.pm_genre = pm_genre;
	}

	public String getPm_director() {
		return pm_director;
	}

	public void setPm_director(String pm_director) {
		this.pm_director = pm_director;
	}

	public String getPm_url() {
		return pm_url;
	}

	public void setPm_url(String pm_url) {
		this.pm_url = pm_url;
	}

	public void setPm_acc(BigDecimal pm_acc) {
		this.pm_acc = pm_acc;
	}
	
	public BigDecimal getPm_acc() {
		return pm_acc;
	}
	
	
}
