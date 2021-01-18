package com.kts.project.backend.dto;

//Mora da se doda Validation, ne radi na desktopu iz nekog razloga
public class TypeDTO {
	
	private Long id;

    private String name;
    
    public TypeDTO() {
    	
    }
    
    
    
    
    
    public TypeDTO(Long id, String name) {
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
