package com.ayachama.movieflix.repository;

import java.util.List;

import com.ayachama.movieflix.entity.Movie;
import com.ayachama.movieflix.entity.SiteReview;
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
public interface MovieRepository {
		// 1
		public List<Movie> getMoviesList();
		// 2
		public Movie getMovieDetail(Movie movie);
		// 3
		public SiteReview reviewAMovie(SiteReview movieReview);
		// 4
		public List<SiteReview> findMovieWithId(String movieId, String userId);
		
		// 5
		public Movie create(Movie movie);
		// 6
		public Movie update(Movie movie);
}
