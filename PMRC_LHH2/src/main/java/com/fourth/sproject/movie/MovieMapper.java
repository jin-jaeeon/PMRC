package com.fourth.sproject.movie;

import java.util.List;



public interface MovieMapper {
	public abstract List<Movie> getMovieByID(MovieSelector ms);
	public abstract List<Movie> getMovie(MovieSelector ms);
	public abstract int getMovieCount(MovieSelector ms);
	public abstract int getAllMovieCount();
	
	public abstract List<Movie> getMovieByCode(MovieDetailSelector mds);
	public abstract List<MovieReply> getMovieReply(MovieDetailSelector mds);
	public abstract int writeReply(MovieReply mr);
	
	public abstract List<Movie> get();
	public abstract List<Movie> search(Movie m);
}
