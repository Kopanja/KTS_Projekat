package com.kts.project.backend.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CULTURAL_OFFER")
public class CulturalOffer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NAME", length = 50, unique=true)
	private String name;
	
	@Column(name="LOCATION", length = 50, unique=true)
	private String location;
	
	@Column(name= "CONTACT", length = 50)
	private String contact;
	
	@Column(name= "RATING")
	private double rating;
	
	@Column(name="DESCRIPTION", unique=false)
	private String description;
	
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "admin_id")
	 private User admin;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "type_id")
	 private SubType type;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "subType_id")
	 private SubType subType;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "culturalOffer")
	    private Set<Post> posts;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "culturalOffer")
	    private Set<Review> reviews;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "culturalOffer")
	    private Set<Subscription> subscriptions;
	    
}
