package com.kts.project.backend.dto;

public class SubscriptionDTO {
	
	private Long subscriberId;
	
	private Long publisherId;

	
	
	public SubscriptionDTO() {
		super();
	}



	public SubscriptionDTO(Long subscriberId, Long publisherId) {
		super();
		this.subscriberId = subscriberId;
		this.publisherId = publisherId;
	}



	public Long getSubscriberId() {
		return subscriberId;
	}



	public void setSubscriberId(Long subscriberId) {
		this.subscriberId = subscriberId;
	}



	public Long getPublisherId() {
		return publisherId;
	}



	public void setPublisherId(Long publisherId) {
		this.publisherId = publisherId;
	}
	
	

}
