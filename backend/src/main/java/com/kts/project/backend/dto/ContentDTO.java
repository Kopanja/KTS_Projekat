package com.kts.project.backend.dto;

public class ContentDTO {

	private String text;
	
	private Long userId;

	public ContentDTO(String text, Long userId) {
		super();
		this.text = text;
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
