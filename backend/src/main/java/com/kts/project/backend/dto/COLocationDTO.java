package com.kts.project.backend.dto;

public class COLocationDTO {
	Long id;
	double latitude;
	double longitude;
	
	COLocationDTO(){
		
	}

	public COLocationDTO(Long id, double latitude, double longitude) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	

}
