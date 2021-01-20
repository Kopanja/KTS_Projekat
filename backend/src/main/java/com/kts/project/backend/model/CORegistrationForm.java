package com.kts.project.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CO_Registration_Form")
public class CORegistrationForm {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="EMAIL", length = 50, unique=true)
	private String email;
	
	
	@Column(name="NAME", length = 50, unique=true)
	private String name;
	
	@Column(name="TYPE", unique=false)
	private String type;
		
	
	@Column(name="SUB_TYPE", unique=false)
	private String subType;

	

	public CORegistrationForm() {
		super();
	}



	public CORegistrationForm(Long id, String email, String name, String type, String subType) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.type = type;
		this.subType = subType;
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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getSubType() {
		return subType;
	}



	public void setSubType(String subType) {
		this.subType = subType;
	}
	
	
	

}
