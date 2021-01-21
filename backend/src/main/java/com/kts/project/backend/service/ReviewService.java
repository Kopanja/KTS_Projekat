package com.kts.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.project.backend.dto.ReviewDTO;
import com.kts.project.backend.dto.SubscriptionDTO;
import com.kts.project.backend.model.Review;
import com.kts.project.backend.model.Subscription;
import com.kts.project.backend.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CulturalOfferService coService;
	
	public List<Review> getAll() {
		return reviewRepo.findAll();
	}

	public Review findById(Long id) {
		return reviewRepo.findById(id).orElse(null);
	}

	public void delete(Long id) throws Exception {
		Review review = reviewRepo.findById(id).orElse(null);
        if(review == null){
            throw new Exception("User given id doesn't exist");
        }
        reviewRepo.delete(review);		
	}

	public List<Review> findByUserId(Long id) {
		return reviewRepo.findByUserId(id);
	}
	
	public List<Review> findByCulturalOfferId(Long id) {
		return reviewRepo.findByCulturalOfferId(id);
	}
	
	public Review create(ReviewDTO reviewDTO) {
		Review newReview = new Review();
		newReview.setUser(userService.findOne(reviewDTO.getUserId()));
		newReview.setCulturalOffer(coService.findById(reviewDTO.getCoId()));
        return reviewRepo.save(newReview);
	}
}
