package com.kts.project.backend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="SUBSCRIPTION")
public class Subscription {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "user_id")
	    private User user;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "co_id")
	    private CulturalOffer culturalOffer;
	 
	 
	public Subscription() {
			super();
	}

	public Subscription(Long id, User user, CulturalOffer culturalOffer) {
			super();
			this.id = id;
			this.user = user;
			this.culturalOffer = culturalOffer;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
