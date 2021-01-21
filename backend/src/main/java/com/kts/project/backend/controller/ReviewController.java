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

import com.kts.project.backend.dto.ReviewDTO;
import com.kts.project.backend.model.Review;
import com.kts.project.backend.service.ReviewService;
import com.kts.project.backend.util.mapper.ReviewMapper;

@RestController
@RequestMapping(value="api/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	ReviewMapper reviewMapper = new ReviewMapper();
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ReviewDTO>> getAllReviews() {
        
		List<Review> allReviews = reviewService.getAll();
		//List<Review> allReviews = reviewService.findByCulturalOfferId(1L);
		return new ResponseEntity<>(toReviewDTOList(allReviews), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
        
		Review review = reviewService.findById(id);
        if(review == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviewMapper.toDto(review), HttpStatus.OK);
    }
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Review> deleteReview(@PathVariable Long id) {
		
		try {
			reviewService.delete(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ReviewDTO> createNewReview(@RequestBody ReviewDTO reviewDTO){
        
		Review newReview;
        try {
        	newReview = reviewService.create(reviewDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(reviewMapper.toDto(newReview), HttpStatus.CREATED);
    }
	
	private List<ReviewDTO> toReviewDTOList(List<Review> reviewList) {
        List<ReviewDTO> reviewDTOS = new ArrayList<>();
       
        for (Review review: reviewList) {
        	reviewDTOS.add(reviewMapper.toDto(review));
        }
        return reviewDTOS;
    }


}
