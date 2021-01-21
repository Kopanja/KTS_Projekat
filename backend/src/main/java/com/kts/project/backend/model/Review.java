package com.kts.project.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="REVIEW")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="RATING", unique=false)
	private double rating;
	
	@OneToOne
	@JoinColumn(name = "content_id")
	private Content content;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "user_id")
	    private User user;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "co_id")
	    private CulturalOffer culturalOffer;

	 
	
	 public Review() {
		super();
	}



	public Review(Long id, double rating, Content content, User user, CulturalOffer culturalOffer) {
		super();
		this.id = id;
		this.rating = rating;
		this.content = content;
		this.user = user;
		this.culturalOffer = culturalOffer;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}



	public Content getContent() {
		return content;
	}



	public void setContent(Content content) {
		this.content = content;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public CulturalOffer getCulturalOffer() {
		return culturalOffer;
	}



	public void setCulturalOffer(CulturalOffer culturalOffer) {
		this.culturalOffer = culturalOffer;
	}

	
	 
}
