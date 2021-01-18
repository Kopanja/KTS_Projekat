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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME", length = 50, unique=true)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	 private COLocation location;
	
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
	 @JoinColumn(name = "subType_id")
	 private SubType subType;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "culturalOffer")
	    private Set<Post> posts;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "culturalOffer")
	    private Set<Review> reviews;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "culturalOffer")
	    private Set<Subscription> subscriptions;

	 
	 
	 
	 
	public CulturalOffer() {
		super();
	}





	public CulturalOffer(Long id, String name, COLocation location, String contact, double rating, String description,
			User admin, SubType subType, Set<Post> posts, Set<Review> reviews,
			Set<Subscription> subscriptions) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.contact = contact;
		this.rating = rating;
		this.description = description;
		this.admin = admin;
		this.subType = subType;
		this.posts = posts;
		this.reviews = reviews;
		this.subscriptions = subscriptions;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public COLocation getLocation() {
		return location;
	}





	public void setLocation(COLocation location) {
		this.location = location;
	}





	public String getContact() {
		return contact;
	}





	public void setContact(String contact) {
		this.contact = contact;
	}





	public double getRating() {
		return rating;
	}





	public void setRating(double rating) {
		this.rating = rating;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public User getAdmin() {
		return admin;
	}





	public void setAdmin(User admin) {
		this.admin = admin;
	}





	public SubType getSubType() {
		return subType;
	}





	public void setSubType(SubType subType) {
		this.subType = subType;
	}





	public Set<Post> getPosts() {
		return posts;
	}





	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}





	public Set<Review> getReviews() {
		return reviews;
	}





	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}





	public Set<Subscription> getSubscriptions() {
		return subscriptions;
	}





	public void setSubscriptions(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	 
	 
	    
}
