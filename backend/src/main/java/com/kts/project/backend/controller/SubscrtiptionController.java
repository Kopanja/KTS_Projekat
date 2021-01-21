package com.kts.project.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kts.project.backend.dto.SubscriptionDTO;
import com.kts.project.backend.model.CORegistrationForm;
import com.kts.project.backend.model.Subscription;
import com.kts.project.backend.service.SubscriptionService;
import com.kts.project.backend.util.mapper.SubscriptionMapper;

@RestController
@RequestMapping(value="api/subscription")
public class SubscrtiptionController {
	
	@Autowired
	SubscriptionService subscriptionService;
	
	SubscriptionMapper subscriptionMapper = new SubscriptionMapper();
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SubscriptionDTO>> getAlSubscriptions() {
        
		List<Subscription> allSubscriptions = subscriptionService.getAll();
		return new ResponseEntity<>(toSubscriptionDTOList(allSubscriptions), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<SubscriptionDTO> getCORegistrationFormById(@PathVariable Long id) {
        
		Subscription subscription = subscriptionService.findById(id);
		
        if(subscription == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subscriptionMapper.toDto(subscription), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<CORegistrationForm> rejectCORegistrationForm(@PathVariable Long id) {
		
		try {
			subscriptionService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SubscriptionDTO> createNewSubscription(@RequestBody SubscriptionDTO subscription){
        
		Subscription newSubscription;
        try {
        	newSubscription = subscriptionService.create(subscription);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(subscriptionMapper.toDto(newSubscription), HttpStatus.CREATED);
    }
	
	private List<SubscriptionDTO> toSubscriptionDTOList(List<Subscription> subscriptions) {
        List<SubscriptionDTO> subscriptionDTOS = new ArrayList<>();
       
        for (Subscription subscription: subscriptions) {
        	subscriptionDTOS.add(subscriptionMapper.toDto(subscription));
        }
        return subscriptionDTOS;
    }

}
