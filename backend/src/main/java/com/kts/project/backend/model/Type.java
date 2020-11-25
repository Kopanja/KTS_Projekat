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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="NAME", length = 50, unique=true)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    private Set<SubType> subTypes;
}
