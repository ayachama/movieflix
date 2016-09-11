package com.ayachama.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayachama.movieflix.entity.Movie;
import com.ayachama.movieflix.entity.SiteReview;
import com.ayachama.movieflix.exception.MovieDetailsNotFound;
import com.ayachama.movieflix.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository repository;
	
	@Override
	public List<Movie> getMoviesList() {
		// TODO Auto-generated method stub
		return repository.getMoviesList();
	}

	@Override
	public Movie getMovieDetail(Movie movie) {
		// TODO Auto-generated method stub
		return repository.getMovieDetail(movie);
	}
	
	@Override
	public SiteReview reviewAMovie(SiteReview movieReview) {
		// TODO Auto-generated method stub
		return repository.reviewAMovie(movieReview);
	}
	
	@Override
	public List<SiteReview> getMoviesReview(SiteReview movieDetails) {
		return repository.findMovieWithId(movieDetails.getMovieId(), movieDetails.getReviewedUserId());
	}

	@Override
	public Movie create(Movie movie) {
		// TODO Auto-generated method stub
		return repository.create(movie);
	}

	@Override
	public Movie update(Movie movie) {
		// TODO Auto-generated method stub
		return repository.update(movie);
	}

}
