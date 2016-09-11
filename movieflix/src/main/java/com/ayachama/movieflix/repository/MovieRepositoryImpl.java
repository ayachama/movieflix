package com.ayachama.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ayachama.movieflix.entity.Movie;
import com.ayachama.movieflix.entity.SiteReview;

@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepository{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> getMoviesList() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie getMovieDetail(Movie movie) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByName", Movie.class);
		query.setParameter("pTitle", movie.getTitle());
		List<Movie> movieList = query.getResultList();
		if (movieList.size() == 1) {
			return movieList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public SiteReview reviewAMovie(SiteReview movieReview) {
		em.persist(movieReview);
		return movieReview;
	}

	@Override
	public List<SiteReview> findMovieWithId(String movieId, String userId) {
		TypedQuery<SiteReview> query = em.createNamedQuery("SiteRating.movieId", SiteReview.class);
		query.setParameter("pMovieId", movieId);
		query.setParameter("pUserId", userId);
		List<SiteReview> movieReviews = query.getResultList();
		if (movieReviews.size() > 0) {
			return movieReviews;
		} else {
			return null;
		}
	}

	@Override
	public Movie create(Movie movie) {
		 em.persist(movie);
		 return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

}
