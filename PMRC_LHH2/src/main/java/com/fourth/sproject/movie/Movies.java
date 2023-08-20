package com.fourth.sproject.movie;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movies {

	private List<Movie> movie;
	
	
	public Movies() {
		// TODO Auto-generated constructor stub
	}


	public Movies(List<Movie> movie) {
		super();
		this.movie = movie;
	}


	public List<Movie> getMovie() {
		return movie;
	}

	@XmlElement
	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
	
	
	

	
}
