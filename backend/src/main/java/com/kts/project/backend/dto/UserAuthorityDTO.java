package com.kts.project.backend.dto;

public class UserAuthorityDTO {

	private Long userID;
	
	private Long authorityID;
	
	public UserAuthorityDTO() {
		
	}

	public UserAuthorityDTO(Long userID, Long authorityID) {
		super();
		this.userID = userID;
		this.authorityID = authorityID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getAuthorityID() {
		return authorityID;
	}

	public void setAuthorityID(Long authorityID) {
		this.authorityID = authorityID;
	}
	
	
}
