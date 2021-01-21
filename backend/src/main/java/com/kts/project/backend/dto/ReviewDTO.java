package com.kts.project.backend.dto;

public class ReviewDTO {

	private double rating;
	
	private Long contentId;
	
	private Long userId;
	
	private Long coId;

	
	public ReviewDTO() {
		super();
	}


	public ReviewDTO(double rating, Long contentId, Long userId, Long coId) {
		super();
		this.rating = rating;
		this.contentId = contentId;
		this.userId = userId;
		this.coId = coId;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public Long getContentId() {
		return contentId;
	}


	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getCoId() {
		return coId;
	}


	public void setCoId(Long coId) {
		this.coId = coId;
	}
	
	
	
}
