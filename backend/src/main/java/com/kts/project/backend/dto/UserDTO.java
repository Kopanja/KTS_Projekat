package com.kts.project.backend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO {

	private Long id;
	
	@NotBlank(message = "Email cannot be empty.")
    @Email(message = "Email format is not valid.")
	private String email;
	
	
	public UserDTO() {
		
	}

	
	
	public UserDTO(Long id, @NotBlank(message = "Email cannot be empty.") @Email(message = "Email format is not valid.") String email) {
		super();
		this.id = id;
		this.email = email;
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
	
	
	
}
