package com.ayachama.movieflix.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "SiteRating.movieId", query = "SELECT s from SiteReview s where s.movieId=:pMovieId and s.reviewedUserId=:pUserId")
})
public class SiteReview {
	
	@Id
	private String siteReview;
	private String siteRating;
	private String siteReviewId;
	@Column(unique = true)
	private String reviewedUserId;
	private String movieId;
	
	public SiteReview(){
		siteReviewId = UUID.randomUUID().toString();
	}
	
	public String getSiteReview() {
		return siteReview;
	}
	public void setSiteReview(String siteReview) {
		this.siteReview = siteReview;
	}
	public String getSiteRating() {
		return siteRating;
	}
	public void setSiteRating(String siteRating) {
		this.siteRating = siteRating;
	}
	public String getSiteReviewId() {
		return siteReviewId;
	}
	public void setSiteReviewId(String siteReviewId) {
		this.siteReviewId = siteReviewId;
	}
	public String getReviewedUserId() {
		return reviewedUserId;
	}
	public void setReviewedUserId(String reviewedUserId) {
		this.reviewedUserId = reviewedUserId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
}
