package com.kts.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.project.backend.dto.SubscriptionDTO;
import com.kts.project.backend.model.Subscription;
import com.kts.project.backend.model.User;
import com.kts.project.backend.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

	@Autowired
	SubscriptionRepository subscriptionRepo;

	@Autowired
	UserService userService;
	
	@Autowired
	CulturalOfferService coService;
	
	public List<Subscription> getAll() {
		return subscriptionRepo.findAll();
	}

	public Subscription findById(Long id) {
		return subscriptionRepo.findById(id).orElse(null);
	}

	public void delete(Long id) throws Exception {
		Subscription subscription = subscriptionRepo.findById(id).orElse(null);
        if(subscription == null){
            throw new Exception("User given id doesn't exist");
        }
        subscriptionRepo.delete(subscription);		
	}

	public List<Subscription> findBySubscriberId(Long id) {
		return subscriptionRepo.findByUserId(id);
	}
	
	public List<Subscription> findByPublisherId(Long id) {
		return subscriptionRepo.findByCulturalOfferId(id);
	}
	
	public Subscription create(SubscriptionDTO subscriptionDTO) {
		Subscription newSubscription = new Subscription();
		newSubscription.setUser(userService.findOne(subscriptionDTO.getSubscriberId()));
		newSubscription.setCulturalOffer(coService.findById(subscriptionDTO.getPublisherId()));
        return subscriptionRepo.save(newSubscription);
	}
}
