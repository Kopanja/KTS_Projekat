package com.kts.project.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="REVIEW")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="RATING", unique=false)
	private double rating;
	
	@OneToOne
	@JoinColumn(name = "content_id")
	private Content content;
	
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "user_id")
	    private User author;
	 
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "co_id")
	    private CulturalOffer culturalOffer;
}
