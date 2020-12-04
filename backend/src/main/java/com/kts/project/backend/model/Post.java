package com.kts.project.backend.model;

import java.util.Set;

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
@Table(name="POST")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_id")
    private CulturalOffer culturalOffer;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private Set<Comment> comments;
	
	@OneToOne
	@JoinColumn(name = "content_id")
	private Content content;
}
