package com.kts.project.backend.dto;

public class CulturalOfferDTO {
	
	private String name;
	
	
	private String subType;
	
	private String description;

	private COLocationDTO location;
	
	public CulturalOfferDTO() {
		super();
	}



	public CulturalOfferDTO(String name,String subType, String description) {
		super();
		this.name = name;
		this.subType = subType;
		this.description = description;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSubType() {
		return subType;
	}



	public void setSubType(String subType) {
		this.subType = subType;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public COLocationDTO getLocation() {
		return location;
	}



	public void setLocation(COLocationDTO location) {
		this.location = location;
	}
	
	
	
	
	

}
