package com.kts.project.backend.dto;

import javax.validation.constraints.NotBlank;

public class TypeDTO {
	
	private Long id;

    @NotBlank(message = "Name cannot be empty.")
    private String name;
    
    public TypeDTO() {
    	
    }
    
    
    
    
    
    public TypeDTO(Long id, @NotBlank(message = "Name cannot be empty.") String name) {
		super();
		this.id = id;
		this.name = name;
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
}
