package com.kts.project.backend.dto;

//Mora da se doda Validation, ne radi na desktopu iz nekog razloga
public class SubTypeDTO {

	private Long id;
	
    private String name;
	
	private TypeDTO parentType;
    
    public SubTypeDTO() {
    	
    }

	public SubTypeDTO(Long id, String name, TypeDTO parentType) {
		super();
		this.id = id;
		this.name = name;
		this.parentType = parentType;
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

	public TypeDTO getParentType() {
		return parentType;
	}

	public void setParentType(TypeDTO parentType) {
		this.parentType = parentType;
	}
	
	

}
