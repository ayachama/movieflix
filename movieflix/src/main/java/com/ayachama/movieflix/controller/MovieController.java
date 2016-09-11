package com.ayachama.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayachama.movieflix.entity.Movie;
import com.ayachama.movieflix.entity.SiteReview;
import com.ayachama.movieflix.service.MovieService;

/**
 * 
 * @author avi
 *
 *
 *	1) Generic API for movies and Series - this can be used to accomplish 4,5,6,7;
	2) Movie detail API - 8; 
	3) Rating API - Rate and Comment a movie - 9, 10;
	4) View Site Rating API - View comments and Rating by others - 11, 12;
 *
 */

@RestController
@RequestMapping(value = "movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/allMovies", method = RequestMethod.GET)
	public List<Movie> getMoviesList() {
		return movieService.getMoviesList();
	}
	
	@RequestMapping(value = "/movieDetail", method = RequestMethod.POST)
	public Movie getMovieDetail(@RequestBody Movie movie) {
		// TODO Auto-generated method stub
		return movieService.getMovieDetail(movie);
	}
	
	@RequestMapping(value = "/reviewMovie", method = RequestMethod.POST,  
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SiteReview reviewAMovie(@RequestBody SiteReview movieReview) {
		return movieService.reviewAMovie(movieReview);
	}
	
	@RequestMapping(value = "/getSiteReviews", method = RequestMethod.POST)
	public List<SiteReview> getMoviesReview(@RequestBody SiteReview movieDetails) {
		return movieService.getMoviesReview(movieDetails);
	}
	
	@RequestMapping(value = "/adminAdd", method = RequestMethod.POST,  
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie adminAddaMovie(@RequestBody Movie movie) {
		return movieService.create(movie);
	}
	
	@RequestMapping(value = "/adminUpdate", method = RequestMethod.PUT,  
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie adminUpdateaMovie(@RequestBody Movie movie) {
		return movieService.update(movie);
	}
}
