package com.kts.project.backend.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TYPE")
public class Type {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME", length = 50, unique=true)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    private Set<SubType> subTypes;

	public Type() {
		
	}
	
	public Type(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Type(Long id, String name, Set<SubType> subTypes) {
		super();
		this.id = id;
		this.name = name;
		this.subTypes = subTypes;
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

	public Set<SubType> getSubTypes() {
		return subTypes;
	}

	public void setSubTypes(Set<SubType> subTypes) {
		this.subTypes = subTypes;
	}
	
	
}
