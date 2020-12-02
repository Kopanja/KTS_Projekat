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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "user_id")
	    private User user;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "co_id")
	    private CulturalOffer culturalOffer;
	    
}
