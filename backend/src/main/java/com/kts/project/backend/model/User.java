package com.kts.project.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="EMAIL", length = 50, unique=true)
	private String email;
	
	@Column(name="PASSWORD", length = 50, unique=false)
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	    private Set<Content> comments;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Review> reviews;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Subscription> subscriptions;
	
	 @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>();
	public User() {
		
	}

	

	public User(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	


	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
