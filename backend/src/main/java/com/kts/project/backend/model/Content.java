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
@Table(name="CONTENT")
public class Content {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TEXT")
	private String text;
	
	@OneToMany(mappedBy = "content", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
		private Set<PictureWraper> pictures;

	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id")
	    private User user;
	public Content() {
		
	}
	 
	public Content(Long id, String text, Set<String> pictures) {
		super();
		this.id = id;
		this.text = text;
		//this.pictures = pictures;
	}

	
	public Content(Long id, String text, Set<PictureWraper> pictures, User user) {
		super();
		this.id = id;
		this.text = text;
		this.pictures = pictures;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
/*
	public Set<String> getPictures() {
		return pictures;
	}

	public void setPictures(Set<String> pictures) {
		this.pictures = pictures;
	}
*/

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	 
	 
}
